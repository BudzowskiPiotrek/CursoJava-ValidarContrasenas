package validacionUsuario;

import java.util.Scanner;

public class Main {
	private static Scanner sn = new Scanner(System.in);
	private static Scanner st = new Scanner(System.in);
	private static Usuario[] usuario = new Usuario[100];

	public static void main(String[] args) {

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
		case 1: {
registrar
		}

		}

	}
}
