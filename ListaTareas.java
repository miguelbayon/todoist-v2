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

    public void marcarComoCompletada(int id)
    {
        int posicionReal = getPosicionById(id);     
        if (posicionReal != -1) {
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

    public void eliminarTarea(int id)
    {
        int posicionReal = getPosicionById(id);      
        if (posicionReal != -1) {
            listaDeTareas.remove(posicionReal);
        }           
    }

    public void establecerNuevaPrioridad (int id , int prioridad){
        int posicionReal = getPosicionById(id);     
        if (posicionReal != -1){
            if(prioridad >= 0 && prioridad <= 5){
                listaDeTareas.get(posicionReal).cambiarPrioridad(prioridad);
            }
        }

    }

    public void setFechaVencimiento(int id, int anio, int mes, int dia)
    {
        int posicionReal = getPosicionById(id); 
        if (posicionReal != -1){
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
    
    
    /**
     * Metodo que devuelve el indice de una tarea en funcion
     * de su id en caso de que exista. Devuelve -1 en caso de 
     * que no sea capaz de encontrar una tarea con ese id.
     */
    public int getPosicionById(int idBuscada)
    {
        int posicionBuscada = -1;
        int posicionActual = 0;
        boolean buscando = true;
        while ((posicionActual < listaDeTareas.size()) && (buscando)) {
            if (idBuscada == listaDeTareas.get(posicionActual).getId()) {
                posicionBuscada = posicionActual;
                buscando = false;
            }
            posicionActual++;
        }
        return posicionBuscada;
    }
    
    
    public int tareaMasViejaPendiente()
    {
        int idEncontrado = -1;
        
        idEncontrado = 10;
       
        return idEncontrado;
    }
    
    
    public int numeroTareasSinTerminar()
    {
        int numeroDeTareasSinTerminar = 0;
        
        for (Tarea tareaActual : listaDeTareas) {
            if (!tareaActual.estaTerminada()) {
                numeroDeTareasSinTerminar++;
            }
        }
        
        
        return numeroDeTareasSinTerminar;        
    }
    
    
    
    public boolean hayTareasDuplicadasJoseLuis()
    {
        boolean hayTareasDuplicadas = false;
        int indiceLento = 0;
        String descripcionTareaActual = "";
        boolean buscando = true;
        while (indiceLento < listaDeTareas.size() && buscando){
            int indiceRapido = 0;
            descripcionTareaActual = listaDeTareas.get(indiceLento).getDescripcion();
            int idTareaActual = listaDeTareas.get(indiceLento).getId();
            while (indiceRapido < listaDeTareas.size()){
                if ((listaDeTareas.get(indiceRapido).getId()!= idTareaActual) && 
                     descripcionTareaActual.equals(listaDeTareas.get(indiceRapido).getDescripcion())){
                    hayTareasDuplicadas = true;
                    buscando = false;
                }
                indiceRapido++;
            }
            indiceLento++;
        }
        
        return hayTareasDuplicadas;
    }    
    
    
    /**
     * Metodo que devuelve si hay o no tareas duplicadas. ( true o false )
     */
    public boolean hayTareasDuplicadas(){
        boolean tareaDuplicada = false;
        int indiceLento = 0;
        while(indiceLento < listaDeTareas.size()){
            Tarea tareaActual = listaDeTareas.get(indiceLento);
            
            int indiceRapido = 1;
            while(indiceRapido < listaDeTareas.size()){
                Tarea tareaOtra = listaDeTareas.get(indiceRapido);

                if(tareaActual.getDescripcion() == tareaOtra.getDescripcion ()){
                    tareaDuplicada = true;

                }
                indiceRapido++;
            }
            indiceLento++;

        }
        return tareaDuplicada;
    }    
}














