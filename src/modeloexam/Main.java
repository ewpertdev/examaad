package modeloexam;

import java.io.*;
import java.util.*;
/* Java give code

1. Se tiene un fichero de las siguientes característicos:
- Samuel: 1234;administrador
- Beatiz.123:odministadot
- Leticia: 1 2,usuario
- Pepe:\23abdilector
Donde la primera columna es el lector, la segunda columna es la contraseña y la tercera es el rol que tiene en la aplicación.
Se quiere diseñar una aplicación que lea del fichero y permita el acceso a los distintos usuarios y deniegue a los usuarios
que no están registrados o que han puesto mal la contraseña,
Aquellos usuarios que son administradores podrán añadir nuevos
usuarios y también podrán ver los datos de los demás usuarios excepto la contraseña que debe aparecer como * pero con el
número de caracteres reales que tiene. El usuario puede ver cuántos usuarios hay de cada tipo. Y al lector le aparecerá un mensaje de bienvenida.*/

public class Main {
    static List<Usuario> usuarios = new ArrayList<>();

    public static void cargarUsuarios(String fichero) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fichero));
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] datos = linea.split(":|;|,|\\\\");
            if (datos.length == 3) {
                usuarios.add(new Usuario(datos[0], datos[1], datos[2]));
            }
        }
        br.close();
    }

    public static Usuario verificarUsuario(String nombre, String pw) {

        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().equals(nombre) && usuario.getPw().equals(pw)) {
                return usuario;
            }
        }
        return null;
    }

    public static void addUsuario(Scanner sc) {
        String nombre = sc.nextLine();
        String pw = sc.nextLine();
        String roleplay = sc.nextLine();
        sc.close();

        usuarios.add(new Usuario(nombre, pw, roleplay));
    }

    public static void mostrarUsuario() {
        for (Usuario usuario : usuarios) {
            System.out.println(usuario.toStringOculto());
        }
    }

    public static void mostrarCantidadPorRol() {
        int admins = 0, usuarioNormales = 0, lectores = 0;
        for (Usuario usuario : usuarios) {
            switch (usuario.getRoleplay()) {
                case "admin":
                    admins++;
                    break;
                case "usuario":
                    usuarioNormales++;
                    break;
                case "lector":
                    lectores++;
                    break;
            }
        }
        System.out.println("Cantidad de admins: " + admins);
        System.out.println("Cantidad de usuarios: " + usuarioNormales);
        System.out.println("Cantidad de lectores: " + lectores);
    }

    public static void menuAdministrador(Usuario admin) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido" + admin.getNombre() + " eres administrador");
        int opcion;
        do {
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    addUsuario(sc);
                    break;
                case 2:
                    mostrarUsuario();
                    break;
                case 3:
                    mostrarCantidadPorRol();
                    break;
                case 0:
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println("Opcion inválida");
            }

        } while (opcion != 0);

    }

    public static void bienvenidoLector(Usuario lector) {
        System.out.println("Bienvenido, " + lector.getNombre() + ". Eres " + lector.getRoleplay() + ".");

    }

    public static void main(String[] args) throws IOException {
        cargarUsuarios("test.txt");
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce tu nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Introduce tu contraseña: ");
        String pw = sc.nextLine();

        Usuario usuarioActual = verificarUsuario(nombre, pw);

        if (usuarioActual != null) {
            if (usuarioActual.getRoleplay().equals("administrador")) {
                menuAdministrador(usuarioActual);
            } else if (usuarioActual.getRoleplay().equals("lector")) {
                bienvenidoLector(usuarioActual);
            }

        } else {
            System.out.println("Acceso denegado. Usuario o contraseña incorrectos.");
        }
        sc.close();

    }
}
