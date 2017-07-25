package com.gdp.genericGames.gameServer.player;

import com.gdp.genericGames.persistance.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Simple PlayerManager, bounded to {@link DefaultPlayer}. Considering basic
 * functionality in this class the bound should no represent a problem else
 * IPlayerManager can be implemented with a different IPlayer implementation.
 *
 * Created by fzelada on 15/03/2017.
 */
public class DefaultPlayerManager<T extends IPlayer<T>> implements IPlayerManager {

	private PlayerRepository<T> playerRepository;

	@Autowired
	public void setPlayerRepository(PlayerRepository<T> playerRepository){
		this.playerRepository = playerRepository;
	}

	@Override
	public T getPlayerById(long playerId) {
		return playerRepository.fetchPlayerById(playerId);
	}

	@Override
	public T getPlayerBYToken(String token) {
		return playerRepository.fetchPlayerByToken(token);
	}
}
