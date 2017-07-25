package com.gdp.genericGames.gameServer.player;

/**
 * Created by fzelada on 14/03/2017.
 */
public interface IPlayer<T extends IPlayer<T>> {

	//Required fields
	long getPlayerId();
	T setPlayerId(long playerId);
	long getBet();
	T setBet(long bet);
	long getWin();
	T setWin(long win);
	long getBalance();// Just a place holder - not required



	//Required methods
	long takeBet(long betAmount); //TODO exceptions to be added
	long addWin(long amount);
	void updatePlayer();
	boolean authenticate();

}
