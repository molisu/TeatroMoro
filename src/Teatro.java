import java.util.Scanner;

public class Teatro {
    private Zona[] zonas;

    public Teatro(Zona[] zonas) {
        this.zonas = zonas;
    }

    public void mostrarMapaDeAsientos() {
        System.out.println("Asientos con X están ocupados");
        for (Zona zona : zonas) {
            zona.mostrarAsientos();
            System.out.println();
        }
    }
}
