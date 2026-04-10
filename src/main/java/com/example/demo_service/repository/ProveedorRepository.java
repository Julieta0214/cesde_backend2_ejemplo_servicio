package com.example.demo_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo_service.model.entity.Proveedor;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {

    // Búsqueda por nombre (ignore case)
    List<Proveedor> findByNombreContainingIgnoreCase(String nombre);
}