package validacionUsuario;

public class Administrador extends Usuario {

	public Administrador(String nombreUsuario) {
		super(nombreUsuario);
						
	}
	
	public boolean reiniciarContrasena(Usuario u) {
		boolean exito = true;
		u.contrasena="00000000";
		return exito;
				
	}

}
