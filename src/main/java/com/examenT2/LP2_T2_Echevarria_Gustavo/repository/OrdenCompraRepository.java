package com.examenT2.LP2_T2_Echevarria_Gustavo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.examenT2.LP2_T2_Echevarria_Gustavo.model.OrdenCompra;

public interface OrdenCompraRepository extends JpaRepository<OrdenCompra, Integer> {
	List<OrdenCompra> findAllByOrderByNroOrdenDesc();
}