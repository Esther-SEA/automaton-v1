import java.util.Arrays;

/**
 * Model a 1D elementary cellular automaton.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version  2016.02.29 - version 1
 */
public class Automaton
{
    // The number of cells.
    private final int numberOfCells;
    // The state of the cells.
    private int[] state;
    
    /**
     * Create a 1D automaton consisting of the given number of cells.
     * @param numberOfCells The number of cells in the automaton.
     */
    public Automaton(int numberOfCells)
    {
        this.numberOfCells = numberOfCells;
        state = new int[numberOfCells + 1];// Extend array by one element
        state[numberOfCells] = 0; // Last element is always 0
        // Seed the automaton with a single 'on' cell in the middle.
        state[numberOfCells / 2] = 1;
        //Adding other cells in the 1 state
        state[(numberOfCells / 2) - 2] = 1;
        state[(numberOfCells / 2) + 2] = 1;
    }
    
    /**
     * Print the current state of the automaton.
     */
    public void print()
    {
        for(int cellValue : state) {
            if(cellValue == 1) {
                System.out.print("*");
            }
            else {
                System.out.print(" ");
            }
        }
        System.out.println();
    }   
    
    /**
     * Update the automaton to its next state.
     */
    /**public void update()
    {
        // Build the new state in a separate array.
        int[] nextState = new int[state.length];
        // Naively update the state of each cell
        // based on the state of its two neighbors.
        for(int i = 0; i < state.length; i++) {
            int left = (i == 0)? 0: state[i - 1];
            int center = state[i];
            int right = (i + 1 < state.length) ? state[i + 1] : 0;
            
            nextState[i] = (left + center + right) % 2;
        }
         state = nextState;
    }*/
    public void update(){
        int[] nextState = new int[state.length];
        int left = 0;
        int center = state[0];
            for (int i=0; i < numberOfCells; i++){
                 int right = state[i + 1];
                 nextState[i] = calculateNextState(left, center, right);
                 left = center;
                 center = right;
            }
    }
    
    /**
     * Reset the automaton.
     */
    public void reset()
    {
        Arrays.fill(state, 0);
        // Seed the automaton with a single 'on' cell.
        state[numberOfCells / 2] = 1;
            
    }
    
    public int calculateNextState(int left, int center, int right){
        return (left + center + right) % 2; 
    }
}
