package src;
public class Transition {
    public State originState;
    public State finalState;
    public Symbol symbol;

    public Transition( State originState, Symbol symbol, State finalState) {
        this.originState = originState;
        this.symbol = symbol;
        this.finalState = finalState;
    }

    /* Getters */
    public State getFinalState() {
        return finalState;
    }

    public State getOriginState() {
        return originState;
    }
    
    public Symbol getSymbol() {
        return symbol;
    }
}
