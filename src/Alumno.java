public class Alumno {
    private String nombre;
    private int matricula;
    private ListaOrdinal expediente;


    public Alumno(String nombre, int matricula) {
        this.nombre = nombre;
        this.matricula = matricula;
        expediente = new ListaOrdinal();
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void nuevaEvaluacion(Evaluacion evaluacion) {
        expediente.insertar(evaluacion);
    }

    public void eliminarEvaluacion(Evaluacion evaluacion){
        expediente.borrar(evaluacion);
    }

    public boolean estaAprobado(String nombreAsig) {
        boolean aprobado = false;
        Iterador it = expediente.getIterador();
        while (it.hasNext() && !aprobado) {
            Evaluacion evaluacion = it.next();
            if (evaluacion.getNombreAsignatura().equals(nombreAsig) &&
                    evaluacion.getNota() >= 5.0) {
                aprobado = true;
            }
        }
        return aprobado;
    }

    public ListaOrdinal asignaturasAprobadas() {
        ListaOrdinal listaAprobadas = new ListaOrdinal();
        Iterador it = expediente.getIterador();
        Evaluacion eaux;
        while(it.hasNext())
        {
            eaux = it.next();
            if(eaux.getNota()>=5)
                listaAprobadas.insertar(eaux);
        }
        return listaAprobadas;
    }

    public double mediaAprobadas() {
        double result, suma=0;
        int elems=0;
        if(asignaturasAprobadas().vacia())
            return 0.0;
        else
        {
            Iterador it = asignaturasAprobadas().getIterador();
            while(it.hasNext())
            {
                suma = suma + it.next().getNota();
                elems++;
            }
            result = suma / elems;
            return(result);
        }
    }

    public int getNumAprobadas() {
        int elems = 0;
        Iterador it = asignaturasAprobadas().getIterador();
        while(it.hasNext())
        {
            it.next();
            elems++;
        }
        return elems;
    }

    public void mostrar() {
        System.out.println(getNombre() + ". Matrícula: " + getMatricula());
        if(expediente.vacia())
            System.out.println("No ha realizado ninguna evaluacion.");
        else
        {
            Iterador it = expediente.getIterador();
            while(it.hasNext())
                it.next().mostrar();
            System.out.println(expediente.getNumElementos() + " evaluaciones y " + getNumAprobadas() + " asignaturas aprobadas con calificacion media " + mediaAprobadas());
        }
        System.out.println("--------------------");
    }

}
