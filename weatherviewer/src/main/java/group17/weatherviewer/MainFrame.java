package group17.weatherviewer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame {

	private JFrame frame;
	private JTextField textField;
	private JButton buttonFavourite;
	private JTextField barSearch;
	private JLabel labelCity;
	private JLabel labelTemp;
	private JLabel labelWind;
	private JLabel iconSkyCondition;
	private JLabel lblAirPressure;
	private JLabel lblMaxTemp;
	private JLabel lblMinTemp;
	private JLabel lblSunrise;
	private JLabel lblSunset;
	private JLabel labelHumidityInfo;
	private JLabel labelAirPressureInfo;
	private JLabel labelMaxTempInfo;
	private JLabel labelMinTempInfo;
	private JLabel labelSunriseInfo;
	private JLabel labelSunsetInfo;
	private JLabel labelSkyCondition;
	private JButton buttonLongTerm;
	private JButton buttonShortTerm;
	private JButton buttonRefresh;
	private JButton buttonToCelsius;
	private JButton buttonToFahrenheit;
	private JLabel label12AM;
	private JLabel label3AM;
	private JLabel label6AM;
	private JLabel label9AM;
	private JLabel label12PM;
	private JLabel label3PM;
	private JLabel label6PM;
	private JLabel label9PM;
	private JLabel labelMon;
	private JLabel labelTues;
	private JLabel labelWed;
	private JLabel labelThurs;
	private JLabel labelFri;
	private JLabel labelSat;
	private JLabel labelSun;
	private JScrollPane scrollPane;
	private JLabel lblWind;
	private JLabel lblHumidity;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// attributes
		String temp, windSpeed, airPressure, humidity, minTemp, maxTemp, sunRise, sunSet, windDirection, skyCondition, location;
		// hard coded initializations
        //in the future none of these actually have to be stored, we can just do weatherObject.getTemp() etc. -TE
		location = "Toronto, Ont.";
		temp = "999";
		windSpeed = "999";
		windDirection = "East";
		humidity = "999";
		airPressure = "999";
		maxTemp = "999";
		minTemp = "999";
		sunRise = "9999";
		sunSet = "9999";
		skyCondition = "Sunny";

		// set background to sky condition
		Background backgroundImage = new Background(
				Toolkit.getDefaultToolkit().getImage(
		MainFrame.class.getResource("default_background.jpg")));
		if (skyCondition.equalsIgnoreCase("Sunny")) {
            backgroundImage = new Background(Toolkit.getDefaultToolkit()
                .getImage(getClass().getResource("sunny_background.jpg")));
		} else if (skyCondition.equalsIgnoreCase("Cloudy")) {
            backgroundImage = new Background(Toolkit.getDefaultToolkit()
                .getImage(getClass().getResource("cloudy_background.jpg")));
		} else if (skyCondition.equalsIgnoreCase("Rainy")) {
            backgroundImage = new Background(Toolkit.getDefaultToolkit()
            .getImage(getClass().getResource("rainy_background.jpg")));
		} 
		
		frame = new JFrame();
		frame.setLocationRelativeTo(null);
		frame.setSize(800, 520);
		frame.getContentPane().add(backgroundImage);
		backgroundImage.setLayout(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		//begin initialize buttons
		
		// refresh button
		buttonRefresh = new JButton("");
		buttonRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                //update weather here
            }
		});
		buttonRefresh.setIcon(new ImageIcon(getClass().getResource("/refresh_icon.png")));
		buttonRefresh.setBounds(540, 16, 41, 37);
		buttonRefresh.setOpaque(false);
		buttonRefresh.setContentAreaFilled(false);
		buttonRefresh.setBorderPainted(false);
		backgroundImage.add(buttonRefresh);

		// favorite Button
		buttonFavourite = new JButton("");
		buttonFavourite.setIcon(new ImageIcon(getClass().getResource("/star_icon.png")));
        buttonFavourite.setOpaque(false);
		buttonFavourite.setContentAreaFilled(false);
		buttonFavourite.setBorderPainted(false);
		buttonFavourite.setBounds(759, 16, 41, 37);
		backgroundImage.add(buttonFavourite);

		// Short Term Button
		buttonShortTerm = new JButton("Short Term");
		buttonShortTerm.setForeground(Color.WHITE);
		buttonShortTerm.setFont(new Font("Helvetica", Font.PLAIN, 15));
		buttonShortTerm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				shortTermView();
			}
		});
		buttonShortTerm.setOpaque(false);
		buttonShortTerm.setContentAreaFilled(false);
		buttonShortTerm.setBorderPainted(false);
		buttonShortTerm.setBounds(19, 328, 120, 29);
		backgroundImage.add(buttonShortTerm);

		// Long Term Button
		buttonLongTerm = new JButton("Long Term");
		buttonLongTerm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				longTermView();
			}
		});

		buttonLongTerm.setOpaque(false);
		buttonLongTerm.setForeground(Color.GRAY);
		buttonLongTerm.setFont(new Font("Helvetica", Font.PLAIN, 15));
		buttonLongTerm.setContentAreaFilled(false);
		buttonLongTerm.setBorderPainted(false);
		buttonLongTerm.setBounds(95, 328, 127, 29);
		backgroundImage.add(buttonLongTerm);
		
		//toCelsius button
		buttonToCelsius = new JButton("°C");
		buttonToCelsius.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonToFahrenheit.setForeground(Color.WHITE);
			}
		});
		buttonToCelsius.setOpaque(false);
		buttonToCelsius.setForeground(Color.WHITE);
		buttonToCelsius.setFont(new Font("Helvetica", Font.PLAIN, 18));
		buttonToCelsius.setContentAreaFilled(false);
		buttonToCelsius.setBorderPainted(false);
		buttonToCelsius.setBounds(475, 283, 96, 29);
		backgroundImage.add(buttonToCelsius);
		
		//toFarenheit button
		buttonToFahrenheit = new JButton("°F");
		buttonToFahrenheit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonToCelsius.setForeground(Color.GRAY);
			}
		});
		buttonToFahrenheit.setOpaque(false);
		buttonToFahrenheit.setForeground(Color.GRAY);
		buttonToFahrenheit.setFont(new Font("Helvetica", Font.PLAIN, 18));
		buttonToFahrenheit.setContentAreaFilled(false);
		buttonToFahrenheit.setBorderPainted(false);
		buttonToFahrenheit.setBounds(520, 283, 70, 29);
		backgroundImage.add(buttonToFahrenheit);
	
		//end initialize buttons
		
		//begin initialize MyLocations panel
		
		//Scroll Pane
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(595, 56, 195, 422);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		backgroundImage.add(scrollPane);
		
		// search bar
		barSearch = new JTextField();
		barSearch.setText("Search (City, Country)");
		barSearch.setBounds(590, 16, 171, 37);
		barSearch.setOpaque(false);
		backgroundImage.add(barSearch);
		barSearch.setColumns(10);

		//end initialize MyLocations panel
		
		//begin initialize LocalWeather panel
		
		// city label
		labelCity = new JLabel(location);
		labelCity.setForeground(Color.WHITE);
		labelCity.setFont(new Font("Helvetica", Font.PLAIN, 17));
		labelCity.setBounds(50, 25, 200, 37);
		backgroundImage.add(labelCity);

		// temperature label
		labelTemp = new JLabel(temp + "°C");
		labelTemp.setFont(new Font("Helvetica", Font.PLAIN, 93));
		labelTemp.setForeground(Color.WHITE);
		labelTemp.setBounds(50, 64, 318, 94);
		backgroundImage.add(labelTemp);
		
		//wind label
		lblWind = new JLabel("Wind:");
		lblWind.setForeground(Color.LIGHT_GRAY);
		lblWind.setFont(new Font("Helvetica", Font.PLAIN, 15));
		lblWind.setBounds(50, 170, 61, 15);
		backgroundImage.add(lblWind);
		
		//humidity label
		lblHumidity = new JLabel("Humidity:");
		lblHumidity.setForeground(Color.LIGHT_GRAY);
		lblHumidity.setFont(new Font("Helvetica", Font.PLAIN, 15));
		lblHumidity.setBounds(50, 190, 70, 15);
		backgroundImage.add(lblHumidity);
		
		//air pressure label
		lblAirPressure = new JLabel("Air Pressure:");
		lblAirPressure.setForeground(Color.LIGHT_GRAY);
		lblAirPressure.setFont(new Font("Helvetica", Font.PLAIN, 15));
		lblAirPressure.setBounds(50, 210, 96, 15);
		backgroundImage.add(lblAirPressure);
		
		//max temp label
		lblMaxTemp = new JLabel("Max Temp:");
		lblMaxTemp.setForeground(Color.LIGHT_GRAY);
		lblMaxTemp.setFont(new Font("Helvetica", Font.PLAIN, 15));
		lblMaxTemp.setBounds(50, 230, 96, 15);
		backgroundImage.add(lblMaxTemp);
		
		//min temp label
		lblMinTemp = new JLabel("Min. Temp:");
		lblMinTemp.setForeground(Color.LIGHT_GRAY);
		lblMinTemp.setFont(new Font("Helvetica", Font.PLAIN, 15));
		lblMinTemp.setBounds(50, 250, 96, 15);
		backgroundImage.add(lblMinTemp);
		
		//sunrise label
		lblSunrise = new JLabel("Sunrise:");
		lblSunrise.setForeground(Color.LIGHT_GRAY);
		lblSunrise.setFont(new Font("Helvetica", Font.PLAIN, 15));
		lblSunrise.setBounds(50, 270, 61, 15);
		backgroundImage.add(lblSunrise);
		
		//sunset label
		lblSunset = new JLabel("Sunset:");
		lblSunset.setForeground(Color.LIGHT_GRAY);
		lblSunset.setFont(new Font("Helvetica", Font.PLAIN, 15));
		lblSunset.setBounds(50, 290, 58, 15);
		backgroundImage.add(lblSunset);
	
		//end initialize LocalWeather panel
		
		// begin initialize LocalWeather conditions
		
		//wind info
		
		JLabel labelWindInfo = new JLabel(windSpeed + " km/h " + windDirection);
		labelWindInfo.setForeground(Color.WHITE);
		labelWindInfo.setFont(new Font("SansSerif", Font.PLAIN, 15));
		labelWindInfo.setBounds(103, 170, 200, 15);
		backgroundImage.add(labelWindInfo);
		
		//humidity info
		labelHumidityInfo = new JLabel(humidity + "%");
		labelHumidityInfo.setForeground(Color.WHITE);
		labelHumidityInfo.setFont(new Font("Helvetica", Font.PLAIN, 15));
		labelHumidityInfo.setBounds(130, 190, 200, 15);
		backgroundImage.add(labelHumidityInfo);
		
		//air pressure info
		labelAirPressureInfo = new JLabel(airPressure + "kPa");
		labelAirPressureInfo.setForeground(Color.WHITE);
		labelAirPressureInfo.setFont(new Font("Helvetica", Font.PLAIN, 15));
		labelAirPressureInfo.setBounds(158, 210, 200, 15);
		backgroundImage.add(labelAirPressureInfo);
		
		//max temp info
		labelMaxTempInfo = new JLabel(maxTemp + "°C");
		labelMaxTempInfo.setForeground(Color.WHITE);
		labelMaxTempInfo.setFont(new Font("Helvetica", Font.PLAIN, 15));
		labelMaxTempInfo.setBounds(145, 230, 200, 15);
		backgroundImage.add(labelMaxTempInfo);
		
		//min temp info
		labelMinTempInfo = new JLabel(minTemp + "°C");
		labelMinTempInfo.setForeground(Color.WHITE);
		labelMinTempInfo.setFont(new Font("Helvetica", Font.PLAIN, 15));
		labelMinTempInfo.setBounds(145, 250, 200, 15);
		backgroundImage.add(labelMinTempInfo);
		
		
		//sunrise info
		labelSunriseInfo = new JLabel(sunRise + "");
		labelSunriseInfo.setForeground(Color.WHITE);
		labelSunriseInfo.setFont(new Font("Helvetica", Font.PLAIN, 15));
		labelSunriseInfo.setBounds(130, 270, 200, 15);
		backgroundImage.add(labelSunriseInfo);
		
		//sunset info
		labelSunsetInfo = new JLabel(sunSet + "");
		labelSunsetInfo.setForeground(Color.WHITE);
		labelSunsetInfo.setFont(new Font("Helvetica", Font.PLAIN, 15));
		labelSunsetInfo.setBounds(130, 291, 200, 15);
		backgroundImage.add(labelSunsetInfo);
		
		//sky condition info
		labelSkyCondition = new JLabel(skyCondition);
		labelSkyCondition.setForeground(Color.WHITE);
		labelSkyCondition.setFont(new Font("Helvetica", Font.PLAIN, 17));
		labelSkyCondition.setBounds(381, 25, 200, 37);
		backgroundImage.add(labelSkyCondition);
		
		//end initialize LocalWeather conditions
		
		//being initialize short-term forecast panel
		
		label12AM = new JLabel("12:00am");
		label12AM.setForeground(Color.LIGHT_GRAY);
		label12AM.setFont(new Font("Helvetica", Font.PLAIN, 15));
		label12AM.setBounds(50, 360, 58, 15);
		backgroundImage.add(label12AM);
		
		label3AM = new JLabel("  3:00am");
		label3AM.setForeground(Color.LIGHT_GRAY);
		label3AM.setFont(new Font("Helvetica", Font.PLAIN, 15));
		label3AM.setBounds(115, 360, 58, 15);
		backgroundImage.add(label3AM);
		
		label6AM = new JLabel("  6:00am");
		label6AM.setForeground(Color.LIGHT_GRAY);
		label6AM.setFont(new Font("Helvetica", Font.PLAIN, 15));
		label6AM.setBounds(180, 360, 58, 15);
		backgroundImage.add(label6AM);
		
		label9AM = new JLabel("  9:00am");
		label9AM.setForeground(Color.LIGHT_GRAY);
		label9AM.setFont(new Font("Helvetica", Font.PLAIN, 15));
		label9AM.setBounds(245, 360, 58, 15);
		backgroundImage.add(label9AM);
		
		label12PM = new JLabel("12:00pm");
		label12PM.setForeground(Color.LIGHT_GRAY);
		label12PM.setFont(new Font("Helvetica", Font.PLAIN, 15));
		label12PM.setBounds(310, 360, 58, 15);
		backgroundImage.add(label12PM);
		
		label3PM = new JLabel("  3:00pm");
		label3PM.setForeground(Color.LIGHT_GRAY);
		label3PM.setFont(new Font("Helvetica", Font.PLAIN, 15));
		label3PM.setBounds(375, 360, 58, 15);
		backgroundImage.add(label3PM);
		
		label6PM = new JLabel("  6:00pm");
		label6PM.setForeground(Color.LIGHT_GRAY);
		label6PM.setFont(new Font("Helvetica", Font.PLAIN, 15));
		label6PM.setBounds(440, 360, 58, 15);
		backgroundImage.add(label6PM);
		
		label9PM = new JLabel("  9:00pm");
		label9PM.setForeground(Color.LIGHT_GRAY);
		label9PM.setFont(new Font("Helvetica", Font.PLAIN, 15));
		label9PM.setBounds(505, 360, 58, 15);
		backgroundImage.add(label9PM);
		
		//end initialize Short-Term Forecast panel
		
		//begin initialize Long-Term Forecast panel
		
		labelMon = new JLabel("Mon.");
		labelMon.setForeground(Color.LIGHT_GRAY);
		labelMon.setFont(new Font("Helvetica", Font.PLAIN, 15));
		labelMon.setBounds(100, 360, 58, 15);
		backgroundImage.add(labelMon);
		
		labelTues = new JLabel("Tues.");
		labelTues.setForeground(Color.LIGHT_GRAY);
		labelTues.setFont(new Font("Helvetica", Font.PLAIN, 15));
		labelTues.setBounds(165, 360, 58, 15);
		backgroundImage.add(labelTues);
		
		labelWed = new JLabel("Wed.");
		labelWed.setForeground(Color.LIGHT_GRAY);
		labelWed.setFont(new Font("Helvetica", Font.PLAIN, 15));
		labelWed.setBounds(230, 360, 58, 15);
		backgroundImage.add(labelWed);
		
		labelThurs = new JLabel("Thurs.");
		labelThurs.setForeground(Color.LIGHT_GRAY);
		labelThurs.setFont(new Font("Helvetica", Font.PLAIN, 15));
		labelThurs.setBounds(290, 360, 58, 15);
		backgroundImage.add(labelThurs);
		
		labelFri = new JLabel("Fri.");
		labelFri.setForeground(Color.LIGHT_GRAY);
		labelFri.setFont(new Font("Helvetica", Font.PLAIN, 15));
		labelFri.setBounds(365, 360, 58, 15);
		backgroundImage.add(labelFri);
		
		labelSat = new JLabel("Sat.");
		labelSat.setForeground(Color.LIGHT_GRAY);
		labelSat.setFont(new Font("Helvetica", Font.PLAIN, 15));
		labelSat.setBounds(425, 360, 58, 15);
		backgroundImage.add(labelSat);
		
		labelSun = new JLabel("Sun.");
		labelSun.setForeground(Color.LIGHT_GRAY);
		labelSun.setFont(new Font("Helvetica", Font.PLAIN, 15));
		labelSun.setBounds(490, 360, 58, 15);
		backgroundImage.add(labelSun);

		//end initialize Long-Term Conditions

        //testing code to prove that UserPreferences functions at least at a basic level - TE
		/*
        try {
            UserPreferences prefs = new UserPreferences();
            //prints c (default)
            System.out.println(prefs.isCelsius()?"Celsius":"Fahrenheit");
            prefs.setCelsius(false);
            //prints f
			System.out.println(prefs.isCelsius()?"Celsius":"Fahrenheit");
            UserPreferences.savePrefs(prefs);

            //create a new preferences and load the old one
            UserPreferences new_prefs = UserPreferences.getPrefs();
            //still f instead of default c because we saved & loaded it
			System.out.println(prefs.isCelsius()?"Celsius":"Fahrenheit");
        }
        catch(Exception e) {
            e.printStackTrace();
        }*/

	}
	
		
	
	//enable short term view
	public void shortTermView (){
		buttonLongTerm.setForeground(Color.GRAY);
		buttonShortTerm.setForeground(Color.WHITE);
		labelMon.setVisible(false);
		labelTues.setVisible(false);
		labelWed.setVisible(false);
		labelThurs.setVisible(false);
		labelFri.setVisible(false);
		labelSat.setVisible(false);
		labelSun.setVisible(false);
		label12AM.setVisible(true);
		label3AM.setVisible(true);
		label6AM.setVisible(true);
		label9AM.setVisible(true);
		label12PM.setVisible(true);
		label3PM.setVisible(true);
		label6PM.setVisible(true);
		label9PM.setVisible(true);
	}
	//enable long term view
	public void longTermView (){
		buttonLongTerm.setForeground(Color.WHITE);
		buttonShortTerm.setForeground(Color.GRAY);
		labelMon.setVisible(true);
		labelTues.setVisible(true);
		labelWed.setVisible(true);
		labelThurs.setVisible(true);
		labelFri.setVisible(true);
		labelSat.setVisible(true);
		labelSun.setVisible(true);
		label12AM.setVisible(false);
		label3AM.setVisible(false);
		label6AM.setVisible(false);
		label9AM.setVisible(false);
		label12PM.setVisible(false);
		label3PM.setVisible(false);
		label6PM.setVisible(false);
		label9PM.setVisible(false);
	}
}
