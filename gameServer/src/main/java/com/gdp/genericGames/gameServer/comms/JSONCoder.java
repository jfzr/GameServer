package com.gdp.genericGames.gameServer.comms;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.gdp.genericGames.gameServer.comms.data.CommsData;
import com.gdp.genericGames.gameServer.comms.data.GameData;
import com.gdp.genericGames.gameServer.exceptions.CommsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;

import java.io.IOException;

/**
 * JSON coder/decoder. GameData must be provided during construction so
 * correct mapping can be done.
 *
 * Created by fzelada on 24/02/2017.
 */
@Component
public class JSONCoder {
	private static Logger log = LoggerFactory.getLogger(JSONCoder.class);

	private static GameData gameData;
	private final ObjectMapper mapper = new ObjectMapper();//TODO check for tuning

	@Autowired
	public JSONCoder(GameData gameData) {
		JSONCoder.gameData = gameData;
	}

	@Autowired
	public void setGameData(GameData gameData) {
		JSONCoder.gameData = gameData;
	}

	CommsData extractCommsData(String payload) throws CommsException {

		CommsData commsData;

		if (isValidJSON(payload)){
			log.trace("Payload accepted as JSON valid, trying to cast to CommsData object.");

			try {
				SimpleModule module = new SimpleModule();
				module.addAbstractTypeMapping(GameData.class, gameData.getClass());
				mapper.registerModule(module);
				commsData = mapper.readValue(payload, CommsData.class);
			} catch (IOException e) {
				log.error("Payload was not able to be parsed into CommData!");
				log.error(e.getMessage());
				throw new CommsException(e);
			}
		}else {
			log.trace("Validating of message-> No proper JSON message received");
			throw new CommsException("Message is not properly JSON formatted");
		}

		return commsData;
	}

	TextMessage prepareCommsData(CommsData commsData) throws CommsException {

		String msg;

		try {
			mapper.configure(SerializationFeature.INDENT_OUTPUT, true);//TODO remove on deploy
			mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false); //TODO check if stays
			mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
			msg = mapper.writeValueAsString(commsData);
		} catch (JsonProcessingException e) {
			e.printStackTrace(); //TODO delete
			log.error(e.getMessage());
			throw new CommsException("Output message was not able to be parsed into JSON. ");
		}

		log.trace("Sending message: " + msg);

		return new TextMessage(msg);
	}

	private boolean isValidJSON(final String json) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			mapper.readTree(json);
			return true;
		} catch (IOException e) {
			return false;
		}
	}
}
