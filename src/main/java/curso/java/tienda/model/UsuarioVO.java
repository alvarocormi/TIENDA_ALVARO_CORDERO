package curso.java.tienda.model;

import lombok.Data;

@Data
public class UsuarioVO {

	private int id;
	private int rol_id;
	private String email;
	private String clave;
	private String nombre;
	private String apellidos;
	private int baja;
	private String direccion;
	private String cp;

	public UsuarioVO() {
		super();
	}

	public UsuarioVO(int id, int rol_id, String email, String clave, String nombre, String apellidos, int baja,
			String direccion, String cp) {
		super();
		this.id = id;
		this.rol_id = rol_id;
		this.email = email;
		this.clave = clave;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.baja = baja;
		this.direccion = direccion;
		this.cp = cp;
	}

	public UsuarioVO(String email) {
		super();
		this.email = email;
	}

}
