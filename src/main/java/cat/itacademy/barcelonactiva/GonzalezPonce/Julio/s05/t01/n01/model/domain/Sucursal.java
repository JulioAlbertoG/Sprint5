package cat.itacademy.barcelonactiva.GonzalezPonce.Julio.s05.t01.n01.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;



@Entity
@Table(name="sucursales")
public class Sucursal implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer pk_SucursalID;
	
	
	
	@Column(name="nom")
	@NotEmpty
	String nomSucursal;
	
	@Column(name="pais")
	@NotEmpty
	String paisSucursal;
	
	public Sucursal() {}
	
	public Sucursal(String nomSucursal, String paisSucursal) {
		this.nomSucursal = nomSucursal;
		this.paisSucursal = paisSucursal;
	}
	

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

	@Override
	public String toString() {
		return "Sucursal id: " + pk_SucursalID + ", nombre de la sucursal=" + nomSucursal + ", país="
				+ paisSucursal + "]";
	}
	
	
}
