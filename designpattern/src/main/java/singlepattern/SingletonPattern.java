package singlepattern;

import java.util.Vector;

public class SingletonPattern {
	private static SingletonPattern instance = null;
	private Vector properties = null;

	public Vector getProperties() {
		return properties;
	}

	private SingletonPattern() {
	}

	private static synchronized void syncInit() {
		if (instance == null) {
			instance = new SingletonPattern();
		}
	}

	public static SingletonPattern getInstance() {
		if (instance == null) {
			syncInit();
		}
		return instance;
	}

	public void updateProperties() {
		SingletonPattern shadow = new SingletonPattern();
		properties = shadow.getProperties();
	}
}
