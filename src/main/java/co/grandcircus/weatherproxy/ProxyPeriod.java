package co.grandcircus.weatherproxy;

public class ProxyPeriod extends Period{

	private int temperatureCelsius;
	
	
	public int getTemperatureCelsius() {
		return temperatureCelsius;
	}
	
	public void setTemperatureCelsius(int temperatureCelsius) {
		this.temperatureCelsius = temperatureCelsius;
	}


	public static ProxyPeriod fromPeriod(Period period) {
	
		ProxyPeriod proxyPer = new ProxyPeriod();

        proxyPer.setNumber(period.getNumber());
        proxyPer.setName(period.getName());
        proxyPer.setStartTime(period.getStartTime());
        proxyPer.setEndTime(period.getEndTime());
        proxyPer.setDayTime(period.isDayTime());
        proxyPer.setTemperature(period.getTemperature());
        proxyPer.setTemperateUnit(period.getTemperateUnit());
        proxyPer.setTemperatureTrend(period.getTemperatureTrend());
        proxyPer.setWindSpeed(period.getWindSpeed());
        proxyPer.setWindDirection(period.getWindDirection());
        proxyPer.setIcon(period.getIcon());
        proxyPer.setShortForecast(period.getShortForecast());
        proxyPer.setDetailedForecast(period.getDetailedForecast());
        proxyPer.setTemperatureCelsius((int)((((double)period.getTemperature())-32)*5/9));
		
        return proxyPer;
		
	}
	
	
	
}
