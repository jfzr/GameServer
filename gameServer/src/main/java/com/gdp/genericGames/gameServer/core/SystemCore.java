package com.gdp.genericGames.gameServer.core;

import com.gdp.genericGames.gameServer.comms.data.CommsData;
import com.gdp.genericGames.gameServer.comms.data.GameData;

/**
 * Created by fzelada on 31/03/2017.
 */
public class SystemCore<G extends GameData> implements ISystemCore<G> {

	@Override
	public CommsData<G> process(CommsData<G> incomingData) {
		return null;
	}
}
