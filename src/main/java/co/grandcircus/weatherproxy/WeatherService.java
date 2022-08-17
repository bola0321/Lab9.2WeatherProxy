package co.grandcircus.weatherproxy;

import java.util.Arrays;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
	private RestTemplate restTemplate = new RestTemplate();

	public Period[] useLatAndLongPeriod(String lat, String lon) {

		String url = "https://api.weather.gov/points/{lat},{lon}";
//		https://api.weather.gov/points/42.395387,-83.0559509

		WeatherModel firstCall = restTemplate.getForObject(url, WeatherModel.class, lat, lon);

		String forecastUrl = firstCall.getProperties().getForecastUrl();

		WeatherDetails actualWeatherData = restTemplate.getForObject(forecastUrl, WeatherDetails.class);

		return actualWeatherData.getProperties().getPeriods();
	}

	public ProxyResponse useLatAndLongProxy(String lat, String lon) {
		
		

		Period[] periodArr = useLatAndLongPeriod(lat, lon);

		ProxyPeriod[] proxyArr = Arrays.stream(periodArr).map(period -> ProxyPeriod.fromPeriod(period))
				.toArray(numPeriods -> new ProxyPeriod[numPeriods]);
		
		ProxyResponse proxyResponse = new ProxyResponse();
		proxyResponse.setPeriods(Arrays.asList(proxyArr));
		
		Stats stats = new Stats();
		int avg = Stats.findAverageTemp(proxyArr);
		stats.setAverageTemperature(avg);
		
		ProxyPeriod cold = Stats.findColdTemp(proxyArr);
		stats.setColdestPeriod(cold);
		
		ProxyPeriod hot = Stats.findHotTemp(proxyArr);
		stats.setHottestPeriod(hot);
		
		proxyResponse.setStats(stats);
		
		return proxyResponse;
			

	}
}
