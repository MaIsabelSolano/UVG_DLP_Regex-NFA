package src;

public class State {
    public int id;
    public Type type;
    public Set AFNStates;

    public State(int id) {
        this.id = id;
    }
    
}

enum Type {

    Inicial, Trans, Final
}