package cat.itacademy.barcelonactiva.GonzalezPonce.Julio.s05.t01.n01.model.services;


import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.GonzalezPonce.Julio.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.GonzalezPonce.Julio.s05.t01.n01.model.dto.SucursalDto;
import cat.itacademy.barcelonactiva.GonzalezPonce.Julio.s05.t01.n01.model.repository.SucursalRepository;

@Service
public class SucursalServiceImpl implements SucursalService {
	
	@Autowired
	private SucursalRepository sucursalRepository;

	@Override
	public List<SucursalDto> listar() {
		List<Sucursal> EntityList = sucursalRepository.findAll();
		List<SucursalDto> dtoList = new ArrayList<>();
		
		for(Sucursal object: EntityList) {
			
			dtoList.add(convertDto(object));
		}
				
		return dtoList;
	}

	@Override
	public void guardar(Sucursal entity) {
		sucursalRepository.save(entity);

	}

	@Override
	public SucursalDto buscarPorId(int id) {	
		Sucursal sucursal = sucursalRepository.findById(id).isPresent() ? 
				sucursalRepository.findById(id).get():null;
		SucursalDto dto = null;
	
		if (sucursal != null) {
			dto = convertDto(sucursal);
		}
		
		return dto;
	}

	@Override
	public void eliminar(int id) {
		sucursalRepository.deleteById(id);

	}
	
	
	/*
	private Sucursal convert(SucursalDto dto) {
		Sucursal entity = new Sucursal();
		entity.setPk_SucursalID(dto.getPk_SucursalID());
		entity.setNomSucursal(dto.getNomSucursal());
		entity.setPaisSucursal(dto.getPaisSucursal());
		return entity;
	}
	*/
	private SucursalDto convertDto(Sucursal entity) {
		SucursalDto dto = new SucursalDto();
			
			dto.setPk_SucursalID(entity.getPk_SucursalID());
			dto.setNomSucursal(entity.getNomSucursal());
			dto.setPaisSucursal(entity.getPaisSucursal());
			dto.setTipusSucursal(dto.getTipusSucursal());
		
		return dto;
	
	}



}
