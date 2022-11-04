package cat.itacademy.barcelonactiva.GonzalezPonce.Julio.s05.t01.n01.model.dto;

import java.io.Serializable;

import java.util.Arrays;
import java.util.List;






public class SucursalDto implements Serializable{

	 private static final long serialVersionUID = 1L;
	 
	private Integer pk_SucursalID;
	
	 private String nomSucursal;
	
	 private String paisSucursal;
	 
	 private String tipusSucursal;
	 private List<String> paisos = Arrays.asList(
			 "Portugal","Alemania", "Bélgica", "Croacia",
			 "Dinamarca", "España", "Francia", "Irlanda", 
			 "Letonia", "Luxemburgo", "Países Bajos", "Suecia", 
			 "Bulgaria", "Eslovaquia", "Estonia", "Grecia", "Malta", 
			 "Polonia", "República Checa", "Austria", "Chipre", 
			 "Eslovenia", "Finlandia", "Hungría", "Italia", 
			 "Lituania","Rumanía");
	 
	 
	public SucursalDto(Integer pk_SucursalID, String nomSucursal, String paisSucursal) {
		super();
		this.pk_SucursalID = pk_SucursalID;
		this.nomSucursal = nomSucursal;
		this.paisSucursal = paisSucursal;
		this.tipusSucursal=getTipus(paisSucursal);
		
	}
	
	public SucursalDto() {}

	public Integer getPk_SucursalID() {
		return pk_SucursalID;
	}

	public void setPk_SucursalID(Integer pk_SucursalID) {
		this.pk_SucursalID = pk_SucursalID;
	}

	public String getNomSucursal() {
		return nomSucursal;
	}

	public void setNomSucursal(String nomSucursal) {
		this.nomSucursal = nomSucursal;
	}

	public String getPaisSucursal() {
		return paisSucursal;
	}

	public void setPaisSucursal(String paisSucursal) {
		this.paisSucursal = paisSucursal;
	}


	public String getTipusSucursal() {
		return tipusSucursal;
	}

	public void setTipusSucursal(String tipusSucursal) {
		this.tipusSucursal = getTipus(paisSucursal);
	}
	 
	 
	private String getTipus(String pais) {
		if (paisos.contains(pais)) {
			return "UE";
		}
		return "No UE";
	}
}
