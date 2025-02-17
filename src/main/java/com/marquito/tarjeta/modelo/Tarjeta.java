package com.marquito.tarjeta.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "TARJETA")
public class Tarjeta implements Serializable {

    @Id
    @Column(name = "COD_TARJETA", length = 10)
    private String codTarjeta;

    @NotNull
    @Column(name = "SWIFT_BANCO", length = 11, nullable = false)
    private String swiftBanco;

    @NotNull
    @Column(name = "TIPO_DOCUMENTO_CLIENTE", length = 3, nullable = false)
    private String tipoDocumentoCliente;

    @NotNull
    @Column(name = "NUMERO_DOCUMENTO_CLIENTE", length = 15, nullable = false)
    private String numeroDocumentoCliente;

    @NotNull
    @Column(name = "NOMBRE_CLIENTE", length = 100, nullable = false)
    private String nombreCliente;

    @NotNull
    @Column(name = "PAIS_CLIENTE", length = 2, nullable = false)
    private String paisCliente;

    @NotNull
    @Column(name = "CORREO_CLIENTE", length = 100, nullable = false)
    private String correoCliente;

    @NotNull
    @Column(name = "ID_CLIENTE_BANCO", length = 40, nullable = false)
    private String idClienteBanco;

    @NotNull
    @Column(name = "NUMERO_TARJETA", length = 16, nullable = false)
    private String numeroTarjeta;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FECHA_EMISION", nullable = false)
    private LocalDateTime fechaEmision;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_CADUCIDAD", nullable = false)
    private LocalDate fechaCaducidad;

    @NotNull
    @Column(name = "CVV", length = 100, nullable = false)
    private String cvv;

    @NotNull
    @Column(name = "ESTADO", length = 3, nullable = false)
    private String estado;

    public Tarjeta() {
    }

    public String getCodTarjeta() {
        return codTarjeta;
    }

    public void setCodTarjeta(String codTarjeta) {
        this.codTarjeta = codTarjeta;
    }

    public String getSwiftBanco() {
        return swiftBanco;
    }

    public void setSwiftBanco(String swiftBanco) {
        this.swiftBanco = swiftBanco;
    }

    public String getTipoDocumentoCliente() {
        return tipoDocumentoCliente;
    }

    public void setTipoDocumentoCliente(String tipoDocumentoCliente) {
        this.tipoDocumentoCliente = tipoDocumentoCliente;
    }

    public String getNumeroDocumentoCliente() {
        return numeroDocumentoCliente;
    }

    public void setNumeroDocumentoCliente(String numeroDocumentoCliente) {
        this.numeroDocumentoCliente = numeroDocumentoCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getPaisCliente() {
        return paisCliente;
    }

    public void setPaisCliente(String paisCliente) {
        this.paisCliente = paisCliente;
    }

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }

    public String getIdClienteBanco() {
        return idClienteBanco;
    }

    public void setIdClienteBanco(String idClienteBanco) {
        this.idClienteBanco = idClienteBanco;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public LocalDateTime getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDateTime fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codTarjeta == null) ? 0 : codTarjeta.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Tarjeta other = (Tarjeta) obj;
        if (codTarjeta == null) {
            if (other.codTarjeta != null)
                return false;
        } else if (!codTarjeta.equals(other.codTarjeta))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Tarjeta [codTarjeta=" + codTarjeta + ", swiftBanco=" + swiftBanco + ", tipoDocumentoCliente="
                + tipoDocumentoCliente + ", numeroDocumentoCliente=" + numeroDocumentoCliente + ", nombreCliente="
                + nombreCliente + ", paisCliente=" + paisCliente + ", correoCliente=" + correoCliente + ", idClienteBanco="
                + idClienteBanco + ", numeroTarjeta=" + numeroTarjeta + ", fechaEmision=" + fechaEmision
                + ", fechaCaducidad=" + fechaCaducidad + ", cvv=" + cvv + ", estado=" + estado + "]";
    }
}
