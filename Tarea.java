
/**
 * Write a description of class Tarea here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tarea
{
    private String descripcion;
    private boolean terminada;
    
    public Tarea(String descripcion)
    {
        terminada = false;
        this.descripcion = descripcion;
    }
    
    public String getDescripcion() 
    {
        return descripcion;
    }
    
    public boolean estaTerminada()
    {
        return terminada;
    }
    
    public void marcarComoCompletada()
    {
        terminada = true;
    }
    
    public String toString()
    {
        String textoADevolver = "";
        if (terminada) {
            textoADevolver = textoADevolver + "HECHA ";
        }
        textoADevolver += descripcion;
        return textoADevolver;
    }
    
    
}













