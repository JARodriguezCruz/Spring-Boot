package com.ebac.modulo63.controller;

import com.ebac.modulo63.model.Producto;
import com.ebac.modulo63.service.ProductoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.verification.VerificationMode;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ProductoControllerTest {

    @Mock
    private ProductoService productoService;

    @InjectMocks
    private ProductoController productoController;

    private Producto producto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        producto = new Producto("Laptop", 15000.0);
        producto.setId(1L);
    }


    // GET TODOS

    @Test
    void testObtenerTodos() {
        when(productoService.obtenerTodos())
                .thenReturn(Arrays.asList(producto));

        var resultado = productoController.obtenerTodos();

        assertEquals(1, resultado.size());
        verify(productoService, times(1)).obtenerTodos();
    }

    private ProductoService verify(ProductoService productoService, Object times) {
        return null;
    }

    private VerificationMode times(int i) {
        return null;
    }


    // GET POR ID

    @Test
    void testObtenerPorId() {
        when(productoService.obtenerPorId(1L))
                .thenReturn(Optional.of(producto));

        var resultado = productoController.obtenerPorId(1L);

        assertNotNull(resultado);
        assertEquals("Laptop", resultado.getNombre());
        verify(productoService, times(1)).obtenerPorId(1L);
    }


    // POST CREAR

    @Test
    void testCrearProducto() {
        when(productoService.crear(producto))
                .thenReturn(producto);

        var resultado = productoController.crear(producto);

        assertNotNull(resultado);
        verify(productoService, times(1)).crear(producto);
    }


    // PUT ACTUALIZAR

    @Test
    void testActualizarProducto() {
        when(productoService.actualizar(1L, producto))
                .thenReturn(producto);

        var resultado = productoController.actualizar(1L, producto);

        equals("Laptop");
        verify(productoService, times(1))
                .actualizar(1L, producto);
    }

    // DELETE

    @Test
    void testEliminarProducto() {
        doNothing().when(productoService).eliminar(1L);

        productoController.eliminar(1L);

        verify(productoService, times(1)).eliminar(1L);
    }
}
