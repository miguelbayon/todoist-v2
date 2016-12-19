import java.util.ArrayList;
/**
 * Write a description of class ListaTareas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ListaTareas
{
    private ArrayList<Tarea> listaDeTareas;
    
    public ListaTareas()
    {
        listaDeTareas = new ArrayList<Tarea>();
    }
    
    public void addTarea(String descripcionTarea)
    {
        Tarea tarea = new Tarea(descripcionTarea);
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
    
    
}












