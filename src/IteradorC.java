public class IteradorC {
    private NodoC actual;

    public IteradorC(NodoC comienzo) {
        actual = comienzo;
    }

    public boolean hasNext() {
        return actual != null;
    }

    public Alumno next() {
        Alumno resultado = actual.getDato();
        actual = actual.getSiguiente();
        return resultado;
    }
}
