package org.runedream.objective;

import java.util.List;

/**
 * ObjectiveExecutor.java
 * @author Harry Andreas
 */
public class ObjectiveExecutor {
	
	/**
	 * Executes a List of @see org.runedream.objective.ObjectiveTask
	 * by converting them to an array and then executing for
	 * faster iteration
	 * @param tasks A List of @see org.runedream.objective.ObjectiveTask
	 */
	public static boolean executeObjectives(List<ObjectiveTask> tasks) {
		return executeObjectives(tasks.toArray(new ObjectiveTask[0]));
	}
	
	/**
	 * Executes an array of @see org.runedream.objective.ObjectiveTask
	 * @param tasks An array of @see org.runedream.objective.ObjectiveTask
	 */
	public static boolean executeObjectives(ObjectiveTask[] tasks) {
		for(ObjectiveTask task : tasks) {
			if(!task.execute()) {
				return false;
			}
		}
		return true;
	}

}
