package curso.java.tienda.service;

import curso.java.tienda.model.UsuarioVO;


public class UsuarioService {
    
    public UsuarioService() {
    }
    
    public static UsuarioVO agregarUsuario(String email) {
        UsuarioVO u = new UsuarioVO(email);
        return u;
    }
}
