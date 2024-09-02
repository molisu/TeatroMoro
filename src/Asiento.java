public class Asiento {
    // Atributos
    private String numero;
    private boolean disponible;
    private int valor;

    public Asiento(String numero, boolean disponible, int valor) {
        this.numero = numero;
        this.disponible = disponible;
        this.valor = valor;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public int getValor() {
        return valor;
    }

    public void reservar() {
        if (disponible) {
            disponible = false;
        } else {
            System.out.println("El asiento " + numero + " ya está reservado.");
        }
    }

    @Override
    public String toString() {
        return disponible ? String.valueOf(numero) : "X"; // numero si está disponible, X para ocupado.
    }
}
