package com.examenT2.LP2_T2_Echevarria_Gustavo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.examenT2.LP2_T2_Echevarria_Gustavo.dto.ResultadoResponse;
import com.examenT2.LP2_T2_Echevarria_Gustavo.model.OrdenCompra;
import com.examenT2.LP2_T2_Echevarria_Gustavo.repository.OrdenCompraRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrdenCompraService {
	private final OrdenCompraRepository ordenCompraRepository;

	public List<OrdenCompra> getAll() {
		return ordenCompraRepository.findAllByOrderByNroOrdenDesc();
	}

	@Transactional
	public ResultadoResponse create(OrdenCompra ordenCompra) {
		try {
			var registrado = ordenCompraRepository.save(ordenCompra);
			var mensaje = String.format("Orden de compra Nro. %d registrada.", registrado.getNroOrden());
			return new ResultadoResponse(true, mensaje);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultadoResponse(false, "Hubo un error en la transacción");
		}
	}

	public OrdenCompra getOne(Integer id) {
		return ordenCompraRepository.findById(id).orElse(null);
	}

	@Transactional
	public ResultadoResponse update(OrdenCompra ordenCompra) {
		try {
			var registrado = ordenCompraRepository.save(ordenCompra);
			var mensaje = String.format("Orden de compra Nro. %d actualizada.", registrado.getNroOrden());
			return new ResultadoResponse(true, mensaje);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultadoResponse(false, "Hubo un error en la transacción");
		}
	}
}
