package com.lab2.backend.repository;
import com.lab2.backend.model.Pdf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PdfRepository extends JpaRepository<Pdf, String> {

}
