package com.gdp.genericGames.gameServer.comms;

import com.gdp.genericGames.gameServer.comms.data.GameData;
import com.gdp.genericGames.gameServer.core.ISystemCore;

/**
 * General contract interface for communications managers.
 *
 * Created by fzelada on 23/02/2017.
 */

public interface ICommsManager<G extends GameData> {

	/**
	 * The communications link with System Core, an ISystemCore implementation must be injected
	 * @param systemCore {@link ISystemCore} implementation, must be wired.
	 */
	void setSystemCore(ISystemCore<G> systemCore);
}
