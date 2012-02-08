package org.runedream.slave;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.runedream.AbstractApplicationType;
import org.runedream.net.mysql.DatabaseConnection;
import org.runedream.net.mysql.DatabaseManager;
import org.runedream.objective.ObjectiveTask;

/**
 * Launch.java
 * @author Harry Andreas
 */
public class Launch extends AbstractApplicationType {
	
	/**
	 * The logger used to log events in the console
	 */
	private final Logger LOGGER = Logger.getLogger(Launch.class.getName());

	/**
	 * Invoked to start the application
	 * @see org.runedream.AbstractApplicationType#init()
	 */
	@Override
	public void init() {
		getLogger().info("Starting RuneDream slave script server...");
		super.init();
	}
	
	/**
	 * (non-Javadoc)
	 * @see org.runedream.AbstractApplicationType#generateStartupTasks()
	 */
	@Override
	public List<ObjectiveTask> generateStartupTasks() {
		List<ObjectiveTask> tasks = new ArrayList<ObjectiveTask>();
		tasks.add(new ObjectiveTask() {
			@Override
			public boolean execute() {
				try {
					getLogger().info("Connecting to MySQL Database...");
					DatabaseManager.getSingleton().addDatabase(DatabaseConnection.create("127.0.0.1", "scripts", "password123", "runedream"), "script-connector");
				} catch (Exception e) {
					getLogger().log(Level.SEVERE, "Unable to connect to Database!", e.getCause());
					return false;
				}
				return true;
			}
		});
		return tasks;
	}

	/**
	 * Gets the logger
	 * @return the logger
	 */
	private Logger getLogger() {
		return LOGGER;
	}

}