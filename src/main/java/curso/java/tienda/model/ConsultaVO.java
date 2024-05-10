package curso.java.tienda.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ConsultaVO {
	
	private int id;
	private String name;
	private String apellido;
	private String email;
	private String mensaje;
	
	public ConsultaVO(String name, String apellido, String email, String mensaje) {
		this.name = name;
		this.apellido = apellido;
		this.email = email;
		this.mensaje = mensaje;
	}
	
	
}
