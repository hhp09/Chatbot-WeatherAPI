// Name: Hritik Panchasara
// netID: hhp160130
// Description: Setting Accessor and Mutator methods for our weather data, creating a toString() method and conversion functions.

public class FormattingData {
	private double temp;
	private double high;
	private double low;
	private String location;
	private String weather;
	
	public FormattingData(double temp, double high, double low, String location, String weather) {
		this.temp = temp;
		this.high = high;
		this.low = low;
		this.location = location;
		this.weather = weather;
	}
	
	public String toString() {
        return String.format("The weather is %s in %s. The temperature is %.1f°C, with a high of %.1f°C and a low of %.1f°C.", location, weather, temp, high, low);
	}
	
	private double kelvinToF(double kelvin) {
		return (1.8 * (kelvin - 273) + 32);
	}
	
	public void set_high(double high) {
		this.high = kelvinToF(high);
	}
	
	public double get_high() {
		return high;
	}
	
	public void set_low(double low) {
		this.low = kelvinToF(low);
	}
	
	public double get_low() {
		return low;
	}
	
	public void set_temp(double temp) {
		this.temp = kelvinToF(temp);
	}
	
	public void set_weather(String weather) {
		this.weather = weather;
	}
	
	public String get_weather() {
		return weather;
	}
	
	public void set_location(String location) {
		this.location = location;
	}
	
	public String get_location() {
		return location;
	}
}

