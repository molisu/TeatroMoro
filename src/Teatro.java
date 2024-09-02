import java.util.Scanner;

public class Teatro {
    private Zona[] zonas;

    public Teatro(Zona[] zonas) {
        this.zonas = zonas;
    }

    public void mostrarMapaDeAsientos() {
        for (Zona zona : zonas) {
            zona.mostrarAsientos();
            System.out.println();
        }
    }
}
