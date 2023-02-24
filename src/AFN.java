/*
 * @Author Maria Isabel Solano
 * @version 0.1, 24/02/23
 * 
 * AFN class
 */

package src;

import java.util.ArrayList;
import java.util.HashMap;

public class AFN extends Automata{

    public ArrayList<State> States;
    public ArrayList<State> FinalStates;
    public HashMap<Integer, Symbol> Symbols;
    public State initialState;
    public ArrayList<Transition> transitions;
    
    public AFN() {

        this.States = new ArrayList<>();
        this.FinalStates = new ArrayList<>();
        this.Symbols = new HashMap<>();
        this.initialState = new State();
        this.transitions = new ArrayList<>();
    
    }

    public void addState(State s) {
        States.add(s);
    }
    
}
