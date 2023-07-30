package com.gamingroom;

import java.util.Iterator;
import java.util.List;

/**
 * A simple class to hold information about a game
 * 
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a game is
 * created.
 * </p>
 * 
 * @author coce@snhu.edu
 *
 */
public class Game extends Entity{
	
	/*
	 * Holds the list of Teams in a Game
	 */
	private List<Team> teams;


	/**
	 * Constructor with an identifier and name
	 */
	public Game (long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	/**
	 * Construct a new team instance
	 * 
	 * @param the unique name of the team
	 * @return the team instance (new or existing)
	 */
	public Team addTeam (String name) {
		
		// obtains reference to the singleton instance
		GameService gServ = GameService.getInstance();
		
		// a local team instance
		Team team = null;

		// iterate over list of teams to look for existing team with same name
		Iterator<Team> iter = teams.iterator();
		while(iter.hasNext()) {
			// if found, simply return the existing instance
			if (iter.next().getName() == name) {
				team = iter.next();
			}
		}
		
		// if not found, make a new team instance and add to list of teams
		if (team == null) {
			team = new Team(gServ.getNextTeamId(), name);
			teams.add(team);
		}

		// return the new/existing team instance to the caller
		return team;
	}
	
	
	@Override
	public String toString() {
		
		return "Game [id=" + id + ", name=" + name + "]";
	}

}
