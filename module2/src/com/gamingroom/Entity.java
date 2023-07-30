package com.gamingroom;

public class Entity {

	/*
	 * Holds the unique Entity identifier
	 */
	protected long id;
	
	/*
	 * Holds the unique Entity name
	 */
	protected String name;
	
	/**
	 * Protect the default constructor for use in sub classes only
	 */
	protected Entity() {
		
	}
	
	/**
	 * Constructor with an identifier and name
	 */
	public Entity (long id, String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * Returns the Entity identifier
	 * 
	 * @return the Entity identifier
	 */
	public long getId () {
		return id;
	}
	
	/**
	 * Returns the Entity name
	 * 
	 * @return the Entity name
	 */
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Entity [id=" + id + ", name=" + name + "]";
	}
	
}
