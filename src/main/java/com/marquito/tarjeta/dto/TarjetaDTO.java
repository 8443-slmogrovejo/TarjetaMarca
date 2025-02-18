package com.marquito.tarjeta.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TarjetaDTO {
    
    private String codTarjeta;

    @NotBlank(message = "El SWIFT del banco es requerido")
    @Size(min = 8, max = 11, message = "El SWIFT debe tener entre 8 y 11 caracteres")
    private String swiftBanco;

    @NotBlank(message = "El tipo de documento es requerido")
    @Size(min = 2, max = 3, message = "El tipo de documento debe tener entre 2 y 3 caracteres")
    private String tipoDocumentoCliente;

    @NotBlank(message = "El número de documento es requerido")
    @Size(max = 15, message = "El número de documento no debe exceder 15 caracteres")
    private String numeroDocumentoCliente;

    @NotBlank(message = "El nombre del cliente es requerido")
    @Size(max = 100, message = "El nombre no debe exceder 100 caracteres")
    private String nombreCliente;

    @NotBlank(message = "El país del cliente es requerido")
    @Size(min = 2, max = 2, message = "El código de país debe tener 2 caracteres")
    private String paisCliente;

    @NotBlank(message = "El correo del cliente es requerido")
    @Email(message = "El formato del correo no es válido")
    @Size(max = 100, message = "El correo no debe exceder 100 caracteres")
    private String correoCliente;

    @NotBlank(message = "El ID del cliente en el banco es requerido")
    @Size(max = 40, message = "El ID del cliente no debe exceder 40 caracteres")
    private String idClienteBanco;

    @NotBlank(message = "El número de tarjeta es requerido")
    @Pattern(regexp = "^[0-9]{16}$", message = "El número de tarjeta debe tener 16 dígitos numéricos")
    private String numeroTarjeta;

    private LocalDateTime fechaEmision;
    
    private LocalDate fechaCaducidad;

    @NotBlank(message = "El CVV es requerido")
    @Size(max = 100, message = "El CVV no debe exceder 100 caracteres")
    private String cvv;

    @NotBlank(message = "El estado es requerido")
    @Pattern(regexp = "^(ACT|INA|BLO|SUS)$", message = "El estado debe ser ACT, INA, BLO o SUS")
    @Size(max = 3, message = "El estado no debe exceder 3 caracteres")
    private String estado;
} 