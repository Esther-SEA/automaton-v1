/**
 * Set up and control an elementary cellular automaton.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version  2016.02.29
 */
public class AutomatonController
{
    // The automaton.
    private Automaton auto;
    
    /**
     * Create an AutomatonController.
     * @param numberOfCells The number of cells in the automaton.
     */
    public AutomatonController(int numberOfCells)
    {
        auto = new Automaton(numberOfCells);
        auto.print();
    }
    
    /**
     * Create an AutomatonController with
     * a default number of cells.
     */
    public AutomatonController()
    {
        this(50);
    }
    
    /**
     * Run the automaton for the given number of steps.
     * @param numSteps The number of steps.
     */
    public void run(int numSteps)
    {
        for(int step = 1; step <= numSteps; step++) {
            step();
        }
    }
    
    /**
     * Run the automaton for a single step.
     */
    public void step()
    {
        auto.update();
        auto.print();
    }
    
    /**
     * Reset the automaton.
     */
    public void reset()
    {
        auto.reset();
        auto.print();
    }
    
    /**
     * 25. yes the same patterns emerges.
     * 26. 2, they set all elements of an array to the same value/ in reset method it is used by setting all emelents of the state array by 0. which resets the automaton
     * 27. still the same pattern of triangles repeats, it is deterministic because it always results in the same pattern.
     * 29. Yes there is a difference the pattern is now only a diagonal line. With nextState, it looked at the original state of all cells before making changes. but now it uses the new updated values.
     * 30. another solution could be to use variables to store the current cell's vallue and the next cell's value before updating the cell. Then when it is updated, move the stored values forward for the next one.
     * 33. the number of posibilities isnt infinite its 256 because you have three inputs and since they are binary, there are 2 possibilities for each input, 2^3 = 8. and the next state for each combination can also be 0 or 1 so two choice. 2^8= 256 wich means there are 256 different sets of rules for calculating the next state of a cell.
     */
}
