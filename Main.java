import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<String, PasswordEntry> gestor = new CustomHashMap<>(10);

        int opcion;

        do {
            System.out.println("GESTOR DE CONTRASEÑAS");
            System.out.println("1. Guardar contraseña");
            System.out.println("2. Buscar contraseña");
            System.out.println("3. Eliminar contraseña");
            System.out.println("4. Mostrar todas las contraseñas");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            
            switch (opcion) {
                case 1:
                    System.out.print("nombre del sitio: ");
                    String sitio = sc.nextLine();

                    System.out.print("contraseña: ");
                    String password = sc.nextLine();

                    PasswordEntry entrada = new PasswordEntry(sitio, password);
                    gestor.put(sitio, entrada);

                    System.out.println("Listo, contraseña guardada.");
                    break;

                case 2:
                    System.out.print("¿Qué sitio quieres buscar?: ");
                    String buscarSitio = sc.nextLine();

                    PasswordEntry resultado = gestor.get(buscarSitio);

                    if (resultado != null) {
                        System.out.println("Sitio: " + resultado.getSitio());
                        System.out.println("Contraseña: " + resultado.getPasswordOculta());
                    } else {
                        System.out.println("No encontré ese sitio.");
                    }
                    break;

                case 3:
                    System.out.print("¿Qué sitio quieres eliminar?: ");
                    String eliminarSitio = sc.nextLine();

                    boolean eliminado = gestor.remove(eliminarSitio);

                    if (eliminado) {
                        System.out.println("Se eliminó bien.");
                    } else {
                        System.out.println("Ese sitio no estaba guardado.");
                    }
                    break;

                case 4:
                    System.out.println("\nEstas son las contraseñas guardadas:");
                    gestor.mostrar();
                    break;

                case 5:
                    System.out.println("saliendo del programa...");
                    break;

                default:
                    System.out.println("Esa opción no existe.");
            }

        } while (opcion != 5);

        sc.close();
    }
}