package org.runedream;

import java.util.List;

import org.runedream.objective.ObjectiveExecutor;
import org.runedream.objective.ObjectiveTask;

/**
 * AbstractApplicationType.java
 * @author Harry Andreas
 */
public abstract class AbstractApplicationType {
	
	/**
	 * Invoked to start the application
	 */
	public void init() {
		if(!ObjectiveExecutor.executeObjectives(generateStartupTasks())) {
			System.err.println("Unable to complete startup objectives. Aborting launch!");
			System.exit(0);
			return;
		}
	}
	
	/**
	 * Generates a List of @see org.runedream.objective.ObjectiveTask
	 * to execute before launching the server online
	 * @return The list of @see org.runedream.objective.ObjectiveTask
	 */
	public abstract List<ObjectiveTask> generateStartupTasks();

}
