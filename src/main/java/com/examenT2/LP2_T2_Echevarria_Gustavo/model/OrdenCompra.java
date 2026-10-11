package com.examenT2.LP2_T2_Echevarria_Gustavo.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tbl_orden_compra")
@Getter
@Setter

public class OrdenCompra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nro_orden")
	private Integer nroOrden;

	@ManyToOne
	@JoinColumn(name = "id_proveedor")
	private Proveedor proveedor;

	@Column(name = "monto")
	private BigDecimal monto;

	@Column(name = "direccion_entrega")
	private String direccionEntrega;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fecha_entrega")
	private LocalDate fechaEntrega;

	@Column(name = "estado")
	private String estado = "P";

	public String getEstadoDescripcion() {
		if (estado == null)
			return "Pendiente";
		return switch (estado) {
			case "C" -> "Completado";
			case "A" -> "Anulado";
			default -> "Pendiente";
		};
	}
}