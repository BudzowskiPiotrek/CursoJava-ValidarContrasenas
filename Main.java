import java.util.Scanner;

public class Main {
	private static Scanner sn = new Scanner(System.in);
	private static Scanner st = new Scanner(System.in);
	private static Usuario[] usuarios = new Usuario[100];

	public static void main(String[] args) {

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
			iniciarSecion();
			break;
		default:
			System.err.println("Opción no válida. Intenta de nuevo.");

		}

	}

	private static void iniciarSecion() {

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
			System.out.println("Dime el nombre del usuario");
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
}