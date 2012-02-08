package org.runedream.script.repo;

import java.util.ArrayList;
import java.util.List;

import org.runedream.script.Script;
import org.runedream.script.ScriptType;

/**
 * ScriptRepository.java
 * @author Harry Andreas
 */
public class ScriptRepository {
	
	/**
	 * Singleton instance of this class
	 */
	private static ScriptRepository instance;
	
	/**
	 * 
	 */
	private final List<Script> freeScripts;
	
	/**
	 * Gets the singleton instance
	 * @return The singleton instance of the Repository
	 */
	public static ScriptRepository getSingleton() {
		if(instance == null) {
			instance = new ScriptRepository();
		}
		return instance;
	}
	
	/**
	 * Construct the object
	 */
	private ScriptRepository() {
		this.freeScripts = new ArrayList<Script>();
	}

	/**
	 * Gets a script from the loaded scripts
	 * @param name The name of the script to find
	 * @param type The type of the script
	 * @return The script if any
	 */
	public Script getScript(String name, ScriptType type) {
		//TODO: Basically just a place holder for now
		List<Script> array = null;
		if(type == ScriptType.FREE) {
			array = freeScripts;
		}
		for(Script s : array) {
			if(s.scriptName.equalsIgnoreCase(name)) {
				return s;
			}
		}
		return null;
	}
}