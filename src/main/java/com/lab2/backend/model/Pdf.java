package com.lab2.backend.model;

import org.hibernate.annotations.GenericGenerator;
import lombok.Data;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lab2.backend.model.Acta;
import javax.persistence.OneToOne;


@Entity
@Data
public class Pdf {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String fileName;

    private String fileType;

    @JsonIgnore
    @OneToOne(mappedBy = "pdf")
	private Acta acta;

    @JsonIgnore
    @Lob
    private byte[] data;

    public Pdf() {

    }

    public Pdf(String fileName, String fileType, Acta acta, byte[] data) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.acta = acta;
        this.data = data;
    }

    public Pdf(String fileName, String fileType, byte[] data) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return this.fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public byte[] getData() {
        return this.data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public Acta getActa() {
        return this.acta;
    }

    public void setActa(Acta acta) {
        this.acta = acta;
    }


    
}