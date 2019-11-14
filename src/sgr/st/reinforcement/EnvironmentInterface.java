package sgr.st.reinforcement;

public interface EnvironmentInterface<T> {

	public abstract ObservationInterface reset();

	public abstract ObservationInterface step(ActionInterface<T> action);


}
