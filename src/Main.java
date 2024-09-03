import java.util.Scanner;

public class Main {
    static Zona zona_a = new Zona("Zona A", 5, 5, 5000);
    static Zona zona_b = new Zona("Zona B", 4, 4, 6000);
    static Zona zona_c = new Zona("Zona C", 5, 5, 5000);
    static String opcion;
    static String seleccionZona;
    static boolean entradas = false;
    static boolean salida = false;
    static boolean asientoDispo;
    static int[] numeroasiento;
    static String seleccioneAsiento;

    public static void main(String[] args) {
        do {
            Scanner sc = new Scanner(System.in);

            reinicioVariables();

            System.out.println("Bienvenido al Teatro Moro!");

            System.out.println("Selecciona el número según corresponda: ");
            System.out.println("1 - Comprar entrada.");
            System.out.println("2 - Salir.");

            opcion = sc.nextLine();

            Teatro teatro = new Teatro(new Zona[]{zona_a, zona_b, zona_c});

            if (opcion.equals("1")) {
                do {
                    teatro.mostrarMapaDeAsientos();
                    Zona zona;

                    // Elección zona
                    System.out.println("Seleccione el número según corresponda: ");
                    System.out.println("1 - Zona A.");
                    System.out.println("2 - Zona B.");
                    System.out.println("3 - Zona C.");

                    seleccionZona = sc.nextLine();


                    zona = asignacionZona(seleccionZona);

                    do {
                        // Elección asiento
                        System.out.println("Ingrese asiento: (E2 por ejemplo)");
                        seleccioneAsiento = sc.nextLine();

                        numeroasiento = asientoCharAInt(seleccioneAsiento);           // Se transforma en los números correspondientes para trabajar en objeto Zona

                        asientoDispo = zona.getAsientos()[numeroasiento[0]][numeroasiento[1]].isDisponible();   // Validación de disponibilidad de asiento

                        if (!asientoDispo) {
                            System.out.println("Asiento no disponible. Por favor, intente nuevamente.");
                        }
                    } while (!asientoDispo && seleccionZona != null );

                    if (asientoDispo && seleccionZona != null) {
                        // Ingreso edad
                        System.out.println("Por favor ingrese su edad: ");
                        int edad = Integer.parseInt(sc.nextLine());

                        int valorAsiento = zona.getValorAsiento();

                        int valorFinal = calculoValorEntrada(edad, valorAsiento);
                        zona.getAsientos()[numeroasiento[0]][numeroasiento[1]].reservar();

                        mensajeCompraEntradas(seleccioneAsiento, valorFinal);
                    }

                } while (entradas);

            } else if (opcion.equals("2")) {
                salida = true;
            } else {
                System.out.println("Opción invalida. Favor repita la operación");
                salida = false;
            }

        } while (!salida);

    }

    public static void reinicioVariables () {
        opcion = "";
        seleccionZona = "";
        entradas = false;
        salida = false;
        seleccioneAsiento = "";
    }

    public static Zona asignacionZona(String num) {
        int n = Integer.parseInt(num);
        if (n == 1) {
            return zona_a;
        } else if (n == 2) {
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

    public static int[] asientoCharAInt(String asiento) {
        char filaAsientoSelect = asiento.charAt(0);
        String columnaAsientoSelect = Character.toString(asiento.charAt(1));

        int filaSelect = conversionFila(filaAsientoSelect);
        int columnaSelect = Integer.parseInt(columnaAsientoSelect) - 1;

        int[] numerosAsiento = { filaSelect, columnaSelect };

        return numerosAsiento;
    }



    public static int calculoValorEntrada(int edad, double valorAsiento) {
        int valorFinal;
        if (edad >= 5 && edad <= 18) {
            double dscto = valorAsiento * 0.10;
            valorFinal = (int) (valorAsiento - dscto);

            return valorFinal;
        } else if (edad >= 60) {
            double dscto = valorAsiento * 0.15;
            valorFinal = (int) (valorAsiento - dscto);

            return valorFinal;
        } else {
            return (int) valorAsiento;
        }
    }

    public static void reservaAsiento() {

    }

    public static void mensajeCompraEntradas(String asiento, int valorFinal) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        System.out.println("El valor de la entrada " + asiento + " es: $" + valorFinal);
        System.out.println(" ");
        System.out.println("Desea comprar otra entrada? (Seleccione el número según su respuesta)");
        System.out.println("1. SI");
        System.out.println("2. NO");

        opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                entradas = true;
                break;
                case 2:
                    entradas = false;
                    break;
                default:
                    System.out.println("Opción invalida. Favor repita la operación");
            }

        sc.close();
    }
}