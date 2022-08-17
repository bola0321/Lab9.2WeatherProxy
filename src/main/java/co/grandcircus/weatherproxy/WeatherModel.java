package co.grandcircus.weatherproxy;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherModel {
	
	@JsonProperty("properties")
	private LatLongProperties properties;

	public LatLongProperties getProperties() {
		return properties;
	}

	public void setProperties(LatLongProperties properties) {
		this.properties = properties;
	}
	
	
}
