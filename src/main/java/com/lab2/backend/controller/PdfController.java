package com.lab2.backend.controller;

import com.lab2.backend.model.Acta;
import com.lab2.backend.model.Pdf;
import com.lab2.backend.payload.UploadFileResponse;
import com.lab2.backend.service.ActaService;
import com.lab2.backend.service.PdfService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/pdf")
public class PdfController {

    private static final Logger logger = LoggerFactory.getLogger(PdfController.class);

    @Autowired
    private PdfService pdfService;
    @Autowired
    private ActaService actaService;

    @PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
        Pdf pdf = pdfService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(pdf.getId())
                .toUriString();
        Acta acta = actaService.findTopByOrderByCodigoDesc();
        System.out.println(acta.getDescripcion());
        System.out.println(pdf.getFileName());
        acta.setPdf(pdf);
        actaService.save(acta);
        return new UploadFileResponse(pdf.getFileName(), fileDownloadUri,
                file.getContentType(), file.getSize());
    }

    @PostMapping("/uploadMultipleFiles")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
    }

    @GetMapping("/downloadFile/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) {
        // Load file from database
        Pdf pdf = pdfService.getFile(fileId);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(pdf.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + pdf.getFileName() + "\"")
                .body(new ByteArrayResource(pdf.getData()));
    }

}
