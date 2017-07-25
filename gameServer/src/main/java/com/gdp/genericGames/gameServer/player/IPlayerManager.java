package com.gdp.genericGames.gameServer.player;

/**
 * Created by fzelada on 14/03/2017.
 */
public interface IPlayerManager {

	IPlayer getPlayerById(long playerId);
	IPlayer getPlayerBYToken(String token);
}
