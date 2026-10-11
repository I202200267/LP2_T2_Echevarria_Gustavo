package com.examenT2.LP2_T2_Echevarria_Gustavo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.examenT2.LP2_T2_Echevarria_Gustavo.model.Rubro;
import com.examenT2.LP2_T2_Echevarria_Gustavo.repository.RubroRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RubroService {
	private final RubroRepository rubroRepository;

	public List<Rubro> getAll() {
		return rubroRepository.findAll();
	}
}