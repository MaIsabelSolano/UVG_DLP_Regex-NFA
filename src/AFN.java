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

    private ArrayList<State> States;
    private State FinalState;
    private HashMap<Integer, Symbol> Symbols;
    private State initialState;
    private ArrayList<Transition> transitions;

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

    /* Getters */
    public ArrayList<State> getStates() {
        return this.States;
    }

    public State getFinalState() {
        return FinalState;
    }

    public HashMap<Integer, Symbol> getSymbols() {
        return Symbols;
    }

    public State getInitialState() {
        return initialState;
    }

    public ArrayList<Transition> getTransitions() {
        return transitions;
    }

    @Override
    public String toString() {
        String ret = "AFN\nSymbols: ";

        for (Integer i: Symbols.keySet()) {
            ret += Symbols.get(i).c_id + ", ";
        }

        ret += "\nTransitions: ";
        for (int i = 0; i < transitions.size(); i ++)  {
            String temp = "[";
            int originId = transitions.get(i).getOriginState().getId();
            int endID = transitions.get(i).getFinalState().getId();
            char symbol = transitions.get(i).symbol.c_id;
            temp += Integer.toString(originId) + " --" + symbol + "-> "+ Integer.toString(endID);
            temp += "]";
            ret += temp;
        }

        return ret;
    }

}
