package group17.weatherviewer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class JsonParser {

	String owmUrl;

	// Current Weather url
	public JsonParser(String url) throws UnsupportedEncodingException {
		this.owmUrl = url;
	}

	public String getData() {
		StringBuffer SBR;

		SBR = new StringBuffer();

		try {
			URL url = new URL(owmUrl);
			URLConnection connection = url.openConnection();
			BufferedReader BReader = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			String line = null;
			while ((line = BReader.readLine()) != null)
				SBR.append(line + " ");
			BReader.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String WeatherData = SBR.toString();
		return WeatherData;
	}
}