package puzzles;

/**
 * Demostración de evaluación del operador ternario
 * 
 * @author ebarrab
 */
public class Puzzle4 {

    public static void main(String[] args) {
        char x = 'X';
        int i = 0;

        System.out.print(true ? x : 0);
        System.out.print(false ? i : x);
    }
}