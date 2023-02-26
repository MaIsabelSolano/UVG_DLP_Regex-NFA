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

    public AFN(HashMap<Integer, Symbol> Symbols) {
        this.Symbols = Symbols;
    }
    
    public AFN(
        ArrayList<State> States, 
        State initialState, 
        HashMap<Integer, Symbol> Symbols,
        State finalState,
        ArrayList<Transition> transitions ) {

        this.States = States;
        this.FinalState = finalState;
        this.Symbols = Symbols;
        this.initialState = initialState;
        this.transitions = transitions;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

}
