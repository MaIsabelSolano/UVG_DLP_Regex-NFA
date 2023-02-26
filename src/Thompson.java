package src;

import java.util.ArrayList;
import java.util.HashMap;

public class Thompson {

    HashMap<Integer, Symbol> alphabet;
    int numState = 0;
    Symbol epsilon = new Symbol('ε');
    

    public Thompson(HashMap<Integer, Symbol> dict) {
        this.alphabet = dict;
    }

    public AFN SubsetConstuction(TreeNode node) {
        // first node will be the root of the tree


        if (node.leftChild == null && node.righChild == null) {
            // Tree leafs

            // Get states ids
            int originState = 0;
            originState += numState;
            numState ++;
            int destinState = 0;
            destinState += numState;
            numState ++;

            // Create new states
            State oS = new State(originState, 1);
            State dS = new State(destinState, 3);

            // Create simple transition
            Transition t = new Transition(oS, node.value, dS);

            ArrayList<State> states = new ArrayList<>();
            states.add(oS);
            states.add(dS);

            ArrayList<Transition> transitions = new ArrayList<>();
            transitions.add(t);

            AFN currentAfn = new AFN(states, oS, alphabet, dS, transitions);
            return currentAfn;
        }

        else {
            if (node.righChild == null) {
                
                // Generate children's AFN before their own
                AFN Child = SubsetConstuction(node.leftChild);
                
                // Generate own AFN from current node
                
                AFN currentAfn = new AFN(alphabet);
                return currentAfn;

            } else {
                AFN currentAfn;
                // Generate children's AFN before their own
                AFN Left = SubsetConstuction(node.leftChild);
                
                AFN Right = SubsetConstuction(node.righChild);

                // Generate own AFN from current node
                if (node.value.c_id == '|') {
                    // or

                    // Get states ids
                    int originState = 0;
                    originState += numState;
                    numState ++;
                    int destinState = 0;
                    destinState += numState;
                    numState ++;

                    // Create new states
                    State oS = new State(originState, 1);
                    State dS = new State(destinState, 3);
                    
                    // Get values from children
                    // States
                    ArrayList<State> statesLeft = Left.getStates();
                    ArrayList<State> statesRight = Right.getStates();

                    ArrayList<State> states = new ArrayList<>();
                    states.add(oS);
                    states.addAll(statesLeft);
                    states.addAll(statesRight);
                    states.add(dS);
                    
                    // initial and final states position in arrays
                    int initialLeftStatePos = 0;
                    int initialRightStatePos = 0;
                    int finalLeftStatePos = -1;
                    int finalRightStatePos = -1;

                    for (int i = 0; i < statesLeft.size(); i++ ){
                        if (statesLeft.get(i).type == Type.Inicial) {
                            initialLeftStatePos = i;
                            statesLeft.get(i).setToTrans();
                        }
                        if (statesLeft.get(i).type == Type.Final) {
                            finalLeftStatePos = i;
                            statesLeft.get(i).setToTrans();
                        }
                    }

                    for (int i = 0; i < statesRight.size(); i++ ){
                        if (statesRight.get(i).type == Type.Inicial) {
                            initialRightStatePos = i;
                            statesRight.get(i).setToTrans();
                        }
                        if (statesRight.get(i).type == Type.Final) {
                            finalRightStatePos = i;
                            statesRight.get(i).setToTrans();
                        }
                    }

                    // get new transitions
                    ArrayList<Transition> transitions = new ArrayList<>();
                    transitions.addAll(Left.getTransitions());
                    transitions.addAll(Right.getTransitions());

                    // create new transitions
                    
                    Transition beginningOrOp1 = new Transition(oS, epsilon, statesLeft.get(initialLeftStatePos));
                    Transition beginningOrOp2 = new Transition(oS, epsilon, statesRight.get(initialRightStatePos));

                    Transition endOrOp1 = new Transition(statesLeft.get(finalLeftStatePos), epsilon, dS);
                    Transition endOrOp2 = new Transition(statesRight.get(finalRightStatePos), epsilon, dS);

                    transitions.add(beginningOrOp1);
                    transitions.add(beginningOrOp2);
                    transitions.add(endOrOp1);
                    transitions.add(endOrOp2);

                    currentAfn = new AFN(states, oS, alphabet, dS, transitions);


                } else {
                    // concatenation

                    // get first and last state
                    State firState = Left.getInitialState();
                    State lastState = Right.getFinalState();

                    // Get values from children
                    // States
                    ArrayList<State> statesLeft = Left.getStates();
                    ArrayList<State> statesRight = Right.getStates();

                    ArrayList<State> states = new ArrayList<>();
                    states.addAll(statesLeft);
                    states.addAll(statesRight);

                    // initial and final states position in arrays
                    int initialRightStatePos = 0;
                    int finalLeftStatePos = -1;

                    for (int i = 0; i < statesLeft.size(); i++ ){
                        if (statesLeft.get(i).type == Type.Inicial) {
                            statesLeft.get(i).setToTrans();
                        }
                        if (statesLeft.get(i).type == Type.Final) {
                            finalLeftStatePos = i;
                        }
                    }

                    for (int i = 0; i < statesRight.size(); i++ ){
                        if (statesRight.get(i).type == Type.Inicial) {
                            initialRightStatePos = i;
                        }
                        if (statesRight.get(i).type == Type.Final) {
                            statesRight.get(i).setToTrans();
                        }
                    }

                    // get new transitions
                    ArrayList<Transition> transitions = new ArrayList<>();
                    transitions.addAll(Left.getTransitions());
                    transitions.addAll(Right.getTransitions());

                    // create new transition 

                    Transition dot = new Transition(
                        statesLeft.get(finalLeftStatePos), 
                        epsilon, 
                        statesRight.get(initialRightStatePos));

                    transitions.add(dot);

                    currentAfn = new AFN(states, firState, alphabet, lastState, transitions);
                }

                
                return currentAfn;
            }
            
        }
        
        // The last AFN to return will be the root's, therefore, the expression's AFN
        

    }

    public void Operation(Symbol s) {
        if (!s.isOperator()) {

        } else {
            if (s.c_id == '|') {
                // or 

            } else if (s.c_id == '*') {
                // kleene

            } else if (s.c_id == '+') {
                // positive clousure

            } else if (s.c_id == '?') {
                // ?

            } else if (s.c_id == '.') {
                // concatenation

            }
        }
    }

}
