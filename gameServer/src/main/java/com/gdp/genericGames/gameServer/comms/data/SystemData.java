package com.gdp.genericGames.gameServer.comms.data;

import com.gdp.genericGames.gameServer.commons.SystemInfo;

/**
 * This class is the container for common communication data.
 * Most likely not to change or to be extended.
 *
 * Created by fzelada on 24/02/2017.
 */
public class SystemData {

	private long playerId;
	private String playerToken;

	public SystemInfo systemInfo;

	public SystemData setSystemInfo(SystemInfo systemInfo) {
		this.systemInfo = systemInfo;
		return this;
	}

	public String getPlayerToken() {
		return playerToken;
	}

	public SystemData setPlayerToken(String playerToken) {
		this.playerToken = playerToken;
		return this;
	}

	public SystemInfo getSystemInfo() {
		return systemInfo;
	}

	public long getPlayerId() {
		return playerId;
	}

	public SystemData setPlayerId(long playerId) {
		this.playerId = playerId;
		return this;
	}
}
