package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/*
	 * Holds the next Game identifier
	 */
	private static long nextGameId = 1;
	
	/*
	 * Holds the next Player identifier
	 */
	private static long nextPlayerId = 1;
	
	/*
	 * Holds the next Team identifier
	 */
	private static long nextTeamId = 1;
	
	/**
	 * Holds the single instance of GameService
	 */
	private static GameService service = new GameService();
	
	
	/**
	 * Private GameService constructor ensures only one instance exists at a time
	 */
	private GameService(){}
	
	/**
	 * Public method which returns the Singleton instance of GameService
	 * 
	 * @return the single instance of GameService
	 */
	public static GameService getInstance () {
		return service;
	}

	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {

		// a local game instance
		Game game = null;

		// iterate over list of games to look for existing game with same name
		Iterator<Game> iter = games.iterator();
		while(iter.hasNext()) {
			// if found, simply return the existing instance
			if (iter.next().getName() == name) {
				game = iter.next();
			}
		}
		
		// if not found, make a new game instance and add to list of games
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		}

		// return the new/existing game instance to the caller
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}
	
	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;

		//iterate over list of games to look for existing game with same id
		Iterator<Game> iter = games.iterator();
		while(iter.hasNext()) {
			// if found, simply assign that instance to the local variable
			if (iter.next().getId() == id) {
				game = iter.next();
			}
		}
		return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;

		// iterate over list of games to look for existing game with same name
		Iterator<Game> iter = games.iterator();
		while(iter.hasNext()) {
			// if found, simply assign that instance to the local variable
			if (iter.next().getName() == name) {
				game = iter.next();
			}
		}

		return game;
	}

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}
	
	/**
	 * Returns the next Player identifier to assign 
	 * 
	 * @return the next Player identifier to assign 
	 */
	public long getNextPlayerId() {
		long originalNextPlayerId = nextPlayerId;
		nextPlayerId += 1;
		return originalNextPlayerId;
	}
	
	/**
	 * Returns the next Team identifier to assign 
	 * 
	 * @return the next Team identifier to assign 
	 */
	public long getNextTeamId() {
		long originalNextTeamId = nextTeamId;
		nextTeamId += 1;
		return originalNextTeamId;
	}
}
