package com.wwd.tictactoe;

/**
 * Central constants reservoir
 * @author Wendong Wang
 * @version 1 (June 2017)
 */
public class Constants {
	//URI for a server move in response to a client move
	public static final String SERVER_PLAY = "rest/serverplay";
	
	//URI for server-side initiation of the game
	public static final String SERVER_INIT = "rest/serverinit";
	
	//server marker
	public static final String SERVER_MARK = "O";
	
	//client marker
	public static final String CLIENT_MARK = "X";
}
