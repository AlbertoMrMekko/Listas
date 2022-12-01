public class Iterador {
    private Nodo actual;

    public Iterador(Nodo comienzo) {
        actual = comienzo;
    }

    public boolean hasNext() {
        return actual != null;
    }

    public Evaluacion next() {
        Evaluacion resultado = actual.getDato();
        actual = actual.getSiguiente();
        return resultado;
    }
}
