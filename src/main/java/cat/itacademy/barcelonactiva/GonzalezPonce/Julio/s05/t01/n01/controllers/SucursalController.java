package cat.itacademy.barcelonactiva.GonzalezPonce.Julio.s05.t01.n01.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cat.itacademy.barcelonactiva.GonzalezPonce.Julio.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.GonzalezPonce.Julio.s05.t01.n01.model.dto.SucursalDto;
import cat.itacademy.barcelonactiva.GonzalezPonce.Julio.s05.t01.n01.model.services.SucursalService;

@Controller
@RequestMapping("/sucursal")
@CrossOrigin(origins = "http://localhost:9000")
public class SucursalController {

	@Autowired
	private SucursalService sucursalService;
	

	@GetMapping("/add")
	public String create(Model model) {
		Sucursal sucursal= new Sucursal();
		model.addAttribute("titulo", "Formulario: Nueva Sucursal");
		model.addAttribute("sucursal", sucursal);
		
		return "sucursal/crear";
	}
	
	@PostMapping("/save")
	public String guardar(@Valid @ModelAttribute Sucursal sucursal, BindingResult result,
			Model model, RedirectAttributes attribute) {
		
		if(result.hasErrors()) {
			
			model.addAttribute("titulo", "Formulario: Nueva Sucursal");
			model.addAttribute("sucursal", sucursal);

			return "sucursal/crear";
			
		}
		sucursalService.guardar(sucursal);
		attribute.addFlashAttribute("success", "Sucursal guardada con éxito");
		return "redirect:/sucursal/getAll";
	}
	
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable ("id") int idSucursal,Model model,RedirectAttributes attribute) {
		
		SucursalDto  sucursal = null;
		
		if(idSucursal > 0) {
			sucursal = sucursalService.buscarPorId(idSucursal);
			
			if (sucursal == null) {
				
				attribute.addFlashAttribute("error", "ATENCIÓN: La sucursal no existe");
				return "redirect:/sucursal/getAll";
			}
		}else {
			
			attribute.addFlashAttribute("error", "ATENCIÓN: Error con el ID de la sucursal");
			return "redirect:/sucursal/getAll";
		}
		
		model.addAttribute("titulo", "Formulario: Editar Sucursal");
		model.addAttribute("sucursal", sucursal);
		
		return "sucursal/crear";
	}

	
	@GetMapping("/getAll")
	public String getAll(Model model) {
		
		List<SucursalDto> sucursalDtos = sucursalService.listar();
//El model nos permite enviar los datos requeridos a la vista en html
//Se envían dos parámetros key-value para ser recibidos por el html
		model.addAttribute("titulo", "lista de sucursales");
		model.addAttribute("sucursales", sucursalDtos);
		
		return "sucursal/listar";
	}

	@GetMapping("getOne/{id}")
	public String getOne(@PathVariable("id") int idSucursal, Model model) {
		
		SucursalDto sucursal =sucursalService.buscarPorId(idSucursal);
		
		model.addAttribute("titulo", "una sucursal");
		model.addAttribute("entidad", sucursal);
		
		return "sucursal/getOne";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable ("id") int idSucursal, RedirectAttributes attribute) {
		sucursalService.eliminar(idSucursal);
		attribute.addFlashAttribute("warning", "ATENCIÓN: Se ha eliminado un registro");
		
		return "redirect:/sucursal/getAll";
	}
}

	
