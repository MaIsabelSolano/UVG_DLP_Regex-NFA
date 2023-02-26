package src;

import java.util.ArrayList;
import java.util.HashMap;

public class Thompson {

    Tree tree;
    HashMap<Integer, Symbol> alphabet;
    int numState = 0;
    

    public Thompson(Tree tree, HashMap<Integer, Symbol> dict) {
        this.tree = tree;
        this.alphabet = dict;
    }

    public AFN SubsetConstuction(TreeNode node) {
        // first node will be the root of the tree


        if (node.leftChild == null && node.righChild == null) {
            // Tree leafs

            // Generate simple transition
            int originState = 1;
            numState ++;
            originState += numState;
            int destinState = 2;
            numState ++;
            destinState += numState;

            State oS = new State(originState, 1);
            State dS = new State(destinState, 3);
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

            AFN currentAfn = new AFN(alphabet);
            // Generate children's AFN before their own
            AFN Left = SubsetConstuction(node.leftChild);
            
            AFN Right = SubsetConstuction(node.righChild);

            // Generate own AFN from current node

            return currentAfn;
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

    // private AFN or() {
    //     // Initial State number handling
    //     numState += 1;
    //     State biginningState = new State(numState);
    //     numState += 1;
    //     State endState = new State(numState);
        
    //     // transition handling
        
    // }
    
}
