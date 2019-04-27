package oo;

interface State {
    String writeName(StateContext context, String name);
}

class StateContext {
    private State state = new LowerCaseState();

    void setState(State newState) {
        state = newState;
    }

    public void writeName(String name) {
        state.writeName(this, name);
    }
}

class LowerCaseState implements State {
    @Override public String writeName(StateContext context, String name) {
        context.setState(new MultipleUpperCaseState());
        return name.toLowerCase();
    }
}

class MultipleUpperCaseState implements State {
    private int count = 0;

    @Override public String writeName(StateContext context, String name) {
        if (++count > 1) {
            context.setState(new LowerCaseState());
        }
        return name.toUpperCase();
    }
}

