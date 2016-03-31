package puzzles;

/**
 * Demostración de la diferencia entre asignaciones simples y compuestas
 * 
 * @author ebarrab
 */
public class Puzzle3 {

    public static void main(String[] args) {
        caso1();    // Asignación compuesta
        caso2();    // Asignación simple
    }
    
    private static void caso1() {
        short   x = 0;
        int     i = 123456;
        
        // La asignación compuesta compila sin errores
        // pero hay una conversión implícita. Según
        // JLS 15.26.2, una expresión de asignación compuesta
        // de la forma E1 op= E2 es equivalente a 
        // E1 = (T) ((E1) op (E2)), donde T es el tipo de E1, 
        // teniendo en cuenta que la expresión E1 es evaluada
        // sólo una vez
        x += i;     // Equivale a: (short) ((x) + (i))
        
        // El valor 123456 (resultante de la suma x+i) es de tipo int (4 bytes)
        // y al ser convertido a short (2 bytes) se pierden 2 bytes de precisión
        // obteniendo un resultado incorrecto.
        System.out.println("x += i ---> x="+x);     // x=-7616        
    }
    
    private static void caso2() {
        short   x = 0;
        int     i = 123456;
        
        // Error de compilación por posible pérdida de precisión en la 
        // conversión de int a short en la asignación (tipos incompatibles)
        // x = x + i;
    }
    
}
