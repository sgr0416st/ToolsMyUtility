package sgr.st.reinforcement;

public interface AgentInterface<T> {

	public abstract void selectAction();
	public abstract ActionInterface<T> getAction();
	public abstract void learn(ObservationInterface o);

}

