package com.gdp.genericGames.gameServer.sessionState.state;

import com.gdp.genericGames.gameServer.commons.SystemInfo;

/**
 * Created by fzelada on 31/03/2017.
 */
public class SystemState {
	private long playerId;
	private long playerToken;

	public SystemInfo systemInfo;

	public long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}

	public long getPlayerToken() {
		return playerToken;
	}

	public void setPlayerToken(long playerToken) {
		this.playerToken = playerToken;
	}

	public void setSystemInfo(SystemInfo systemInfo) {
		this.systemInfo = systemInfo;
	}
}
