public class Zona {
    private String nombre;
    private int valorAsiento;
    private Asiento[][] asientos; // [filas][columnas]

    public Zona(String nombre, int filas, int columnas, int valorAsiento) {
        this.nombre = nombre;
        this.valorAsiento = valorAsiento;
        this.asientos = new Asiento[filas][columnas];

        char fila = 'A';
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                String numero = String.format("%c%d", fila, j + 1);
                asientos[i][j] = new Asiento(numero, true, valorAsiento); // Inicialmente todos los asientos están disponibles
            }
            fila ++;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public Asiento[][] getAsientos() {
        return asientos;
    }

    public int getValorAsiento() {
        return valorAsiento;
    }

    public void mostrarAsientos() {
        System.out.println("Zona: " + nombre + " $" + valorAsiento);
        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[i].length; j++) {
                System.out.print(asientos[i][j] + " ");
            }
            System.out.println();
        }
    }
}
