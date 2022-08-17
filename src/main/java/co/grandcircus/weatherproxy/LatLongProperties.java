package co.grandcircus.weatherproxy;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LatLongProperties {
	
	@JsonProperty("forecast")
	private String forecastUrl;

	public String getForecastUrl() {
		return forecastUrl;
	}

	public void setForecastUrl(String forecastUrl) {
		this.forecastUrl = forecastUrl;
	}
	
	
}
