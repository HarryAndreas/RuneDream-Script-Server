package org.runedream.objective;

/**
 * ObjectiveTask.java
 * @author Harry Andreas
 */
public abstract class ObjectiveTask {
	
	/**
	 * Construct the object
	 * @param params The parameters of the task
	 */
	public ObjectiveTask(Object... params) {
		parameters = params;
	}
	
	/**
	 * Stored parameters of the task
	 */
	protected Object[] parameters;
	
	/**
	 * When called, the objective is attempted
	 * if successful it returns true, else it 
	 * returns false 
	 */
	public abstract boolean execute();

}
