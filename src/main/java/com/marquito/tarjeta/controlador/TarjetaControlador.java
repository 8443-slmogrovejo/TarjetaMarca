package com.marquito.tarjeta.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marquito.tarjeta.dto.TarjetaDTO;
import com.marquito.tarjeta.excepcion.NotFoundException;
import com.marquito.tarjeta.mapper.TarjetaMapper;
import com.marquito.tarjeta.modelo.Tarjeta;
import com.marquito.tarjeta.servicio.TarjetaServicio;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/tarjetas")
@Slf4j
public class TarjetaControlador {

    private final TarjetaServicio servicio;
    private final TarjetaMapper mapper;

    public TarjetaControlador(TarjetaServicio servicio, TarjetaMapper mapper) {
        this.servicio = servicio;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<TarjetaDTO>> obtenerTodos() {
        List<Tarjeta> tarjetas = this.servicio.buscarTodos();
        List<TarjetaDTO> dtos = new ArrayList<>(tarjetas.size());
        log.info("Se encontraron {} tarjetas", tarjetas.size());
        for(Tarjeta tarjeta : tarjetas) {
            dtos.add(mapper.toDTO(tarjeta));
        }
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{codTarjeta}")
    public ResponseEntity<TarjetaDTO> obtenerPorId(@PathVariable("codTarjeta") String codTarjeta) {
        try {
            Tarjeta tarjeta = this.servicio.buscarPorId(codTarjeta);
            log.info("Se encontró la tarjeta con código: {}", codTarjeta);
            return ResponseEntity.ok(this.mapper.toDTO(tarjeta));
        } catch (NotFoundException e) {
            log.error("No se encontró la tarjeta con código: {}", codTarjeta);
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/numero/{numeroTarjeta}")
    public ResponseEntity<TarjetaDTO> obtenerPorNumero(@PathVariable("numeroTarjeta") String numeroTarjeta) {
        try {
            Tarjeta tarjeta = this.servicio.buscarPorNumeroTarjeta(numeroTarjeta);
            log.info("Se encontró la tarjeta con número: {}", numeroTarjeta);
            return ResponseEntity.ok(this.mapper.toDTO(tarjeta));
        } catch (NotFoundException e) {
            log.error("No se encontró la tarjeta con número: {}", numeroTarjeta);
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<TarjetaDTO> crear(@Valid @RequestBody TarjetaDTO dto) {
        try {
            Tarjeta tarjeta = this.servicio.crear(this.mapper.toModel(dto));
            log.info("Se creó la tarjeta con código: {}", tarjeta.getCodTarjeta());
            return ResponseEntity.ok(this.mapper.toDTO(tarjeta));
        } catch (Exception e) {
            log.error("Error al crear la tarjeta", e);
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{codTarjeta}")
    public ResponseEntity<TarjetaDTO> actualizar(
            @PathVariable("codTarjeta") String codTarjeta,
            @RequestBody String estado) {
        try {
            Tarjeta tarjeta = this.servicio.buscarPorId(codTarjeta);
            tarjeta.setEstado(estado);
            tarjeta = this.servicio.actualizar(tarjeta);
            log.info("Se actualizó el estado de la tarjeta {}", codTarjeta);
            return ResponseEntity.ok(this.mapper.toDTO(tarjeta));
        } catch (NotFoundException e) {
            log.error("No se encontró la tarjeta con código: {}", codTarjeta);
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            log.error("Error al actualizar la tarjeta", e);
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{codTarjeta}")
    public ResponseEntity<Void> eliminar(@PathVariable("codTarjeta") String codTarjeta) {
        try {
            this.servicio.eliminar(codTarjeta);
            log.info("Se eliminó la tarjeta con código: {}", codTarjeta);
            return ResponseEntity.ok().build();
        } catch (NotFoundException e) {
            log.error("No se encontró la tarjeta con código: {}", codTarjeta);
            return ResponseEntity.notFound().build();
        }
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> manejarNotFoundException(NotFoundException e) {
        log.error(e.getMessage(), e);
        return ResponseEntity.notFound().build();
    }
}
