package com.example.demo_service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_service.model.entity.Proveedor;
import com.example.demo_service.service.ProveedorService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/proveedores")
@RequiredArgsConstructor
public class ProveedorController {

    private final ProveedorService proveedorService;

    // GUARDAR
    @PostMapping
    public Proveedor guardar(@RequestBody Proveedor proveedor) {
        return proveedorService.guardar(proveedor);
    }

    // LISTAR TODOS
    @GetMapping
    public List<Proveedor> listar() {
        return proveedorService.listar();
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public Proveedor buscar(@PathVariable Long id) {
        return proveedorService.buscarPorId(id);
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        proveedorService.eliminar(id);
    }

    // BUSCAR POR NOMBRE (REQUERIDO POR LA ACTIVIDAD)
    @GetMapping("/buscar")
    public List<Proveedor> buscarPorNombre(@RequestParam String nombre) {
        return proveedorService.buscarPorNombre(nombre);
    }
}