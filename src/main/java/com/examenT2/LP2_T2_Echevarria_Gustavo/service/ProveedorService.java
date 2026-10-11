package com.examenT2.LP2_T2_Echevarria_Gustavo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.examenT2.LP2_T2_Echevarria_Gustavo.model.Proveedor;
import com.examenT2.LP2_T2_Echevarria_Gustavo.repository.ProveedorRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProveedorService {
	private final ProveedorRepository proveedorRepository;

	public List<Proveedor> getAll() {
		return proveedorRepository.findAll();
	}
}