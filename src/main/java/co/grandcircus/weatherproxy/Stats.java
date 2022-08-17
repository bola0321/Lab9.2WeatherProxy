package co.grandcircus.weatherproxy;

public class Stats {

	private int averageTemperature;
	
	private ProxyPeriod hottestPeriod;
	
	private ProxyPeriod coldestPeriod;

	public int getAverageTemperature() {
		return averageTemperature;
	}

	public void setAverageTemperature(int averageTemperature) {
		this.averageTemperature = averageTemperature;
	}

	public ProxyPeriod getHottestPeriod() {
		return hottestPeriod;
	}

	public void setHottestPeriod(ProxyPeriod hottestPeriod) {
		this.hottestPeriod = hottestPeriod;
	}

	public ProxyPeriod getColdestPeriod() {
		return coldestPeriod;
	}

	public void setColdestPeriod(ProxyPeriod coldestPeriod) {
		this.coldestPeriod = coldestPeriod;
	}
	
	
	public static int findAverageTemp(ProxyPeriod[] proxyArr) {
		int totalTemp = 0;
		
		for(Period temp: proxyArr) {
			totalTemp += temp.getTemperature();
		}
		return (totalTemp/proxyArr.length);
		
	}
	
	public static ProxyPeriod findHotTemp(ProxyPeriod[] proxyArr) {
		int hotTemp = proxyArr[0].getTemperature();
		int hotTempIndex = 0;
		
		for(int i = 0; i<proxyArr.length; i++ ) {
			if(hotTemp<proxyArr[i].getTemperature()) {
				hotTemp = proxyArr[i].getTemperature();
				hotTempIndex = i;
			}
		}
		return proxyArr[hotTempIndex];
	}
	
	public static ProxyPeriod findColdTemp(ProxyPeriod[] proxyArr) {
		int coldTemp = proxyArr[0].getTemperature();
		int coldTempIndex = 0;
		
		for(int i = 0; i<proxyArr.length; i++) {
			if(coldTemp>proxyArr[i].getTemperature()) {
				coldTemp = proxyArr[i].getTemperature();
				coldTempIndex = i;
			}
		}
		return proxyArr[coldTempIndex];
	}
}
