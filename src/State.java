package src;

public class State {
    public int id;
    public Type type;
    public Set AFNStates;

    public State() {
        
    }
    
}

enum Type {

    Inicial, Trans, Final
}