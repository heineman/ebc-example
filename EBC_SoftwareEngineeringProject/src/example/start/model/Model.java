package example.start.model;


/**
 * Top-level object from which all entity objects can be retrieved.
 */
public class Model {
	/** In this trivial example, only one entity object exists. */
	State state;

	/** For EBC: Appropriate for Model to have no-argument constructor. */
	public Model () {

	}

	public void setState(State s) {
		this.state = s;
	}

	public State getState() {
		return state;
	}

	public boolean isTails() {
		return state.value.equals(state.side2);
	}

}
