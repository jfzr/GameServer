package com.gdp.genericGames.gameServer.sessionState;

import com.gdp.genericGames.gameServer.comms.data.CommsData;
import com.gdp.genericGames.gameServer.comms.data.GameData;
import com.gdp.genericGames.gameServer.player.IPlayer;
import com.gdp.genericGames.gameServer.sessionState.state.IGameState;
import com.gdp.genericGames.gameServer.sessionState.state.SystemState;

/**
 * Created by fzelada on 31/03/2017.
 */
public class StateBean<G extends GameData, P extends IPlayer<P>, GS extends IGameState> {
	public P player;
	public SystemState systemState;
	public GS gameState;

	private CommsData<G> outGoingData;


	public void setPlayer(P player) {
		this.player = player;
	}

	public void setSystemState(SystemState systemState) {
		this.systemState = systemState;
	}

	public void setGameState(GS gameState) {
		this.gameState = gameState;
	}

	public CommsData<G> getOutGoingData() {
		return outGoingData;
	}

	public void setOutGoingData(CommsData<G> outGoingData) {
		this.outGoingData = outGoingData;
	}
}
