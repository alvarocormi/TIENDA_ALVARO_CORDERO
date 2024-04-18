package curso.java.tienda.service;

import java.sql.SQLException;
import java.util.regex.Pattern;

import org.mindrot.jbcrypt.BCrypt;

import curso.java.tienda.dao.UsuarioDAO;
import curso.java.tienda.model.UsuarioVO;

public class UsuarioService {

	public UsuarioService() {
	}

	public static UsuarioVO agregarUsuarioEmail(String email) {
		UsuarioVO u = new UsuarioVO(email);
		return u;
	}

	public static UsuarioVO recuperarUsuario(String email) {
		return UsuarioDAO.recuperarUsuarioPorEmail(email);

	}
	
	public static boolean editarUsuario(String nombre, String apellido1, String apellido2, String direccion,
			String dni, String email , String localidad, String provincia, String telefono) {
		try {
			if(UsuarioDAO.editarUsuario(nombre, apellido1, apellido2, direccion, dni, email, localidad, provincia, telefono)) {
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		return false;

	}

	// Método para validar el formulario
	public static boolean comprobarVacios(String email, String clave, String claveRepetida) {
		if (email == null || email.trim().isEmpty() || clave == null || clave.trim().isEmpty() || claveRepetida == null
				|| claveRepetida.trim().isEmpty()) {
			return false; // Campos vacíos
		}
		return true; // Todo validado correctamente
	}

	// Método para validar el formato del email con una expresión regular
	public static boolean validarEmail(String email) {
		String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		Pattern pattern = Pattern.compile(regex);
		return pattern.matcher(email).matches();
	}

	public static boolean validarClaves(String clave, String claveRepetida) {
		// Validar que las claves sean iguales
		if (!clave.equals(claveRepetida)) {
			return false;
		}

		return true;

	}

	public static boolean verificarCredenciales(String email, String clave) {
		if (UsuarioDAO.verificarCredenciales(email, clave)) {
			return true;
		}

		return false;
	}

	public static boolean agregarDatosEnvio(String nombre, String apellido1, String apellido2, String direccion,
			String telefono, String email) {
		try {
			UsuarioDAO.agregarDatosEnvio(nombre, apellido1, apellido2, direccion, telefono, email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;

	}
	
	public static String encriptarClave(String clave) {
		String claveEncriptada ;
		
		// Generar hash de contraseña
        claveEncriptada = BCrypt.hashpw(clave, BCrypt.gensalt());
		
		return claveEncriptada;
	}
	
	public static boolean compararClaves(String clave, String claveEncriptada) {
		if(BCrypt.checkpw(clave, claveEncriptada)) {
			return true;
		}
		return false;
		
	}
	
	public static boolean cambiarClave(String nuevaClave,String email) {
		String nuevaClaveCodificada=encriptarClave(nuevaClave);
		UsuarioDAO.cambiarClave(nuevaClaveCodificada, email);
		return true;
	}

}
