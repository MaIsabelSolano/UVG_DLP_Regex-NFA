package src;

public class State {
    public int id;
    public Type type;
    public Set AFNStates;

    public State(int id, int typeOption) {
        this.id = id;

        if (typeOption == 1) {
            // Inicial
            this.type = Type.Inicial;

        } else if (typeOption == 2) {
            // Transition
            this.type = Type.Trans;
            
        } else if (typeOption == 3) {
            // Final
            this.type = Type.Final;
        }
    }

    public void setToTrans() {
        this.type = Type.Trans;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return Integer.toString(id);
    }

    /* Getters */
    public int getId() {
        return id;
    }

    public Type getType() {
        return type;
    }
    
}

enum Type {

    Inicial, Trans, Final
}