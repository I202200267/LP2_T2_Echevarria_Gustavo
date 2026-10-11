package com.examenT2.LP2_T2_Echevarria_Gustavo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.examenT2.LP2_T2_Echevarria_Gustavo.model.OrdenCompra;
import com.examenT2.LP2_T2_Echevarria_Gustavo.service.OrdenCompraService;
import com.examenT2.LP2_T2_Echevarria_Gustavo.service.ProveedorService;
import com.examenT2.LP2_T2_Echevarria_Gustavo.util.Alert;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("ordencompra")
@RequiredArgsConstructor
public class OrdenCompraController {

	private final OrdenCompraService ordenCompraService;
	private final ProveedorService proveedorService;

	@GetMapping("listado")
	public String listado(Model model) {
		model.addAttribute("lstOrdenes", ordenCompraService.getAll());
		return "ordencompra/listadoEchevarriaGustavo";
	}

	@GetMapping("nuevo")
	public String nuevo(Model model) {
		model.addAttribute("lstProveedor", proveedorService.getAll());
		model.addAttribute("ordenCompra", new OrdenCompra());
		return "ordencompra/nuevoEchevarriaGustavo";
	}

	@PostMapping("registrar")
	public String registrar(@ModelAttribute OrdenCompra ordenCompra, RedirectAttributes flash) {
		var response = ordenCompraService.create(ordenCompra);
		flash.addFlashAttribute("alert", Alert.sweetToast(response.mensaje(), "success", 10000));
		return "redirect:/ordencompra/listado";
	}

	@GetMapping("edicion/{id}")
	public String edicion(@PathVariable Integer id, Model model) {
		model.addAttribute("lstProveedor", proveedorService.getAll());
		model.addAttribute("ordenCompra", ordenCompraService.getOne(id));
		return "ordencompra/edicionEchevarriaGustavo";
	}

	@PostMapping("guardar")
	public String guardar(@ModelAttribute OrdenCompra ordenCompra, RedirectAttributes flash) {
		var response = ordenCompraService.update(ordenCompra);
		flash.addFlashAttribute("alert", Alert.sweetToast(response.mensaje(), "success", 10000));
		return "redirect:/ordencompra/listado";
	}
}

