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
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
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
