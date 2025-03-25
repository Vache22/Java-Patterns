package StatePattern.stopWatch;

public class StopWatch implements State{
    private State currentState = new StoppedState(this);
    @Override
    public void click() {
        currentState.click();
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }
}
