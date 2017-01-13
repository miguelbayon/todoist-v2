import java.util.ArrayList;
import java.time.LocalDate;
/**
 * Write a description of class ListaTareas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ListaTareas
{
    private ArrayList<Tarea> listaDeTareas;
    private int proximoIdAAsignar;

    public ListaTareas()
    {
        listaDeTareas = new ArrayList<Tarea>();
        proximoIdAAsignar = 10;
    }

    public void addTarea(String descripcionTarea)
    {
        Tarea tarea = new Tarea(descripcionTarea, proximoIdAAsignar);
        proximoIdAAsignar++;
        listaDeTareas.add(tarea);
    }

    public void mostrarTareas()
    {
        int posicion = 1;
        for (Tarea tarea : listaDeTareas) {         
            System.out.println(posicion + ". " + tarea.toString());
            posicion++;
        }
    }

    public void marcarComoCompletada(int posicionTarea)
    {
        int posicionReal = posicionTarea - 1;
        if (posicionReal >= 0 && posicionReal < listaDeTareas.size()) {
            listaDeTareas.get(posicionReal).marcarComoCompletada();
        }   
    }

    public void mostrarCoincidentes(String textoABuscar) 
    {
        int posicion = 0;
        while (posicion < listaDeTareas.size()) {
            Tarea tareaActual = listaDeTareas.get(posicion);
            if (tareaActual.getDescripcion().contains(textoABuscar)) {                             
                System.out.println((posicion + 1) + tareaActual.toString());
            }                        
            posicion++;
        }   
    }

    public void eliminarTarea(int posicionTarea)
    {
        int posicionReal = posicionTarea - 1;       
        if (posicionReal >= 0 && posicionReal < listaDeTareas.size()) {
            listaDeTareas.remove(posicionReal);
        }           
    }

    public void establecerNuevaPrioridad (int posicion , int prioridad){
        int posicionReal = posicion - 1;
        if (posicionReal >= 0 && posicionReal < listaDeTareas.size()){
            if(prioridad >= 0 && prioridad <= 5){
                listaDeTareas.get(posicionReal).cambiarPrioridad(prioridad);
            }
        }

    }

    public void setFechaVencimiento(int posicion, int anio, int mes, int dia)
    {
        int posicionReal = posicion - 1;
        if (posicionReal >= 0 && posicionReal < listaDeTareas.size()){
            listaDeTareas.get(posicionReal).establecerFechaVencimiento(anio, mes, dia);
        }
    }

    public void mostrarHoy()
    {
        int posicion = 1;
        LocalDate hoy = LocalDate.now();
        for (Tarea tarea : listaDeTareas) { 
            if (tarea.getFecha() != null) {
                if(tarea.getFecha().isEqual(hoy)){
                    System.out.println(posicion + ". " + tarea.toString());
                }
            }
            posicion++;
        }
    }

    public void mostrarVencidas()
    {
        int posicion = 1;
        LocalDate hoy = LocalDate.now();
        for (Tarea tarea : listaDeTareas) { 
            if (tarea.getFecha() != null) {
                if(tarea.getFecha().isBefore(hoy)){
                    System.out.println(posicion + ". " + tarea.toString());
                }
            }
            posicion++;
        }
    }

    public void verTareaMasPrioritaria()
    {
        int prioridadMaxima = 0;

        for(Tarea tarea : listaDeTareas) { 
            if(prioridadMaxima < tarea.obtenerPrioridad()){ 
                prioridadMaxima = tarea.obtenerPrioridad();
            }
        }   
        int posicion = 0;
        while (posicion < listaDeTareas.size()){
            Tarea tareaActual = listaDeTareas.get(posicion);
            if (tareaActual.obtenerPrioridad() == prioridadMaxima){               
                System.out.println((posicion + 1) + ". " + tareaActual.toString());               

            }
            posicion++;
        }
    }
    
    public void verTareaMasPrioritaria2()
    {
        if (listaDeTareas.size() > 0) {
            Tarea tareaMasPrioritaria = listaDeTareas.get(0);
            
            for (Tarea tareaActual : listaDeTareas) {
                if (tareaActual.obtenerPrioridad() >= tareaMasPrioritaria.obtenerPrioridad()) {
                    tareaMasPrioritaria = tareaActual;
                }                
            }
            
            System.out.println(tareaMasPrioritaria);
        }        
    }
}






