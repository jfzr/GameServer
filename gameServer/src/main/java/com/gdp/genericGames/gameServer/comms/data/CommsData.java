package com.gdp.genericGames.gameServer.comms.data;

import com.gdp.genericGames.gameServer.commons.MsgType;

/**
 * General communications class container
 *
 * Created by fzelada on 24/02/2017.
 */
public class CommsData<GD extends GameData> {

	private SystemData systemData;
	private GD gameData;

	public PlayerInfo playerInfo = new PlayerInfo();

	private MsgType msgType;

	public CommsData() {
	}

	public CommsData(SystemData systemData, GD gameData) {
		this.systemData = systemData;
		this.gameData = gameData;
	}

	public SystemData getSystemData() {
		return systemData;
	}

	public CommsData setSystemData(SystemData systemData) {
		this.systemData = systemData;
		return this;
	}

	public GD getGameData() {
		return gameData;
	}

	public CommsData<?> setGameData(GD gameData) {
		this.gameData = gameData;
		return this;
	}

	public MsgType getMsgType() {
		return msgType;
	}

	public CommsData setMsgType(MsgType msgType) {
		this.msgType = msgType;
		return this;
	}

	public class PlayerInfo{
		private String playerToken;

		public String getPlayerToken() {
			return playerToken;
		}

		public PlayerInfo setPlayerToken(String playerToken) {
			this.playerToken = playerToken;
			return this;
		}
	}
}
