public class GrupoAlumnos {
    private String nombre;
    private ListaCalificada listaAlumnos;

    public GrupoAlumnos(String nombre) {
        this.nombre = nombre;
        listaAlumnos = new ListaCalificada();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void nuevoAlumno(Alumno alumno) {
        listaAlumnos.insertar(alumno);
    }

    public int getNumAlumnos() {
        return listaAlumnos.getNumElementos();
    }

    public Alumno getAlumno(int matricula){
        IteradorC itC = listaAlumnos.getIterador();
        Alumno alu;
        while(itC.hasNext())
        {
            alu = itC.next();
            if(alu.getMatricula() == matricula)
                return alu;
        }
        return null;//creo que esta mal
    }

    public double porcentajeAprobados(String nombreAsignatura){
        if(listaAlumnos.vacia())
            return 0.0;
        else
        {
            IteradorC itC = listaAlumnos.getIterador();
            double numAprobadas = 0.0;
            while(itC.hasNext())
                if(itC.next().estaAprobado(nombreAsignatura))
                {
                    numAprobadas++;
                }
            numAprobadas /= listaAlumnos.getNumElementos();
            numAprobadas*=100;
            return(numAprobadas);
        }
    }
}