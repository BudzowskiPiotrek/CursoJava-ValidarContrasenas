package validacionUsuario;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Usuario {

	// CLASE USUARIO CON SUS TRES VARIABLES
	protected String nombreUsuario;
	protected String contrasena;
	protected String[] tresContrasenas;

	// CREO UN CONSTRUCTOR QUE PEDIRA SOLAMENTE EL NOMBRE DE USUARIO, Y EJECUTARA
	// METODO DE PEDIR
	// CONTRASEÑA QUE DESAROLLARE EN SETCONTRASENA PARA PODER UTILIZARLO DE NUEVO EN
	// MOMENTO DE CAMBIAR
	// LA CONTRASEÑA.

	public Usuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
		this.tresContrasenas = new String[3];
		setContrasena();

	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	// DESAROLLO UN METODO QUE PRIMERO CON UNA EXPRESION REGULAR COMPROBARA SI LA
	// CONTRASEÑA TIENE
	// EN ALGUN LADO AL MENOS UN CARACTER EN MAYUSCULA, EN ALGUN LADO AL MENOS UN
	// NUMERO, EN ALGUN
	// PARTE UN SIGNO RARO, Y AL MENOS 8 CARACTERES, POSTERIORMENTE CREO UN BUCLE
	// QUE SI NO SE CUMPLE
	// O ESTA REPETIDA, EN LAS TRES ANTERIORES CONTRASEÑAS VALIDAS, VOLVERA A PEDIR
	// UNA Y OTRA VEZ
	// PARA AQUELLO CREO DOS METODOS MAS.

	public void setContrasena() {
		Scanner sn = new Scanner(System.in);
		String nuevaContrasena;
		String expresion = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
		Pattern p = Pattern.compile(expresion);
		boolean seguro = true;

		while (seguro) {
			nuevaContrasena = sn.nextLine();
			Matcher m = p.matcher(nuevaContrasena);

			if (m.matches() && contrasenaRepetida(nuevaContrasena)) {
				this.contrasena = nuevaContrasena;
				actualizarTresContrasenas(nuevaContrasena);
				seguro = false;
			} else {
				throw new IllegalArgumentException();
			}
		}
	}

	public String[] getTresContrasenas() {
		return tresContrasenas;
	}

	public void setTresContrasenas(String[] tresContrasenas) {
		this.tresContrasenas = tresContrasenas;
	}

	// PRIMERO DE ELLOS ES SOLO PARA RECORER ARRAY DE TRES ULTIMAS CONTRASEÑAS Y SI
	// ENCUENTRA QUE ESTA
	// IGUAL DEVOLVERA FALLO DE OPERACION.

	private boolean contrasenaRepetida(String nuevaContrasena) {
		boolean noEncontrado = true;
		for (int i = 0; i < tresContrasenas.length; i++) {
			if (tresContrasenas[i] != null && tresContrasenas[i].equals(nuevaContrasena)) {
				noEncontrado = false;
			}
		}
		return noEncontrado;
	}

	// SEGUNDO PARA GUARDAR LA CONTRASEÑA NUEVA EN PUESTO 0 Y CAMBIAR DE POSISION
	// OTRAS PERDIENDO SIEMPRE
	// LA TERCERA EN CASO DE QUE HUBIERA CAMBIADO Y LLEGADO A 4 CONTRASEÑAS EN LA
	// APP.

	private void actualizarTresContrasenas(String nuevaContrasena) {
		for (int i = tresContrasenas.length - 1; i > 0; i--) {
			tresContrasenas[i] = tresContrasenas[i - 1];
		}
		tresContrasenas[0] = nuevaContrasena;
	}

}