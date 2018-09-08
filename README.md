Using Java to parse JSON data from the OpenWeatherMap API and with the help of a chatbot on the Freenode IRC channel, this project successfully fetches weather statistics (from a given list of commands) of any city/local-area.

By default, the program will connect to the channel "#Hritik's Project2 - WeatherAPI".  The bot's nickname is "Shaqwanda".

If the user types "time" (ignoring case), then the program will display the time of the local area (Dallas). If the user inputs "weather" and the name of a city as a second word, then the program fetches data from the OpenWeatherMap API and parses the JSON data to display the weather statistics. It will display the current weather, the high/low temperatures for the day along with the current temperature.
