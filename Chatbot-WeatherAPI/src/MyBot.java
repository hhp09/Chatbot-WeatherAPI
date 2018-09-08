// Name: Hritik Panchasara
// netID: hhp160130
// Description: This class file creates our chatbot using the PircBot functionalities. 
// 				It connects the bot to our channel and establishes the time and weather input and the replies. 
//				The pircbot.jar and gson.jar files have been built into the project. 

import org.jibble.pircbot.*;
	
public class MyBot extends PircBot {
	
	static final String channel = "#Hritik's Project2 - WeatherAPI";
	static final String defaultlocation = "Richardson";
	
	public MyBot() {
		this.setName("Shaqwanda");		// Setting a name for our bot. 
	}
	
	public void onMessage(String channel, String sender, String login, String hostname, String message) {
		if(message.equalsIgnoreCase("time"))	// When the user types time, it displays a string with the current, local time in Richardson.
		{
			String time = new java.util.Date().toString();
			sendMessage(channel, sender + ": The time is " + time);
		}
		
		if(message.contains("weather"))			// This loop checks if the user has input the word "weather". The user has to input the city name after typing weather.
		{										
			String location =	 defaultlocation;
			
			String[] input = message.split(" ");	// This helps us to look for the city name. If the city name is invalid, but the user has input weather, 
			if(input.length == 2)					// then the default location is set to Richardson. 
			{
				if(input[0].equals("weather"))
				{
					location = input[1];
				}
				
				else
				{
					location = input[0];
				}
			}
		
		FormattingData data = WeatherAPI.get_weather(location);		// Creating an instance
		if(data == null)
		{
			sendMessage(channel, "Error: Cannot detect location. Displaying local weather instead.");
			data = WeatherAPI.get_weather(defaultlocation);
			
			if(data == null)
			{
				sendMessage(channel, "This Weather API is facing issues. Restart your program and try again.");
			}
		}
	
		String weatherstats = data.toString();	// After the data has been parsed, the toString() function prints the line on the designated channel.
		sendMessage(channel, weatherstats);
	}
	}
	
	public static void main(String[] args) throws Exception {
		MyBot bot = new MyBot();	// Creating an instance of our bot...
		bot.connect("irc.freenode.net");	// Which then becomes a client on the freenode server
		bot.setVerbose(true);
		bot.joinChannel(channel);	// Prints log entries
		bot.sendMessage(channel, "Welcome to Hritik's chatbot! A place where you can find the weather of any location or the current local time.");
		bot.sendMessage(channel, "To retrieve information about the current weather, please type /'weather/' followed by a space and the city name (limited to one word only).");
		bot.sendMessage(channel, "Type time to get the current local time.");
	}
	
}
