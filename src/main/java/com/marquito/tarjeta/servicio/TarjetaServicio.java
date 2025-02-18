package com.marquito.tarjeta.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.marquito.tarjeta.excepcion.NotFoundException;
import com.marquito.tarjeta.modelo.Tarjeta;
import com.marquito.tarjeta.repositorio.TarjetaRepositorio;

@Service
public class TarjetaServicio {

    public static final String ENTITY_NAME = "Tarjeta";
    
    private final TarjetaRepositorio repositorio;

    public TarjetaServicio(TarjetaRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public List<Tarjeta> buscarTodos() {
        return this.repositorio.findAll();
    }

    public Tarjeta buscarPorId(String codTarjeta) {
        return this.repositorio.findById(codTarjeta)
            .orElseThrow(() -> new NotFoundException(codTarjeta, ENTITY_NAME));
    }

    public Tarjeta buscarPorNumeroTarjeta(String numeroTarjeta) {
        return this.repositorio.findByNumeroTarjeta(numeroTarjeta)
            .orElseThrow(() -> new NotFoundException(numeroTarjeta, ENTITY_NAME));
    }
}
