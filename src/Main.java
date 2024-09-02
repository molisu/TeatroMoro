import java.util.Objects;
import java.util.Scanner;


/* FALTA AGREGAR LIMITES PARA SELECCIÓN DE ASIENTOS
* MANEJO DE ERRORES
* CORRECCIÓN PIEZAS CHAR PARA FILA Y COLUMNA RESERVA. */
public class Main {
    static Zona zona_a = new Zona("Zona A", 5, 5, 5000);
    static Zona zona_b = new Zona("Zona B", 4, 4, 6000);
    static Zona zona_c = new Zona("Zona C", 5, 5, 5000);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenido al Teatro Moro!");

        System.out.println("Selecciona el número según corresponda: ");
        System.out.println("1 - Comprar entrada.");
        System.out.println("2 - Salir.");

        String opcion = sc.nextLine();

        if (opcion.equals("1")) {
            Teatro teatro = new Teatro(new Zona[]{zona_a, zona_b, zona_c});
            teatro.mostrarMapaDeAsientos();

            // Elección zona
            System.out.println("Seleccione el número según corresponda: ");
            System.out.println("1 - Zona A.");
            System.out.println("2 - Zona B.");
            System.out.println("3 - Zona C.");
            String seleccionZona = sc.nextLine();

            Zona zona = asignacionZona(seleccionZona);

            // Elección asiento
            System.out.println("Ingrese asiento: (E2 por ejemplo)");
            String seleccioneAsiento = sc.nextLine();

            char filaAsientoSelect = seleccioneAsiento.charAt(0);
            char columnaAsientoSelect = seleccioneAsiento.charAt(1);

            System.out.println("COLUMNA >>>>>>>>>>> " + columnaAsientoSelect);

            int filaSelect = conversionFila(filaAsientoSelect);
            System.out.println("FILA >>>>>>>>>>> " + filaSelect);

            // Ingreso edad
            System.out.println("Por favor ingrese su edad: ");
            int edad = sc.nextInt();

            int valorAsiento = zona.getValorAsiento();
            if (edad >= 5 && edad <= 18) {
                double dscto = valorAsiento * 0.10;
                int valorFinal = (int) (valorAsiento - dscto);
                zona.getAsientos()[filaSelect][columnaAsientoSelect].reservar();

                System.out.println("El valor de la entrada " + seleccioneAsiento + " es: $" + valorFinal);
            } else if (edad >= 60) {
                double dscto = valorAsiento * 0.15;
                int valorFinal = (int) (valorAsiento - dscto);
                zona.getAsientos()[filaSelect][columnaAsientoSelect].reservar();

                System.out.println("El valor de la entrada " + seleccioneAsiento + " es: $" + valorFinal);
            } else {
                System.out.println("El valor de la entrada " + seleccioneAsiento + " es: $" + valorAsiento);
                zona.getAsientos()[filaSelect][columnaAsientoSelect].reservar();
            }
        }
    }

    public static Zona asignacionZona(String n) {
        int numZona = Integer.parseInt(n);
        if (numZona == 1) {
            return zona_a;
        } else if (numZona == 2) {
            return zona_b;
        } else {
            return zona_c;
        }
    }

    public static int conversionFila(char x) {
        return switch (x) {
            case 'A' -> 0;
            case 'B' -> 1;
            case 'C' -> 2;
            case 'D' -> 3;
            case 'E' -> 4;
            default -> throw new IllegalStateException("Unexpected value: " + x);
        };
    }
}