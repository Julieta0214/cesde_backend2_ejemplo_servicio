package com.example.demo_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo_service.model.entity.Proveedor;
import com.example.demo_service.repository.ProveedorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProveedorService {

    private final ProveedorRepository proveedorRepository;

    // LISTAR TODOS
    public List<Proveedor> listar() {
        return proveedorRepository.findAll();
    }

    // BUSCAR POR ID
    public Proveedor buscarPorId(Long id) {
        return proveedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado con id: " + id));
    }

    // GUARDAR CON VALIDACIÓN
    public Proveedor guardar(Proveedor proveedor) {

        validarTelefono(proveedor.getTelefono());

        return proveedorRepository.save(proveedor);
    }

    // ELIMINAR
    public void eliminar(Long id) {
        if (!proveedorRepository.existsById(id)) {
            throw new RuntimeException("No existe el proveedor con id: " + id);
        }
        proveedorRepository.deleteById(id);
    }

    // BUSCAR POR NOMBRE (REQUERIDO POR LA ACTIVIDAD)
    public List<Proveedor> buscarPorNombre(String nombre) {
        return proveedorRepository.findByNombreContainingIgnoreCase(nombre);
    }

    // VALIDACIÓN DE NEGOCIO (10 DÍGITOS)
    private void validarTelefono(String telefono) {

        if (telefono == null) {
            throw new RuntimeException("El teléfono no puede ser nulo");
        }

        if (!telefono.matches("\\d{10}")) {
            throw new RuntimeException("El teléfono debe tener exactamente 10 dígitos");
        }
    }
}