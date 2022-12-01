public class Pruebas
{
    public static void main(String[] args) {
        Evaluacion e1 = new Evaluacion("ED", "Junio19", 4.5);
        Evaluacion e2 = new Evaluacion("ED", "Julio19", -1);
        Evaluacion e3 = new Evaluacion("ED", "Julio20", 7.4);
        Evaluacion e4 = new Evaluacion("Algebra", "Junio18", 6.4);
        ListaOrdinal l1 = new ListaOrdinal();
        l1.insertar(e1);
        l1.insertar(e2);
        l1.insertar(e3);
        l1.insertar(e4);
        Iterador it = l1.getIterador();
        System.out.println("----- EVALUACIONES EN LA LISTA -----");
        while(it.hasNext())
            it.next().mostrar();
        System.out.println("Convocatorias en ED: " + l1.numConvocatorias("ED"));
        System.out.println("Convocatorias en Álgebra: " + l1.numConvocatorias("Algebra"));
        System.out.println("Convocatorias en Fundamentos de Programación: " + l1.numConvocatorias("Fundamentos de Programacion"));
        Alumno a1 = new Alumno("Felipe García Gómez",1253);
        Alumno a2 = new Alumno("Alicia Blánquez Martín",5622);
        a1.nuevaEvaluacion(e1);
        a1.nuevaEvaluacion(e2);
        a1.nuevaEvaluacion(e3);
        a1.nuevaEvaluacion(e4);
        System.out.println("----- Asignaturas aprobadas por " + a1.getNombre() + " -----");
        ListaOrdinal laux = new ListaOrdinal();
        laux = a1.asignaturasAprobadas();
        Iterador itaux = laux.getIterador();
        while(itaux.hasNext())
            itaux.next().mostrar();
        System.out.println("----- Asignaturas aprobadas por " + a2.getNombre() + " -----");
        laux = a2.asignaturasAprobadas();
        laux.getIterador();
        while(itaux.hasNext())
            itaux.next().mostrar();
        System.out.println("----- MOSTRAR LOS ALUMNOS: -----");
        a1.mostrar();
        a2.mostrar();
        AlumnoBib aB1 = new AlumnoBib("Eduardo Parra Martín",8765);
        AlumnoBib aB2 = new AlumnoBib("Sonia Torres Pardo",2345);
        aB1.nuevaEvaluacion(e1);
        aB1.nuevaEvaluacion(e2);
        aB1.nuevaEvaluacion(e3);
        aB1.nuevaEvaluacion(e4);
        System.out.println("----- MOSTRAR LOS ALUMNOS BIBLIOTECA: -----");
        aB1.mostrar();
        aB2.mostrar();
        Alumno a3 = new Alumno("Pedro Jiménez Del Pozo",8510);
        Evaluacion e5 = new Evaluacion("Fundamentos de Programación","Enero19",8.8);
        a3.nuevaEvaluacion(e5);
        ListaCalificada lc = new ListaCalificada();
        lc.insertar(a3);
        lc.insertar(a1);
        lc.insertar(a2);
        IteradorC itC = lc.getIterador();
        System.out.println("----- ALUMNOS EN LA LISTA -----");
        while(itC.hasNext())
            itC.next().mostrar();
        System.out.println("----- Borramos las claves menores a 6000 -----");
        lc.borrarMenores(6000);
        itC = lc.getIterador();
        while(itC.hasNext())
            itC.next().mostrar();
        System.out.println("----- Borramos las claves menores a 9000 -----");
        lc.borrarMenores(9000);
        itC = lc.getIterador();
        while(itC.hasNext())
            itC.next().mostrar();
        lc.insertar(a3);
        lc.insertar(a1);
        lc.insertar(a2);
        System.out.println("----- Metemos todos los alumnos y borramos las claves mayores a 7000 -----");
        lc.borrarMayores(7000);
        itC = lc.getIterador();
        while(itC.hasNext())
            itC.next().mostrar();
        System.out.println("----- Borramos las claves mayores a 1000 -----");
        lc.borrarMayores(1000);
        itC = lc.getIterador();
        while(itC.hasNext())
            itC.next().mostrar();
        GrupoAlumnos g1 = new GrupoAlumnos("GX11");
        System.out.println("----- Creado el grupo " + g1.getNombre() + " -----");
        g1.nuevoAlumno(a1);
        g1.nuevoAlumno(a2);
        g1.nuevoAlumno(a3);
        System.out.println("El grupo " + g1.getNombre() + " tiene " + g1.getNumAlumnos() + " alumnos.");
        System.out.println("----- Grupo " + g1.getNombre() + ". Alumno con matrícula 8510: -----");
        g1.getAlumno(8510).mostrar();
        System.out.println("Porcentaje de aprobados en ED en el grupo " + g1.getNombre() + ": " + g1.porcentajeAprobados("ED"));

    }
}