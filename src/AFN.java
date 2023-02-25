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
    public State FinalState;
    public HashMap<Integer, Symbol> Symbols;
    public State initialState;
    public ArrayList<Transition> transitions;
    
    public AFN(
        ArrayList<State> States, 
        State FinalState, 
        HashMap<Integer, Symbol> Symbols,
        State initialState,
        ArrayList<Transition> transitions ) {

        this.States = States;
        this.FinalState = FinalState;
        this.Symbols = Symbols;
        this.initialState = initialState;
        this.transitions = transitions;
    
    }

    
}
