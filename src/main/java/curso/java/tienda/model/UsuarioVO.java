package curso.java.tienda.model;

import lombok.Data;

@Data
public class UsuarioVO {

	private int id;
	private int rolId;
	private String email;
	private String clave;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String direccion;
	private String localidad;
	private String provincia;
	private String telefono;
	private String dni;
	
	public UsuarioVO() {
		super();
	}
	

	public UsuarioVO(String email) {
		super();
		this.email = email;
	}




	public UsuarioVO(int id, int rolId, String email, String clave, String nombre, String apellido1, String apellido2,
			String direccion, String localidad, String provincia, String telefono, String dni) {
		this.id = id;
		this.rolId = rolId;
		this.email = email;
		this.clave = clave;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.direccion = direccion;
		this.localidad = localidad;
		this.provincia = provincia;
		this.telefono = telefono;
		this.dni = dni;
	}

}
