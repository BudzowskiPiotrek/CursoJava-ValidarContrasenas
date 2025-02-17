public class Administrador extends Usuario {

	public Administrador(String nombreUsuario) {
		super(nombreUsuario);
	}

	// METODO REINICIAR CONTRASEÑA, EL ID DE USUARIO INGRESADO POR EL ADMINITRADOR
	// SE RESTABLECE SU CONTRASEÑA A NULL

	public void reiniciarContrasena(Usuario u) {
		u.contrasena = null;
	}

}
