import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ListaTareasTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ListaTareasTest
{
    private ListaTareas listaTar1;

    /**
     * Default constructor for test class ListaTareasTest
     */
    public ListaTareasTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        listaTar1 = new ListaTareas();
        listaTar1.addTarea("Hacer la cama");
        listaTar1.addTarea("Estudiar programacion");
        listaTar1.addTarea("Jugar  a la play");
        listaTar1.addTarea("Comprar las entradas para el festival");
        listaTar1.addTarea("Limpiar el baño");
        listaTar1.addTarea("Llevar el coche al taller");    
        listaTar1.addTarea("Descargar la ultima temporada de Juego de Tronos");      
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void prioridadMasAlta()
    {
        listaTar1.mostrarTareas();
        listaTar1.establecerNuevaPrioridad(6, 4);
        listaTar1.establecerNuevaPrioridad(2, 4);
        listaTar1.establecerNuevaPrioridad(3, 3);
        listaTar1.establecerNuevaPrioridad(5, 2);
    }

    @Test
    public void testTareaMasViejaPendiente()
    {
        listaTar1.marcarComoCompletada(10);
        listaTar1.marcarComoCompletada(11);
        listaTar1.marcarComoCompletada(13);
        assertEquals(12, listaTar1.tareaMasViejaPendiente());
    }

    @Test
    public void testNumeroTareasSinTerminar()
    {
        assertEquals(7, listaTar1.numeroTareasSinTerminar());
        listaTar1.marcarComoCompletada(10);
        assertEquals(6, listaTar1.numeroTareasSinTerminar());
        listaTar1.marcarComoCompletada(16);
        assertEquals(5, listaTar1.numeroTareasSinTerminar());
        listaTar1.marcarComoCompletada(11);
        listaTar1.marcarComoCompletada(12);
        listaTar1.marcarComoCompletada(13);
        listaTar1.marcarComoCompletada(14);
        listaTar1.marcarComoCompletada(15);
        assertEquals(0, listaTar1.numeroTareasSinTerminar());
        ListaTareas listaTar2 = new ListaTareas();
        assertEquals(0, listaTar2.numeroTareasSinTerminar());
    }

    @Test
    public void testHayTareasDuplicadas()
    {
        assertEquals(false, listaTar1.hayTareasDuplicadas());
        listaTar1.addTarea("Hacer la cama");
        assertEquals(true, listaTar1.hayTareasDuplicadas());
        ListaTareas listaTar2 = new ListaTareas();
        assertEquals(false, listaTar2.hayTareasDuplicadas());
        listaTar1.addTarea("Hacer la cama");
        assertEquals(true, listaTar1.hayTareasDuplicadas());
    }
}






