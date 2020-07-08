package com.lab2.backend.service;

import com.lab2.backend.exception.FileStorageException;
import com.lab2.backend.exception.MyFileNotFoundException;
import com.lab2.backend.model.Pdf;
import com.lab2.backend.repository.PdfRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@Service
public class PdfService {

    @Autowired
    private PdfRepository pdfRepository;

    public Pdf storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            Pdf pdf = new Pdf(fileName, file.getContentType(), file.getBytes());

            return pdfRepository.save(pdf);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public Pdf getFile(String fileId) {
        return pdfRepository.findById(fileId)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " + fileId));
    }
}
