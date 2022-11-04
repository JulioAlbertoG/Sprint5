package cat.itacademy.barcelonactiva.GonzalezPonce.Julio.s05.t01.n01.model.services;

import java.util.List;


import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.GonzalezPonce.Julio.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.GonzalezPonce.Julio.s05.t01.n01.model.dto.SucursalDto;

@Service
public interface SucursalService {

	public List<SucursalDto> listar();
	public void guardar(Sucursal entity);
	public SucursalDto buscarPorId(int id);
	public void eliminar(int id);
	
	
	
}
