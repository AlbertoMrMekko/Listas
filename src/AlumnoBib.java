import java.util.Iterator;
import java.util.LinkedList;

public class AlumnoBib {
    private String nombre;
    private int matricula;
    private LinkedList<Evaluacion> expediente;

    public AlumnoBib(String nombre, int matricula) {
        this.nombre = nombre;
        this.matricula = matricula;
        expediente = new LinkedList<Evaluacion>();
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
        expediente.add(evaluacion);
    }

    public boolean estaAprobado(String nombreAsig) {
        boolean aprobado = false;
        Iterator<Evaluacion> itBib = expediente.iterator();
        while (itBib.hasNext() && !aprobado) {
            Evaluacion evaluacion = itBib.next();
            if (evaluacion.getNombreAsignatura().equals(nombreAsig) &&
                    evaluacion.getNota() >= 5.0) {
                aprobado = true;
            }
        }
        return aprobado;
    }

    public LinkedList<Evaluacion> asignaturasAprobadas() {
        LinkedList<Evaluacion> listaAprobadas = new LinkedList<Evaluacion>();
        Iterator<Evaluacion> itBib = expediente.iterator();
        Evaluacion eaux;
        while(itBib.hasNext())
        {
            eaux = itBib.next();
            if(eaux.getNota()>=5)
                listaAprobadas.add(eaux);
        }
        return listaAprobadas;
    }

    public double mediaAprobadas() {
        double result, suma=0;
        int elems=0;
        if(asignaturasAprobadas().isEmpty())
            return 0.0;
        else
        {
            Iterator<Evaluacion> itBib = asignaturasAprobadas().iterator();
            while(itBib.hasNext())
            {
                suma = suma + itBib.next().getNota();
                elems++;
            }
            result = suma / elems;
            return(result);
        }
    }

    public int getNumAprobadas() {
        int elems = 0;
        Iterator<Evaluacion> itBib = asignaturasAprobadas().iterator();
        while(itBib.hasNext())
        {
            itBib.next();
            elems++;
        }
        return elems;
    }

    public void mostrar() {
        System.out.println(getNombre() + ". Matrícula: " + getMatricula());
        if(expediente.isEmpty())
            System.out.println("No ha realizado ninguna evaluacion.");
        else
        {
            Iterator<Evaluacion> itBib = expediente.iterator();  //Iterador it = expediente.getIterador();
            while(itBib.hasNext())
                itBib.next().mostrar();
            System.out.println(expediente.size() + " evaluaciones y " + getNumAprobadas() + " asignaturas aprobadas con calificacion media " + mediaAprobadas());
        }
        System.out.println("--------------------");
    }
}