package co.grandcircus.weatherproxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {
	
	@Autowired
	private WeatherService weatherService;
	
	@GetMapping("/forecast")
	public Period[] getWeatherInfo(@RequestParam("lat") String lat,
								   @RequestParam("lon")String lon) {
		
		System.out.println("ahhh, ok");
		return weatherService.useLatAndLongPeriod(lat, lon);
		
	}
	
	@GetMapping("/forecast/plus")
	public ProxyResponse proxyResponseInfo(@RequestParam("lat") String lat,
										   @RequestParam("lon")String lon){
											   
			return weatherService.useLatAndLongProxy(lat, lon);							   
	}

}
