package org.runedream;

/**
 * Application.java
 * @author Harry Andreas
 */
public class Application {

	/**
	 * Invoked on start up of the application
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws Exception {
		ApplicationState state = parseParameters(args);
		if(state == null) {
			System.err.println("Application state could not be found in parameters. Aborting startup");
			return;
		}
		@SuppressWarnings("unchecked")
		Class<AbstractApplicationType> startup = (Class<AbstractApplicationType>) Class.forName(getApplicationStartupClass(state));
		startup.newInstance().init();
	}
	
	/**
	 * Gets the application startup class
	 * @param state The state of the application start of
	 */
	private static String getApplicationStartupClass(ApplicationState state) {
		return "org.runedream."+state.name().toLowerCase()+".Launch";
	}
	
	/**
	 * Parses a string parameter to detect 
	 * the application state
	 * @param params
	 * @return
	 */
	private static ApplicationState parseParameters(String[] params) {
		for(String param : params) {
			if(param.equalsIgnoreCase("-slave")) {
				return ApplicationState.SLAVE;
			} else if(param.equalsIgnoreCase("-master")) {
				return ApplicationState.MASTER;
			}
		}
		return null;
	}
	
	/**
	 * An Enum representing a
	 * State of the application
	 * @author Harry Andreas
	 */
	public static enum ApplicationState {
		MASTER,
		SLAVE;
	}

}