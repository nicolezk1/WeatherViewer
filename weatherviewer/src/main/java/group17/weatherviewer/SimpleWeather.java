package group17.weatherviewer;
import javax.swing.*;

public class SimpleWeather {

    private int temp, minTemp, maxTemp;
    //private ImageIcon skyIcon;
	//are we going to store this here or elsewhere? 

	public SimpleWeather(JSONObject js) {
		//parse JSON and assign fields
	}

    public int getTemp() {
        return temp;
    }

    public int getMinTemp() {
        return minTemp;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    /*public ImageIcon getSkyIcon() {
        return skyIcon;
    }*/
}
