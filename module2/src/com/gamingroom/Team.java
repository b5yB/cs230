package com.gamingroom;

import java.util.Iterator;
import java.util.List;

/**
 * A simple class to hold information about a team
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a team is
 * created.
 * </p>
 * @author coce@snhu.edu
 *
 */
public class Team extends Entity{
	
	/*
	 * Holds the list of Players in a Team
	 */
	private List<Player> players;

	/*
	 * Constructor with an identifier and name
	 */
	public Team(long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	/**
	 * Construct a new Player instance
	 * 
	 * @param name the unique name of the Player
	 * @return the Player instance (new or existing)
	 */
	public Player addPlayer (String name) {
		
		// obtains reference to the singleton instance
		GameService gServ = GameService.getInstance();
		
		// a local team instance
		Player player = null;

		// iterate over list of players to look for existing player with same name
		Iterator<Player> iter = players.iterator();
		while(iter.hasNext()) {
			// if found, simply return the existing instance
			if (iter.next().getName() == name) {
				player = iter.next();
			}
		}
		
		// if not found, make a new player instance and add to list of players
		if (player == null) {
			player = new Player(gServ.getNextPlayerId(), name);
			players.add(player);
		}

		// return the new/existing player instance to the caller
		return player;
	}
	

	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + "]";
	}
}
