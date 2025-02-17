package validacionUsuario;

import java.util.Iterator;
import java.util.Scanner;

public class Pruebas {

	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);
		Scanner st = new Scanner(System.in);
		Usuario u1 = null;
		System.out.println("Dime el nombre del usuario");
		String nombre = st.nextLine();
		for (int i = 1; i < 2; i++) {
			try {
				System.out.print(
						"Escribe una contraseña, al menos 8 caracteres, incluya una letra mayuscula, un numero y un caracter especial = [@ $ ! % * ? &]");
				u1 = new Usuario(nombre);
			} catch (IllegalArgumentException e) {
				i=0;
				System.out.println("Contraseña incorrecta");
				
			}
		}
		
		System.out.println(u1.getContrasena());
		System.out.print(
				"Escribe una contraseña, al menos 8 caracteres, incluya una letra mayuscula, un numero y un caracter especial = [@ $ ! % * ? &]");
		Administrador a1 = new Administrador("pedro"); 
		
		System.out.println(a1.getContrasena());
			
		a1.reiniciarContrasena(u1);
		System.out.println(u1.getContrasena());
		
		

	}

}
