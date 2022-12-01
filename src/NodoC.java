public class NodoC {

    private Alumno dato;
    private NodoC siguiente;

    public NodoC(Alumno dato, NodoC siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
    }

    public NodoC getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoC siguiente) {
        this.siguiente = siguiente;
    }

    public Alumno getDato() {
        return dato;
    }

    public void setDato(Alumno dato) {
        this.dato = dato;
    }

    public int getClave() { return dato.getMatricula(); }
}