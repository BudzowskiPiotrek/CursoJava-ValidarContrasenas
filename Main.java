import java.util.Iterator;
import java.util.Scanner;

public class Main {
	private static Scanner sn = new Scanner(System.in);
	private static Scanner st = new Scanner(System.in);
	private static Usuario[] usuarios = new Usuario[100];

	public static void main(String[] args) {
		// PARA EMPEZAR PEDIRA PRIMERO UNA CUENTA QUE SERIA UN ADMINISTRADOR.
		registrarAdministrador();
		menu();
	}

	private static void menu() {
		while (true) {
			System.out.println("1.Registrar nuevos usuarios");
			System.out.println("2.Iniciar sesión");
			int flag = sn.nextInt();
			menuDos(flag);
		}
	}

	private static void menuDos(int flag) {
		switch (flag) {
		case 1:
			registrarUsuario();
			break;
		case 2:
			iniciarSesion();
			break;
		default:
			System.err.println("Opción no válida. Intenta de nuevo.");
		}
	}
	
	// METODO REGISTRAR USUARIO PRIMERO SACARA POSICION LIBRE EN LA LISTA DE ARRAY
	// DE USUARIOS POSTERIORMENTE SI NO DEVOLVERA -1 PROCEDERA A PREGUNTARLE POR EL
	// NOMBRE, AL CREAR CONSTRUCTOR NUEVO DE NEW USUARIO SE EJECUTARA SETER CON
	// PEDIR CONTRASEÑA QUE GENERARA UNA EXCEPCION SI NO CUMPLIRA PARAMETROS
	// SOLICITADOS EL TRY CATCH Y BUCLE FOR SIRVEN PARA MANTENER PREGUNTANDO LA
	// CONTRASEÑA HASTA INGRESARLA BIEN.

	private static void registrarUsuario() {
		int posicion = buscadorIdLibre();
		if (posicion != -1) {
			System.out.println("Dime el nombre del usuario");
			String nombre = st.nextLine();
			for (int i = 1; i < 2; i++) {
				try {
					System.out.println(
							"Escribe una contraseña, al menos 8 caracteres, incluya una letra mayuscula, un numero y un caracter especial = [@ $ ! % * ? &]");
					usuarios[posicion] = new Usuario(nombre);
				} catch (IllegalArgumentException e) {
					i = 0;
					System.out.println("Contraseña incorrecta");
				}
			}
			System.out.println(" Hola " + nombre + " tu ID de usuario es : " + posicion);
		}

	}

	// METODO REGISTRAR ADMINISTRADOR LA MISMA FORMA COMO DE USURIO

	private static void registrarAdministrador() {
		int posicion = buscadorIdLibre();
		if (posicion != -1) {
			System.out.println("Dime el nombre del usuario del Administrador");
			String nombre = st.nextLine();
			for (int i = 1; i < 2; i++) {
				try {
					System.out.println(
							"Escribe una contraseña, al menos 8 caracteres, incluya una letra mayuscula, un numero y un caracter especial = [@ $ ! % * ? &]");
					usuarios[posicion] = new Administrador(nombre);
				} catch (IllegalArgumentException e) {
					i = 0;
					System.out.println("Contraseña incorrecta");
				}
			}
			System.out.println("Hola " + nombre + " tu ID de adminitrador es : " + posicion);
		}

	}
	
	// METODO BUSCADOR DE ID LIBRE SIRVE, PARA BUSCAR PRIMERA POSICION LIBRE EN LA
	// LISTA DE USUARIOS EN CASO DE TENERLA LLENA VOLVERIA -1 A MODO DE SEGURO.

	private static int buscadorIdLibre() {
		for (int i = 0; i < usuarios.length; i++) {
			if (usuarios[i] == null) {
				return i;
			}
		}
		return -1;
	}
	
	// METODO PARA INICIAR SESION DESPUES DE PEDIR LA ID DE USUARIO, SE COROBORARA
	// SI EXISTE ESTE NUMERO Y SI ESTA FEURA DE RANGO DE LA ARRAY INFORMANDO QUE ID
	// NO SE ENCONTRO, SI SE INGRESARA BIEN, SE PEDIRA CONTRASEÑA, SE LA COMPROBARA
	// ECT, EN ULTMIMO LUGAR COMBOBARA TIPO DE CUENTA PARA CARGAR PANEL DE
	// ADMINISTRADOR O DE USUARIO NORMAL

	private static void iniciarSesion() {
		System.out.println("Ingrese tu ID: ");
		int id = sn.nextInt();

		if (id >= 0 && id < usuarios.length && usuarios[id] != null) {
			System.out.println("Ingrese tu contraseña: ");
			String contrasena = st.nextLine();
			if (contrasena.equals(usuarios[id].getContrasena())) {
				if (usuarios[id] instanceof Administrador) {
					panelAdminitrador(id);
				} else {
					panelUsuario(id);
				}
			} else {
				System.out.println("Contraseña incorrecta.");
			}
		} else {
			System.out.println("La ID de usuario no se encontró.");
		}
	}
	
	
	// METODO PANEL DE ADMINITRADOR DESAROLLARA SOLAMENTE OPCION DE RESTABLECER
	// CONTRASEÑA DE CUALQUIER USUARIO O SALIR DE LA APLICACION.

	private static void panelAdminitrador(int id) {
		boolean flag = true;
		do {
			System.out.println("BIENVENIDO ADMINISTRADOR");
			System.out.println("1.Restablecer contraseña de usuario");
			System.out.println("2.Para Salir");
			int opcion = sn.nextInt();
			switch (opcion) {
			case 1:
				System.out.println("Dime id de usuario: ");
				int restablecer = sn.nextInt();
				if (restablecer >= 0 && restablecer < usuarios.length && usuarios[restablecer] != null) {
					if (usuarios[restablecer] instanceof Usuario) {
						Administrador administrador = (Administrador) usuarios[id];
						administrador.reiniciarContrasena(usuarios[restablecer]);
						System.out.println("Contraseña restablecida");
					} else {
						System.out.println("No puedes restablecer la contraseña de un administrador.");
					}
				} else {
					System.out.println("El usuario con ID " + restablecer + " no existe.");
				}
				break;
			case 2:
				flag = false;
				break;
			}

		} while (flag);

	}

	// METODO PANEL DE PANEL DE USUARIO DESAROLLARA SOLAMENTE OPCION DE CAMBIAR SU
	// PROPIA CONTRASEÑA O SALIR DE LA APLICACION

	private static void panelUsuario(int id) {
		boolean flag = true;
		do {
			System.out.println("BIENVENIDO USUARIO");
			System.out.println("1.Cambiar la contraseña");
			System.out.println("2.Para Salir");
			int opcion = sn.nextInt();
			switch (opcion) {
			case 1:
				try {
					usuarios[id].setContrasena();
				} catch (IllegalArgumentException e) {
					System.out.println("Contraseña incorrecta");
				}
				break;
			case 2:
				flag = false;
				break;
			}
		} while (flag);
	}
