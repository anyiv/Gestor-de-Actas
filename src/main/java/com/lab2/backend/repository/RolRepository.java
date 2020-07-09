package com.lab2.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lab2.backend.model.ERole;
import com.lab2.backend.model.Role;

@Repository
public interface RolRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
