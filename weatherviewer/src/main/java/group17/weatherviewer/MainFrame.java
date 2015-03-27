package group17.weatherviewer;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainFrame {

	// this is incredibly messy
	// a lot of these can be local fields too
	private static Font font;

	private JFrame frame;

	private ImageIcon backgroundImage;
	private String skyConditionIconLarge;
	private String skyConditionIconSmall;
	private String skyConditionBackground;

	private JLabel backgroundLabel;

	private JTextField textField;
	private JTextField barSearch;

	private JScrollPane scrollPane;

	private JButton buttonFavourite;
	private JButton buttonLongTerm;
	private JButton buttonShortTerm;
	private JButton buttonRefresh;
	private JButton buttonToCelsius;
	private JButton buttonToFahrenheit;
	private JLabel labelSkyConditionIcon;
	private JLabel labelAirPressure;
	private JLabel labelSunrise;
	private JLabel labelSunset;
	private JLabel labelSky;
	private JLabel labelWind;
	private JLabel labelHumidity;
	private JLabel labelLocation;
	private JLabel labelPrecipitation;
	private JLabel labelTempInfo;
	private JLabel labelWindInfo;
	private JLabel labelHumidityInfo;
	private JLabel labelAirPressureInfo;
	private JLabel labelCurrentMMTempInfo;
	private JLabel labelSunriseInfo;
	private JLabel labelSunsetInfo;
	private JLabel labelSkyConditionInfo;
	private JLabel labelPrecipitationInfo;
	private JLabel labelUpdated;
	private JLabel labelUpdatedInfo;
	private JLabel label12AM;
	private JLabel label12AMSkyConditionIcon;
	private JLabel label12AMTempInfo;
	private JLabel label12AMSkyConditionInfo;
	private JLabel label12AMPrecipitation;
	private JLabel label3AM;
	private JLabel label3AMSkyConditionIcon;
	private JLabel label3AMTempInfo;
	private JLabel label3AMSkyConditionInfo;
	private JLabel label3AMPrecipitation;
	private JLabel label6AM;
	private JLabel label6AMSkyConditionIcon;
	private JLabel label6AMTempInfo;
	private JLabel label6AMSkyConditionInfo;
	private JLabel label6AMPrecipitation;
	private JLabel label9AM;
	private JLabel label9AMSkyConditionIcon;
	private JLabel label9AMTempInfo;
	private JLabel label9AMSkyConditionInfo;
	private JLabel label9AMPrecipitation;
	private JLabel label12PM;
	private JLabel label12PMSkyConditionIcon;
	private JLabel label12PMTempInfo;
	private JLabel label12PMSkyConditionInfo;
	private JLabel label12PMPrecipitation;
	private JLabel label3PM;
	private JLabel label3PMSkyConditionIcon;
	private JLabel label3PMTempInfo;
	private JLabel label3PMSkyConditionInfo;
	private JLabel label3PMPrecipitation;
	private JLabel label6PM;
	private JLabel label6PMSkyConditionIcon;
	private JLabel label6PMTempInfo;
	private JLabel label6PMSkyConditionInfo;
	private JLabel label6PMPrecipitation;
	private JLabel label9PM;
	private JLabel label9PMSkyConditionIcon;
	private JLabel label9PMTempInfo;
	private JLabel label9PMSkyConditionInfo;
	private JLabel label9PMPrecipitation;
	private JLabel labelDay1Info;
	private JLabel labelDay1TempInfo;
	private JLabel labelDay1SkyConditionIcon;
	private JLabel labelDay1SkyConditionInfo;
	private JLabel labelDay1MaxTemp;
	private JLabel labelDay1MinTemp;
	private JLabel labelDay2Info;
	private JLabel labelDay2TempInfo;
	private JLabel labelDay2SkyConditionInfo;
	private JLabel labelDay2SkyConditionIcon;
	private JLabel labelDay2MaxTemp;
	private JLabel labelDay2MinTemp;
	private JLabel labelDay3Info;
	private JLabel labelDay3TempInfo;
	private JLabel labelDay3SkyConditionInfo;
	private JLabel labelDay3SkyConditionIcon;
	private JLabel labelDay3MaxTemp;
	private JLabel labelDay3MinTemp;
	private JLabel labelDay4Info;
	private JLabel labelDay4TempInfo;
	private JLabel labelDay4SkyConditionInfo;
	private JLabel labelDay4SkyConditionIcon;
	private JLabel labelDay4MaxTemp;
	private JLabel labelDay4MinTemp;
	private JLabel labelDay5Info;
	private JLabel labelDay5TempInfo;
	private JLabel labelDay5SkyConditionInfo;
	private JLabel labelDay5SkyConditionIcon;
	private JLabel labelDay5MaxTemp;
	private JLabel labelDay5MinTemp;
	private JLabel labelDay6Info;
	private JLabel labelDay6TempInfo;
	private JLabel labelDay6SkyConditionInfo;
	private JLabel labelDay6SkyConditionIcon;
	private JLabel labelDay6MaxTemp;
	private JLabel labelDay6MinTemp;
	private JLabel labelDay7Info;
	private JLabel labelDay7TempInfo;
	private JLabel labelDay7SkyConditionInfo;
	private JLabel labelDay7SkyConditionIcon;
	private JLabel labelDay7MaxTemp;
	private JLabel labelDay7MinTemp;

	private DateFormat dateFormat;
	private Calendar cal;
	private String lastUpdated;

	private JList listLocations;
	private DefaultListModel listModel;

	private UserPreferences prefs;

    private CurrentWeather currentWeather;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
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
		prefs = UserPreferences.getPrefs();
		createFont();

		// / BEGIN INITIALIZING FRAME ///
		// better to use the classpath method, works on all systems (old method
		// didn't work for me)
		backgroundImage = new ImageIcon(getClass().getResource(
				"/backgrounds/default.jpg"));
		backgroundLabel = new JLabel(backgroundImage);
		backgroundLabel.setSize(800, 570);
		frame = new JFrame("Group 17 Weather Viewer");
		frame.setLocationRelativeTo(null);
		frame.setSize(800, 570);
		frame.setContentPane(backgroundLabel);
		frame.setResizable(false);

		// this window listener contains a method windowClosing which is called
		// whenever the window is closed
		// therefore, we need to save preferences and anything else we do upon
		// closing here. -TE
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				// save the preferences
				UserPreferences.savePrefs(prefs);
				frame.dispose();
			}
		});
		// not required now that we have window listener
		// frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// / END INITIALIZING FRAME ///

		// / BEGIN INITIALIZING LOCAL WEATHER VIEW PANEL ///

		// city label
		final String labelLocationInit = "Please select or enter in a city.";
		labelLocation = new JLabel("");
		labelLocation.setText(labelLocationInit);
		labelLocation.setForeground(Color.WHITE);
		labelLocation.setFont(font.deriveFont(17f));
		labelLocation.setBounds(50, 20, 300, 37);
		frame.getContentPane().add(labelLocation);

		// temperature label
		labelTempInfo = new JLabel("");
		labelTempInfo.setFont(font.deriveFont(85f));
		labelTempInfo.setForeground(Color.WHITE);
		labelTempInfo.setBounds(50, 50, 318, 94);
		frame.getContentPane().add(labelTempInfo);

		// wind label
		labelSky = new JLabel("Sky:");
		labelSky.setForeground(Color.LIGHT_GRAY);
		labelSky.setFont(font.deriveFont(15f));
		labelSky.setBounds(50, 150, 61, 15);
		//frame.getContentPane().add(labelSky);
		
		// wind label
		labelWind = new JLabel("Wind Speed:");
		labelWind.setForeground(Color.LIGHT_GRAY);
		labelWind.setFont(font.deriveFont(15f));
		labelWind.setBounds(50, 200, 100, 15);
		frame.getContentPane().add(labelWind);

		// humidity label
		labelHumidity = new JLabel("Humidity:");
		labelHumidity.setForeground(Color.LIGHT_GRAY);
		labelHumidity.setFont(font.deriveFont(15f));
		labelHumidity.setBounds(50, 225, 70, 15);
		frame.getContentPane().add(labelHumidity);

		// air pressure label
		labelAirPressure = new JLabel("Air Pressure:");
		labelAirPressure.setForeground(Color.LIGHT_GRAY);
		labelAirPressure.setFont(font.deriveFont(15f));
		labelAirPressure.setBounds(50, 250, 96, 15);
		frame.getContentPane().add(labelAirPressure);


		// sunrise label
		labelSunrise = new JLabel("Sunrise:");
		labelSunrise.setForeground(Color.LIGHT_GRAY);
		labelSunrise.setFont(font.deriveFont(15f));
		labelSunrise.setBounds(350, 200, 61, 15);
		frame.getContentPane().add(labelSunrise);

		// sunset label
		labelSunset = new JLabel("Sunset:");
		labelSunset.setForeground(Color.LIGHT_GRAY);
		labelSunset.setFont(font.deriveFont(15f));
		labelSunset.setBounds(350, 225, 58, 15);
		frame.getContentPane().add(labelSunset);
		
		// precipitation label
		labelPrecipitation = new JLabel("Precipitation:");
		labelPrecipitation.setForeground(Color.LIGHT_GRAY);
		labelPrecipitation.setFont(font.deriveFont(15f));
		labelPrecipitation.setBounds(350, 250, 98, 15);
		frame.getContentPane().add(labelPrecipitation);
		
		// updated label
		labelUpdated = new JLabel("Last Updated:");
		labelUpdated.setForeground(Color.LIGHT_GRAY);
		labelUpdated.setFont(font.deriveFont(15f));
		labelUpdated.setBounds(150, 285, 98, 15);
		frame.getContentPane().add(labelUpdated);
		
		// wind info
		labelWindInfo = new JLabel("");
		labelWindInfo.setForeground(Color.WHITE);
		labelWindInfo.setFont(font.deriveFont(15f));
		labelWindInfo.setBounds(150, 200, 200, 15);
		frame.getContentPane().add(labelWindInfo);

		// humidity info
		labelHumidityInfo = new JLabel("");
		labelHumidityInfo.setForeground(Color.WHITE);
		labelHumidityInfo.setFont(font.deriveFont(15f));
		labelHumidityInfo.setBounds(150, 225, 200, 15);
		frame.getContentPane().add(labelHumidityInfo);

		// air pressure info
		labelAirPressureInfo = new JLabel("");
		labelAirPressureInfo.setForeground(Color.WHITE);
		labelAirPressureInfo.setFont(font.deriveFont(15f));
		labelAirPressureInfo.setBounds(150, 250, 200, 15);
		frame.getContentPane().add(labelAirPressureInfo);
	
		
		// max/min temp info
		labelCurrentMMTempInfo = new JLabel("");
		labelCurrentMMTempInfo.setForeground(Color.WHITE);
		labelCurrentMMTempInfo.setFont(font.deriveFont(17f));
		labelCurrentMMTempInfo.setBounds(75, 135, 200, 15);
		frame.getContentPane().add(labelCurrentMMTempInfo);

		// sunrise info
		labelSunriseInfo = new JLabel("");
		labelSunriseInfo.setForeground(Color.WHITE);
		labelSunriseInfo.setFont(font.deriveFont(15f));
		labelSunriseInfo.setBounds(450, 200, 200, 15);
		frame.getContentPane().add(labelSunriseInfo);

		// sunset info
		labelSunsetInfo = new JLabel("");
		labelSunsetInfo.setForeground(Color.WHITE);
		labelSunsetInfo.setFont(font.deriveFont(15f));
		labelSunsetInfo.setBounds(450, 225, 200, 15);
		frame.getContentPane().add(labelSunsetInfo);
		
		// precipitation info
		labelPrecipitationInfo = new JLabel("");
		labelPrecipitationInfo.setForeground(Color.WHITE);
		labelPrecipitationInfo.setFont(font.deriveFont(15f));
		labelPrecipitationInfo.setBounds(450, 250, 200, 15);
		frame.getContentPane().add(labelPrecipitationInfo);

		// sky condition info;
		labelSkyConditionInfo = new JLabel("");
		labelSkyConditionInfo.setForeground(Color.WHITE);
		labelSkyConditionInfo.setFont(font.deriveFont(17f));
		labelSkyConditionInfo.setBounds(75, 155, 200, 30);
		frame.getContentPane().add(labelSkyConditionInfo);

		// sky condition Icon info
		labelSkyConditionIcon = new JLabel();
		labelSkyConditionIcon.setBounds(310, 15, 204, 181);
		frame.getContentPane().add(labelSkyConditionIcon);

		// updated label info
		labelUpdatedInfo = new JLabel("");
		labelUpdatedInfo.setForeground(Color.WHITE);
		labelUpdatedInfo.setFont(font.deriveFont(15f));
		labelUpdatedInfo.setBounds(260, 285, 98, 15);
		frame.getContentPane().add(labelUpdatedInfo);

		// date format shown in updated label
		dateFormat = new SimpleDateFormat("MMM dd HH:mm");
		
		// Refresh button
		buttonRefresh = new JButton("");
		buttonRefresh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String loc = labelLocation.getText();
				if(!(loc.equalsIgnoreCase(labelLocationInit)))
					refresh(labelLocation.getText());
				else
					labelLocation.setText(labelLocationInit);
			}
		});
		buttonRefresh.setIcon(new ImageIcon(getClass().getResource(
				"/icons/refresh_icon.png")));
		buttonRefresh.setBounds(540, 16, 41, 37);
		buttonRefresh.setOpaque(false);
		buttonRefresh.setContentAreaFilled(false);
		buttonRefresh.setBorderPainted(false);
		frame.getContentPane().add(buttonRefresh);

		// Short Term Button
		buttonShortTerm = new JButton("Short Term");
		buttonShortTerm.setForeground(Color.WHITE);
		buttonShortTerm.setFont(font.deriveFont(14f));
		buttonShortTerm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				toggleShortTerm(true);
			}
		});
		buttonShortTerm.setOpaque(false);
		buttonShortTerm.setContentAreaFilled(false);
		buttonShortTerm.setBorderPainted(false);
		buttonShortTerm.setBounds(19, 328, 120, 29);
		frame.getContentPane().add(buttonShortTerm);

		// Long Term Button
		buttonLongTerm = new JButton("Long Term");
		buttonLongTerm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                toggleShortTerm(false);
			}
		});

		buttonLongTerm.setOpaque(false);
		buttonLongTerm.setForeground(Color.GRAY);
		buttonLongTerm.setFont(font.deriveFont(14f));
		buttonLongTerm.setContentAreaFilled(false);
		buttonLongTerm.setBorderPainted(false);
		buttonLongTerm.setBounds(95, 328, 127, 29);
		frame.getContentPane().add(buttonLongTerm);

		// toCelsius button
		buttonToCelsius = new JButton("°C");
		buttonToCelsius.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// set preferences to celsius
				prefs.setTempUnit('c');
				buttonToCelsius.setForeground(Color.WHITE);
				buttonToFahrenheit.setForeground(Color.GRAY);
                setTemperatureFields();
			}
		});
		buttonToCelsius.setOpaque(false);

		buttonToCelsius.setFont(font.deriveFont(18f));
		buttonToCelsius.setContentAreaFilled(false);
		buttonToCelsius.setBorderPainted(false);
		buttonToCelsius.setBounds(475, 283, 75, 29);

		// toFarenheit button
		buttonToFahrenheit = new JButton("°F");
		buttonToFahrenheit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// set preferences to f
				prefs.setTempUnit('f');
				buttonToFahrenheit.setForeground(Color.WHITE);
				buttonToCelsius.setForeground(Color.GRAY);
                setTemperatureFields();
			}
		});
		buttonToFahrenheit.setOpaque(false);

		buttonToFahrenheit.setFont(font.deriveFont(18f));
		buttonToFahrenheit.setContentAreaFilled(false);
		buttonToFahrenheit.setBorderPainted(false);
		buttonToFahrenheit.setBounds(520, 283, 70, 29);
		// update the buttons to the color they should be initially
		if (prefs.getTempUnit() == 'c') {
			buttonToCelsius.setForeground(Color.WHITE);
			buttonToFahrenheit.setForeground(Color.GRAY);
		} else {
			buttonToCelsius.setForeground(Color.GRAY);
			buttonToFahrenheit.setForeground(Color.WHITE);
		}

		frame.getContentPane().add(buttonToCelsius);
		frame.getContentPane().add(buttonToFahrenheit);

		// / END INITIALIZATION OF LOCAL WEATHER VIEW PANEL ///

		// / BEGIN INITIALIZATION OF LOCATIONS PANEL ///

		// Scroll Pane
		scrollPane = new JScrollPane();
		scrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(595, 56, 205, 255);
		scrollPane.setOpaque(false);
		scrollPane.setBorder(null);
		scrollPane.getViewport().setOpaque(false);
		Border scrollBorder = BorderFactory.createLineBorder(new Color(255,255,255,40));
		scrollPane.setBorder(scrollBorder);
		scrollPane.setVisible(true);
		frame.getContentPane().add(scrollPane);

		// Locations list
		listModel = new DefaultListModel();

		// Add saved locations to current list
		for(String loc : prefs.getLocations()) { //loads the MyLocations arraylist into listModel
			listModel.addElement(loc);
		}

		listLocations = new JList(listModel);
		listLocations.setOpaque(false);
		listLocations.setBackground(new Color(0,0,0,0));
		listLocations.setForeground(Color.WHITE);
		ListSelectionModel lsm = listLocations.getSelectionModel();
		lsm.addListSelectionListener(new ListSelectionListener(){
			@Override
			public void valueChanged(ListSelectionEvent e){
				if (listLocations.getValueIsAdjusting() == false)
					refresh(listLocations.getSelectedValue().toString());
			}
		
		});
		scrollPane.setViewportView(listLocations);

		// Favorite Button
		buttonFavourite = new JButton();
		AddLocation addlocation = new AddLocation(buttonFavourite);
		buttonFavourite.addActionListener(addlocation);
		buttonFavourite.setEnabled(false);
		// buttonFavourite.setIcon(new ImageIcon(
		// "src/main/resources/icons/star_icon.png"));
		buttonFavourite.setIcon(new ImageIcon(getClass().getResource(
				"/icons/star_icon.png")));
		buttonFavourite.setOpaque(false);
		buttonFavourite.setContentAreaFilled(false);
		buttonFavourite.setBorderPainted(false);
		buttonFavourite.setBounds(762, 16, 41, 37);
		frame.getContentPane().add(buttonFavourite);

		// search bar
		barSearch = new JTextField();
		barSearch.setText("Search (City, Country)");
		barSearch.setToolTipText("Enter new locations here!");
		barSearch.setForeground(Color.WHITE);
		barSearch.addActionListener(addlocation);
		barSearch.getDocument().addDocumentListener(addlocation);
		barSearch.setBounds(595, 16, 171, 37);
		barSearch.setBackground(new Color(0,0,0,0));
		barSearch.setOpaque(false);
		barSearch.setColumns(10);
		Border searchBorder = BorderFactory.createLineBorder(new Color(255,255,255,40));
		barSearch.setBorder(searchBorder);
		barSearch.setVisible(true);
		barSearch.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if(barSearch.getText().equals("Search (City, Country)"))
					barSearch.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(barSearch.getText().equals(""))
					barSearch.setText("Search (City, Country)");
			}
		});

		frame.getContentPane().add(barSearch);

		// / END INITIALIZATION OF LOCATIONS PANEL ///

		// BEGIN INITIALIZATION OF SHORT-TERM FORECAST PANEL ///

		// 12AM
		// DAY
		label12AM = new JLabel("12:00am");
		label12AM.setForeground(Color.LIGHT_GRAY);
		label12AM.setFont(font.deriveFont(15f));
		label12AM.setBounds(70, 360, 58, 15);
		frame.getContentPane().add(label12AM);
		
		// Icon
		label12AMSkyConditionIcon = new JLabel();
		label12AMSkyConditionIcon.setBounds(70, 380, 55, 49);
		frame.getContentPane().add(label12AMSkyConditionIcon);
		
		// Skycondition
		label12AMSkyConditionInfo = new JLabel("");
		label12AMSkyConditionInfo.setForeground(Color.LIGHT_GRAY);
		label12AMSkyConditionInfo.setFont(font.deriveFont(11f));
		label12AMSkyConditionInfo.setBounds(70, 460, 75, 50);
		frame.getContentPane().add(label12AMSkyConditionInfo);
		
		// Temp
		label12AMTempInfo = new JLabel("");
		label12AMTempInfo.setForeground(Color.LIGHT_GRAY);
		label12AMTempInfo.setFont(font.deriveFont(15f));
		label12AMTempInfo.setBounds(80, 435, 58, 25);
		frame.getContentPane().add(label12AMTempInfo);
		
		// Precipitation
		label12AMPrecipitation = new JLabel("");
		label12AMPrecipitation.setForeground(Color.LIGHT_GRAY);
		label12AMPrecipitation.setFont(font.deriveFont(15f));
		label12AMPrecipitation.setBounds(80, 455, 58, 25);
		frame.getContentPane().add(label12AMPrecipitation);

		// 3AM
		//DAY
		label3AM = new JLabel(" 3:00am");
		label3AM.setForeground(Color.LIGHT_GRAY);
		label3AM.setFont(font.deriveFont(15f));
		label3AM.setBounds(155, 360, 58, 15);
		frame.getContentPane().add(label3AM);
		// Icon
		label3AMSkyConditionIcon = new JLabel();
		label3AMSkyConditionIcon.setBounds(155, 380, 55, 49);
		frame.getContentPane().add(label3AMSkyConditionIcon);
		// Skycondition
		label3AMSkyConditionInfo = new JLabel("");
		label3AMSkyConditionInfo.setForeground(Color.LIGHT_GRAY);
		label3AMSkyConditionInfo.setFont(font.deriveFont(11f));
		label3AMSkyConditionInfo.setBounds(155, 460, 75, 50);
		frame.getContentPane().add(label3AMSkyConditionInfo);
		// Temp
		label3AMTempInfo = new JLabel("");
		label3AMTempInfo.setForeground(Color.LIGHT_GRAY);
		label3AMTempInfo.setFont(font.deriveFont(15f));
		label3AMTempInfo.setBounds(165, 435, 58, 25);
		frame.getContentPane().add(label3AMTempInfo);
		// Precipitation
		label3AMPrecipitation = new JLabel("");
		label3AMPrecipitation.setForeground(Color.LIGHT_GRAY);
		label3AMPrecipitation.setFont(font.deriveFont(15f));
		label3AMPrecipitation.setBounds(165, 455, 58, 25);
		frame.getContentPane().add(label3AMPrecipitation);
		
		//6AM
		//DAY
		label6AM = new JLabel(" 6:00am");
		label6AM.setForeground(Color.LIGHT_GRAY);
		label6AM.setFont(font.deriveFont(15f));
		label6AM.setBounds(240, 360, 58, 15);
		frame.getContentPane().add(label6AM);
		// Icon
		label6AMSkyConditionIcon = new JLabel();
		label6AMSkyConditionIcon.setBounds(240, 380, 55, 49);
		frame.getContentPane().add(label6AMSkyConditionIcon);
		// Skycondition
		label6AMSkyConditionInfo = new JLabel("");
		label6AMSkyConditionInfo.setForeground(Color.LIGHT_GRAY);
		label6AMSkyConditionInfo.setFont(font.deriveFont(11f));
		label6AMSkyConditionInfo.setBounds(240, 460, 75, 50);
		frame.getContentPane().add(label6AMSkyConditionInfo);
		// Temp
		label6AMTempInfo = new JLabel("");
		label6AMTempInfo.setForeground(Color.LIGHT_GRAY);
		label6AMTempInfo.setFont(font.deriveFont(15f));
		label6AMTempInfo.setBounds(250, 435, 58, 25);
		frame.getContentPane().add(label6AMTempInfo);
		// Precipitation
		label6AMPrecipitation = new JLabel("");
		label6AMPrecipitation.setForeground(Color.LIGHT_GRAY);
		label6AMPrecipitation.setFont(font.deriveFont(15f));
		label6AMPrecipitation.setBounds(250, 455, 58, 25);
		frame.getContentPane().add(label6AMPrecipitation);
		//9AM
		//DAY
		label9AM = new JLabel(" 9:00am");
		label9AM.setForeground(Color.LIGHT_GRAY);
		label9AM.setFont(font.deriveFont(15f));
		label9AM.setBounds(325, 360, 58, 15);
		frame.getContentPane().add(label9AM);
		// Icon
		label9AMSkyConditionIcon = new JLabel();
		label9AMSkyConditionIcon.setBounds(325, 380, 55, 49);
		frame.getContentPane().add(label9AMSkyConditionIcon);
		// Skycondition
		label9AMSkyConditionInfo = new JLabel("");
		label9AMSkyConditionInfo.setForeground(Color.LIGHT_GRAY);
		label9AMSkyConditionInfo.setFont(font.deriveFont(11f));
		label9AMSkyConditionInfo.setBounds(325, 460, 75, 50);
		frame.getContentPane().add(label9AMSkyConditionInfo);
		// Temp
		label9AMTempInfo = new JLabel("");
		label9AMTempInfo.setForeground(Color.LIGHT_GRAY);
		label9AMTempInfo.setFont(font.deriveFont(15f));
		label9AMTempInfo.setBounds(335, 435, 58, 25);
		frame.getContentPane().add(label9AMTempInfo);
		// Precipitation
		label9AMPrecipitation = new JLabel("");
		label9AMPrecipitation.setForeground(Color.LIGHT_GRAY);
		label9AMPrecipitation.setFont(font.deriveFont(15f));
		label9AMPrecipitation.setBounds(335, 455, 58, 25);
		frame.getContentPane().add(label9AMPrecipitation);

		//12PM
		//DAY
		label12PM = new JLabel("12:00pm");
		label12PM.setForeground(Color.LIGHT_GRAY);
		label12PM.setFont(font.deriveFont(15f));
		label12PM.setBounds(410, 360, 58, 15);
		frame.getContentPane().add(label12PM);
		// Icon
		label12PMSkyConditionIcon = new JLabel();
		label12PMSkyConditionIcon.setBounds(410, 380, 55, 49);
		frame.getContentPane().add(label12PMSkyConditionIcon);
		// Skycondition
		label12PMSkyConditionInfo = new JLabel("");
		label12PMSkyConditionInfo.setForeground(Color.LIGHT_GRAY);
		label12PMSkyConditionInfo.setFont(font.deriveFont(11f));
		label12PMSkyConditionInfo.setBounds(410, 460, 75, 50);
		frame.getContentPane().add(label12PMSkyConditionInfo);
		// Temp
		label12PMTempInfo = new JLabel("");
		label12PMTempInfo.setForeground(Color.LIGHT_GRAY);
		label12PMTempInfo.setFont(font.deriveFont(15f));
		label12PMTempInfo.setBounds(420, 435, 58, 25);
		frame.getContentPane().add(label12PMTempInfo);
		// Precipitation
		label12PMPrecipitation = new JLabel("");
		label12PMPrecipitation.setForeground(Color.LIGHT_GRAY);
		label12PMPrecipitation.setFont(font.deriveFont(15f));
		label12PMPrecipitation.setBounds(420, 455, 58, 25);
		frame.getContentPane().add(label12PMPrecipitation);

		//3AM
		//DAY
		label3PM = new JLabel(" 3:00pm");
		label3PM.setForeground(Color.LIGHT_GRAY);
		label3PM.setFont(font.deriveFont(15f));
		label3PM.setBounds(495, 360, 58, 15);
		frame.getContentPane().add(label3PM);
		// Icon
		label3PMSkyConditionIcon = new JLabel();
		label3PMSkyConditionIcon.setBounds(495, 380, 55, 49);
		frame.getContentPane().add(label3PMSkyConditionIcon);
		// Skycondition
		label3PMSkyConditionInfo = new JLabel("");
		label3PMSkyConditionInfo.setForeground(Color.LIGHT_GRAY);
		label3PMSkyConditionInfo.setFont(font.deriveFont(11f));
		label3PMSkyConditionInfo.setBounds(495, 460, 75, 50);
		frame.getContentPane().add(label3PMSkyConditionInfo);
		// Temp
		label3PMTempInfo = new JLabel("");
		label3PMTempInfo.setForeground(Color.LIGHT_GRAY);
		label3PMTempInfo.setFont(font.deriveFont(15f));
		label3PMTempInfo.setBounds(505, 435, 58, 25);
		frame.getContentPane().add(label3PMTempInfo);
		// Precipitation
		label3PMPrecipitation = new JLabel("");
		label3PMPrecipitation.setForeground(Color.LIGHT_GRAY);
		label3PMPrecipitation.setFont(font.deriveFont(15f));
		label3PMPrecipitation.setBounds(505, 455, 58, 25);
		frame.getContentPane().add(label3PMPrecipitation);
		
		//6AM
		//DAY
		label6PM = new JLabel(" 6:00pm");
		label6PM.setForeground(Color.LIGHT_GRAY);
		label6PM.setFont(font.deriveFont(15f));
		label6PM.setBounds(580, 360, 58, 15);
		frame.getContentPane().add(label6PM);
		// Icon
		label6PMSkyConditionIcon = new JLabel();
		label6PMSkyConditionIcon.setBounds(580, 380, 55, 49);
		frame.getContentPane().add(label6PMSkyConditionIcon);
		// Skycondition
		label6PMSkyConditionInfo = new JLabel("");
		label6PMSkyConditionInfo.setForeground(Color.LIGHT_GRAY);
		label6PMSkyConditionInfo.setFont(font.deriveFont(11f));
		label6PMSkyConditionInfo.setBounds(580, 460, 75, 50);
		frame.getContentPane().add(label6PMSkyConditionInfo);
		// Temp
		label6PMTempInfo = new JLabel("");
		label6PMTempInfo.setForeground(Color.LIGHT_GRAY);
		label6PMTempInfo.setFont(font.deriveFont(15f));
		label6PMTempInfo.setBounds(590, 435, 58, 25);
		frame.getContentPane().add(label6PMTempInfo);
		// Precipitation
		label6PMPrecipitation  = new JLabel("");
		label6PMPrecipitation.setForeground(Color.LIGHT_GRAY);
		label6PMPrecipitation.setFont(font.deriveFont(15f));
		label6PMPrecipitation.setBounds(590, 455, 58, 25);
		frame.getContentPane().add(label6PMPrecipitation);
		
		//9AM
		//DAY
		label9PM = new JLabel(" 9:00pm");
		label9PM.setForeground(Color.LIGHT_GRAY);
		label9PM.setFont(font.deriveFont(15f));
		label9PM.setBounds(665, 360, 58, 15);
		frame.getContentPane().add(label9PM);
		// Icon
		label9PMSkyConditionIcon = new JLabel();
		label9PMSkyConditionIcon.setBounds(665, 380, 55, 49);
		frame.getContentPane().add(label9PMSkyConditionIcon);
		// Skycondition
		label9PMSkyConditionInfo = new JLabel("");
		label9PMSkyConditionInfo.setForeground(Color.LIGHT_GRAY);
		label9PMSkyConditionInfo.setFont(font.deriveFont(11f));
		label9PMSkyConditionInfo.setBounds(665, 460, 75, 50);
		frame.getContentPane().add(label9PMSkyConditionInfo);
		// Temp
		label9PMTempInfo = new JLabel("");
		label9PMTempInfo.setForeground(Color.LIGHT_GRAY);
		label9PMTempInfo.setFont(font.deriveFont(15f));
		label9PMTempInfo.setBounds(675, 435, 58, 25);
		frame.getContentPane().add(label9PMTempInfo);
		// Precipitation
		label9PMPrecipitation = new JLabel("");
		label9PMPrecipitation.setForeground(Color.LIGHT_GRAY);
		label9PMPrecipitation.setFont(font.deriveFont(15f));
		label9PMPrecipitation.setBounds(675, 455, 58, 25);
		frame.getContentPane().add(label9PMPrecipitation);

		// / END INITIALIZATION OF SHORT-TERM FORECAST PANEL ///

		// / BEGIN INITIALIZATION OF LONG-TERM FORECAST PANEL ///

		//Day1
		labelDay1Info = new JLabel("Mon.");
		labelDay1Info.setForeground(Color.LIGHT_GRAY);
		labelDay1Info.setFont(font.deriveFont(15f));
		labelDay1Info.setBounds(100, 360, 58, 15);
		frame.getContentPane().add(labelDay1Info);
		// Icon
		labelDay1SkyConditionIcon = new JLabel();
		labelDay1SkyConditionIcon.setBounds(85, 380, 55, 49);
		frame.getContentPane().add(labelDay1SkyConditionIcon);
		// Skycondition
		labelDay1SkyConditionInfo = new JLabel("");
		labelDay1SkyConditionInfo.setForeground(Color.LIGHT_GRAY);
		labelDay1SkyConditionInfo.setFont(font.deriveFont(11f));
		labelDay1SkyConditionInfo.setBounds(85, 435, 58, 15);
		frame.getContentPane().add(labelDay1SkyConditionInfo);
		// Temp
		labelDay1TempInfo = new JLabel("");
		labelDay1TempInfo.setForeground(Color.LIGHT_GRAY);
		labelDay1TempInfo.setFont(font.deriveFont(15f));
		labelDay1TempInfo.setBounds(85, 455, 58, 15);
		frame.getContentPane().add(labelDay1TempInfo);

		//Day2
		labelDay2Info = new JLabel("Tues.");
		labelDay2Info.setForeground(Color.LIGHT_GRAY);
		labelDay2Info.setFont(font.deriveFont(15f));
		labelDay2Info.setBounds(165, 360, 58, 15);
		frame.getContentPane().add(labelDay2Info);
		// Icon
		labelDay2SkyConditionIcon = new JLabel();
		labelDay2SkyConditionIcon.setBounds(150, 380, 55, 49);
		frame.getContentPane().add(labelDay2SkyConditionIcon);
		// Skycondition
		labelDay2SkyConditionInfo = new JLabel("");
		labelDay2SkyConditionInfo.setForeground(Color.LIGHT_GRAY);
		labelDay2SkyConditionInfo.setFont(font.deriveFont(11f));
		labelDay2SkyConditionInfo.setBounds(150, 435, 58, 15);
		frame.getContentPane().add(labelDay2SkyConditionInfo);
		// Temp
		labelDay2TempInfo = new JLabel("");
		labelDay2TempInfo.setForeground(Color.LIGHT_GRAY);
		labelDay2TempInfo.setFont(font.deriveFont(15f));
		labelDay2TempInfo.setBounds(150, 455, 58, 15);
		frame.getContentPane().add(labelDay2TempInfo);

		//Day3
		labelDay3Info = new JLabel("Wed.");
		labelDay3Info.setForeground(Color.LIGHT_GRAY);
		labelDay3Info.setFont(font.deriveFont(15f));
		labelDay3Info.setBounds(230, 360, 58, 15);
		frame.getContentPane().add(labelDay3Info);
		// Icon
		labelDay3SkyConditionIcon = new JLabel();
		labelDay3SkyConditionIcon.setBounds(220, 380, 55, 49);
		frame.getContentPane().add(labelDay3SkyConditionIcon);
		// Skycondition
		labelDay3SkyConditionInfo = new JLabel("");
		labelDay3SkyConditionInfo.setForeground(Color.LIGHT_GRAY);
		labelDay3SkyConditionInfo.setFont(font.deriveFont(11f));
		labelDay3SkyConditionInfo.setBounds(220, 435, 58, 15);
		frame.getContentPane().add(labelDay3SkyConditionInfo);
		// Temp
		labelDay3TempInfo = new JLabel("");
		labelDay3TempInfo.setForeground(Color.LIGHT_GRAY);
		labelDay3TempInfo.setFont(font.deriveFont(15f));
		labelDay3TempInfo.setBounds(220, 455, 58, 15);
		frame.getContentPane().add(labelDay3TempInfo);

		//Day4
		labelDay4Info = new JLabel("Thurs.");
		labelDay4Info.setForeground(Color.LIGHT_GRAY);
		labelDay4Info.setFont(font.deriveFont(15f));
		labelDay4Info.setBounds(290, 360, 58, 15);
		frame.getContentPane().add(labelDay4Info);
		// Icon
		labelDay4SkyConditionIcon = new JLabel();
		labelDay4SkyConditionIcon.setBounds(285, 380, 55, 49);
		frame.getContentPane().add(labelDay4SkyConditionIcon);
		// Skycondition
		labelDay4SkyConditionInfo = new JLabel("");
		labelDay4SkyConditionInfo.setForeground(Color.LIGHT_GRAY);
		labelDay4SkyConditionInfo.setFont(font.deriveFont(11f));
		labelDay4SkyConditionInfo.setBounds(285, 435, 58, 15);
		frame.getContentPane().add(labelDay4SkyConditionInfo);
		// Temp
		labelDay4TempInfo = new JLabel("");
		labelDay4TempInfo.setForeground(Color.LIGHT_GRAY);
		labelDay4TempInfo.setFont(font.deriveFont(15f));
		labelDay4TempInfo.setBounds(285, 455, 58, 15);
		frame.getContentPane().add(labelDay4TempInfo);
		
		//Day5
		labelDay5Info = new JLabel("Fri.");
		labelDay5Info.setForeground(Color.LIGHT_GRAY);
		labelDay5Info.setFont(font.deriveFont(15f));
		labelDay5Info.setBounds(365, 360, 58, 15);
		frame.getContentPane().add(labelDay5Info);
		// Icon
		labelDay5SkyConditionIcon = new JLabel();
		labelDay5SkyConditionIcon.setBounds(350, 380, 55, 49);
		frame.getContentPane().add(labelDay5SkyConditionIcon);
		// Skycondition
		labelDay5SkyConditionInfo = new JLabel("");
		labelDay5SkyConditionInfo.setForeground(Color.LIGHT_GRAY);
		labelDay5SkyConditionInfo.setFont(font.deriveFont(11f));
		labelDay5SkyConditionInfo.setBounds(350, 435, 58, 15);
		frame.getContentPane().add(labelDay5SkyConditionInfo);
		// Temp
		labelDay5TempInfo = new JLabel("");
		labelDay5TempInfo.setForeground(Color.LIGHT_GRAY);
		labelDay5TempInfo.setFont(font.deriveFont(15f));
		labelDay5TempInfo.setBounds(350, 455, 58, 15);
		frame.getContentPane().add(labelDay5TempInfo);

		//Day6
		labelDay6Info = new JLabel("Sat.");
		labelDay6Info.setForeground(Color.LIGHT_GRAY);
		labelDay6Info.setFont(font.deriveFont(15f));
		labelDay6Info.setBounds(425, 360, 58, 15);
		frame.getContentPane().add(labelDay6Info);
		// Icon
		labelDay6SkyConditionIcon = new JLabel();
		labelDay6SkyConditionIcon.setBounds(410, 380, 55, 49);
		frame.getContentPane().add(labelDay6SkyConditionIcon);
		// Skycondition
		labelDay6SkyConditionInfo = new JLabel("");
		labelDay6SkyConditionInfo.setForeground(Color.LIGHT_GRAY);
		labelDay6SkyConditionInfo.setFont(font.deriveFont(11f));
		labelDay6SkyConditionInfo.setBounds(410, 435, 58, 15);
		frame.getContentPane().add(labelDay6SkyConditionInfo);
		// Temp
		labelDay6TempInfo = new JLabel("");
		labelDay6TempInfo.setForeground(Color.LIGHT_GRAY);
		labelDay6TempInfo.setFont(font.deriveFont(15f));
		labelDay6TempInfo.setBounds(410, 455, 58, 15);
		frame.getContentPane().add(labelDay6TempInfo);

		//Day7
		labelDay7Info = new JLabel("Sun.");
		labelDay7Info.setForeground(Color.LIGHT_GRAY);
		labelDay7Info.setFont(font.deriveFont(15f));
		labelDay7Info.setBounds(490, 360, 58, 15);
		frame.getContentPane().add(labelDay7Info);
		// Icon
		labelDay7SkyConditionIcon = new JLabel();
		labelDay7SkyConditionIcon.setBounds(475, 380, 55, 49);
		frame.getContentPane().add(labelDay7SkyConditionIcon);
		// Skycondition
		labelDay7SkyConditionInfo = new JLabel("");
		labelDay7SkyConditionInfo.setForeground(Color.LIGHT_GRAY);
		labelDay7SkyConditionInfo.setFont(font.deriveFont(11f));
		labelDay7SkyConditionInfo.setBounds(475, 435, 58, 15);
		frame.getContentPane().add(labelDay7SkyConditionInfo);
		// Temp
		labelDay7TempInfo = new JLabel("");
		labelDay7TempInfo.setForeground(Color.LIGHT_GRAY);
		labelDay7TempInfo.setFont(font.deriveFont(15f));
		labelDay7TempInfo.setBounds(475, 455, 58, 15);
		frame.getContentPane().add(labelDay7TempInfo);

		// / END INITIALIZATION OF LONG-TERM CONDITIONS ///

		// show short term view by default
		toggleShortTerm(true);
	}

	private void createFont() {
		java.io.InputStream fontInputStream = this.getClass()
				.getResourceAsStream("/fonts/HelveticaNeue-Medium.otf");
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, fontInputStream);
		} catch (Exception e) {
			// failsafe, temp workaround -TE
			font = new Font("Helvetica", Font.PLAIN, 20);
			System.out.println("Font loading failed");
			e.printStackTrace();
		}
	}
	// updates the labels current weather view to the new weather conditions
	// in the future, this should probably take a String city parameter to
	// construct the CurrentWeather obj from.
	// should probably show some kind of "updating" message

	public void refresh(String location) {
		try {
			// constructor should take String city parameter in the future.
			System.out.println("Retrieving weather data");
			currentWeather = new CurrentWeather(location);
		
			
			// update time shown
			cal =  Calendar.getInstance();
			lastUpdated = dateFormat.format(cal.getTime());		

			// store tempUnit so we don't have to call prefs.getTempUnit() every time
			// current location panel
			labelLocation.setText(currentWeather.getCity() + ", "
					+ currentWeather.getCountry());
			labelSkyConditionInfo.setText(currentWeather.getSkyCondition());

			labelWindInfo.setText(currentWeather.getWindSpeed() + " km/h "
					+ currentWeather.getWindDirection());
			labelHumidityInfo.setText(currentWeather.getHumidity() + "%");
			labelAirPressureInfo.setText(currentWeather.getPressure() + "kPa");
			//need to substring these so we don't have a million decimal places
			
			labelSunriseInfo.setText(currentWeather.getSunriseTime());
			labelSunsetInfo.setText(currentWeather.getSunsetTime());
			
			labelUpdatedInfo.setText(lastUpdated); //-NK
			
			//NEW HARD CODED LABELS HERE *BEEP BOOP*
			labelPrecipitationInfo.setText("HardCoded");
			
			setSkyConditionImages(currentWeather.getWeatherID());
			labelSkyConditionIcon.setIcon(new ImageIcon(skyConditionIconLarge));
			backgroundLabel.setIcon(new ImageIcon(skyConditionBackground));
			// short/longterm icons will be the same has current weather, can be easily switched later
			//shortterm
			setTemperatureFields();
			
			//these really need to be done using a loop. the exact same thing is done to every single label.
			label12AMSkyConditionIcon.setIcon(new ImageIcon(skyConditionIconSmall));
			label12AMSkyConditionInfo.setText("<html>"+currentWeather.getSkyCondition()+"</html>");
			label12AMPrecipitation.setText("Hard Coded");
			label3AMSkyConditionIcon.setIcon(new ImageIcon(skyConditionIconSmall));
			label3AMSkyConditionInfo.setText("<html>"+currentWeather.getSkyCondition()+"</html>");
			label3AMPrecipitation.setText("Hard Coded");
			label6AMSkyConditionIcon.setIcon(new ImageIcon(skyConditionIconSmall));
			label6AMSkyConditionInfo.setText("<html>"+currentWeather.getSkyCondition()+"</html>");
			label6AMPrecipitation.setText("Hard Coded");
			label9AMSkyConditionIcon.setIcon(new ImageIcon(skyConditionIconSmall));
			label9AMSkyConditionInfo.setText("<html>"+currentWeather.getSkyCondition()+"</html>");
			label9AMPrecipitation.setText("Hard Coded");
			label12PMSkyConditionIcon.setIcon(new ImageIcon(skyConditionIconSmall));
			label12PMSkyConditionInfo.setText("<html>"+currentWeather.getSkyCondition()+"</html>");
			label12PMPrecipitation.setText("Hard Coded");
			label3PMSkyConditionIcon.setIcon(new ImageIcon(skyConditionIconSmall));
			label3PMSkyConditionInfo.setText("<html>"+currentWeather.getSkyCondition()+"</html>");
			label3PMPrecipitation.setText("Hard Coded");
			label6PMSkyConditionIcon.setIcon(new ImageIcon(skyConditionIconSmall));
			label6PMSkyConditionInfo.setText("<html>"+currentWeather.getSkyCondition()+"</html>");
			label6PMPrecipitation.setText("Hard Coded");
			label9PMSkyConditionIcon.setIcon(new ImageIcon(skyConditionIconSmall));
			label9PMSkyConditionInfo.setText("<html>"+currentWeather.getSkyCondition()+"</html>");
			label9PMPrecipitation.setText("Hard Coded");
			
			//longterm
			labelDay1SkyConditionIcon.setIcon(new ImageIcon(skyConditionIconSmall));
			labelDay1SkyConditionInfo.setText("<html>"+currentWeather.getSkyCondition()+"</html>");
			labelDay2SkyConditionIcon.setIcon(new ImageIcon(skyConditionIconSmall));
			labelDay2SkyConditionInfo.setText("<html>"+currentWeather.getSkyCondition()+"</html>");
			labelDay3SkyConditionIcon.setIcon(new ImageIcon(skyConditionIconSmall));
			labelDay3SkyConditionInfo.setText("<html>"+currentWeather.getSkyCondition()+"</html>");
			labelDay4SkyConditionIcon.setIcon(new ImageIcon(skyConditionIconSmall));
			labelDay4SkyConditionInfo.setText("<html>"+currentWeather.getSkyCondition()+"</html>");
			labelDay5SkyConditionIcon.setIcon(new ImageIcon(skyConditionIconSmall));
			labelDay5SkyConditionInfo.setText("<html>"+currentWeather.getSkyCondition()+"</html>");
			labelDay6SkyConditionIcon.setIcon(new ImageIcon(skyConditionIconSmall));
			labelDay6SkyConditionInfo.setText("<html>"+currentWeather.getSkyCondition()+"</html>");
			labelDay7SkyConditionIcon.setIcon(new ImageIcon(skyConditionIconSmall));
			labelDay7SkyConditionInfo.setText("<html>"+currentWeather.getSkyCondition()+"</html>");
			
		} 
		catch (IOException e) {
			System.out.println("Something went wrong retrieving current weather");
		}	
		
	}	

    //moved these to a method because in the future we will have to re-initialize them when c/f is changed.
    private void setTemperatureFields() {
        if(currentWeather != null) {
            char tempUnit = prefs.getTempUnit();
            labelTempInfo.setText(currentWeather.getTemp(tempUnit));
            labelCurrentMMTempInfo.setText(currentWeather.getMinTemp(tempUnit) + "  |  " + currentWeather.getMaxTemp(tempUnit));
            label12AMTempInfo.setText(currentWeather.getTemp(tempUnit));
            label3AMTempInfo.setText(currentWeather.getTemp(tempUnit));
            label6AMTempInfo.setText(currentWeather.getTemp(tempUnit));
            label9AMTempInfo.setText(currentWeather.getTemp(tempUnit));
            label12PMTempInfo.setText(currentWeather.getTemp(tempUnit));
            label3PMTempInfo.setText(currentWeather.getTemp(tempUnit));
            label6PMTempInfo.setText(currentWeather.getTemp(tempUnit));
            label9PMTempInfo.setText(currentWeather.getTemp(tempUnit));
            labelDay1TempInfo.setText(currentWeather.getTemp(tempUnit));
            labelDay2TempInfo.setText(currentWeather.getTemp(tempUnit));
            labelDay3TempInfo.setText(currentWeather.getTemp(tempUnit));
            labelDay4TempInfo.setText(currentWeather.getTemp(tempUnit));
            labelDay5TempInfo.setText(currentWeather.getTemp(tempUnit));
            labelDay6TempInfo.setText(currentWeather.getTemp(tempUnit));
            labelDay7TempInfo.setText(currentWeather.getTemp(tempUnit));
        }
}

	// This listener is shared by the barSearch TextField and the AddLocation
	// Button.
	class AddLocation implements ActionListener, DocumentListener {
		private boolean alreadyEnabled = false;
		private JButton button;
		private CurrentWeather test;

		public AddLocation(JButton button) {
			this.button = button;
		}

		// Required by ActionListener.
		@Override
		public void actionPerformed(ActionEvent e) {
			String name = barSearch.getText();
			
			try{
				
				test = new CurrentWeather(name);
				
				//User didn't enter a valid location...
				if (test == null || !(name.contains(test.getCity()))){
					barSearch.setText("Please enter a valid location.");

				}
					
				
				// User didn't type in a unique name...
				if (name.equals("") || alreadyInList(name)) {
					Toolkit.getDefaultToolkit().beep();
					barSearch.requestFocusInWindow();
					barSearch.selectAll();
					return;
				}

				int index = listLocations.getSelectedIndex(); // get selected index
				if (index == -1) { // no selection, so insert at beginning
					index = 0;
				} 
				else { // add after the selected item
					index++;
				}
				
				listModel.insertElementAt(barSearch.getText(), index);

				// If we just wanted to add to the end, we'd do this:
				// listModel.addElement(employeeName.getText());
				// Add element to user preferences as well - NK
				try {
					prefs.addLocation(index, barSearch.getText());	//adds to "index" position of the MyLocations list
				}
				catch(WeatherException exception) {
					System.out.println(exception.getMessage());
				}
				//prefs.printLocations(); // This is just to test addLocation on user preferences

				// Reset the text field.
				barSearch.requestFocusInWindow();
				barSearch.setText("");

				// Select the new item and make it visible.
				//listLocations.setSelectedIndex(index);
				listLocations.ensureIndexIsVisible(index);
				
			}
			catch (IOException err){
				System.out.println("An invalid location was entered.");
				return;
			}
		}
		// This method tests for string equality. You could certainly
		// get more sophisticated about the algorithm. For example,
		// you might want to ignore white space and capitalization.
		protected boolean alreadyInList(String name) {
			return listModel.contains(name);
		}
		// Required by DocumentListener.
		@Override
		public void insertUpdate(DocumentEvent e) {
			enableButton();
		}
		// Required by DocumentListener.
		@Override
		public void removeUpdate(DocumentEvent e) {
			handleEmptyTextField(e);
		}
		// Required by DocumentListener.
		@Override
		public void changedUpdate(DocumentEvent e) {
			if (!handleEmptyTextField(e)) {
				enableButton();
			}
		}
		private void enableButton() {
			if (!alreadyEnabled) {
				button.setEnabled(true);
			}
		}
		private boolean handleEmptyTextField(DocumentEvent e) {
			if (e.getDocument().getLength() <= 0) {
				button.setEnabled(false);
				alreadyEnabled = false;
				return true;
			}
			return false;
		}
	}

    /**
     * toggles whether the short/long term display is shown
     * i still don't like this, but it's half as bad as before.
     * @param b whether to show or hide short term
   */
    public void toggleShortTerm(boolean b) {
        if (b) {
            buttonLongTerm.setForeground(Color.GRAY);
            buttonShortTerm.setForeground(Color.WHITE);
        }
        else {
            buttonLongTerm.setForeground(Color.WHITE);
            buttonShortTerm.setForeground(Color.GRAY);
        }
        labelDay1Info.setVisible(!b);
        labelDay1SkyConditionIcon.setVisible(!b);
        labelDay1TempInfo.setVisible(!b);
        labelDay1SkyConditionInfo.setVisible(!b);
        labelDay2Info.setVisible(!b);
        labelDay2SkyConditionIcon.setVisible(!b);
        labelDay2TempInfo.setVisible(!b);
        labelDay2SkyConditionInfo.setVisible(!b);
        labelDay3Info.setVisible(!b);
        labelDay3SkyConditionIcon.setVisible(!b);
        labelDay3TempInfo.setVisible(!b);
        labelDay3SkyConditionInfo.setVisible(!b);
        labelDay4Info.setVisible(!b);
        labelDay4SkyConditionIcon.setVisible(!b);
        labelDay4TempInfo.setVisible(!b);
        labelDay4SkyConditionInfo.setVisible(!b);
        labelDay5Info.setVisible(!b);
        labelDay5SkyConditionIcon.setVisible(!b);
        labelDay5TempInfo.setVisible(!b);
        labelDay5SkyConditionInfo.setVisible(!b);
        labelDay6Info.setVisible(!b);
        labelDay6SkyConditionIcon.setVisible(!b);
        labelDay6TempInfo.setVisible(!b);
        labelDay6SkyConditionInfo.setVisible(!b);
        labelDay7Info.setVisible(!b);
        labelDay7SkyConditionIcon.setVisible(!b);
        labelDay7TempInfo.setVisible(!b);
        labelDay7SkyConditionInfo.setVisible(!b);
        label12AM.setVisible(b);
        label12AMSkyConditionIcon.setVisible(b);
        label12AMTempInfo.setVisible(b);
        label12AMSkyConditionInfo.setVisible(b);
        label12AMPrecipitation.setVisible(b);
        label3AM.setVisible(b);
        label3AMSkyConditionIcon.setVisible(b);
        label3AMTempInfo.setVisible(b);
        label3AMSkyConditionInfo.setVisible(b);
        label3AMPrecipitation.setVisible(b);
        label6AM.setVisible(b);
        label6AMSkyConditionIcon.setVisible(b);
        label6AMTempInfo.setVisible(b);
        label6AMSkyConditionInfo.setVisible(b);
        label6AMPrecipitation.setVisible(b);
        label9AM.setVisible(b);
        label9AMSkyConditionIcon.setVisible(b);
        label9AMTempInfo.setVisible(b);
        label9AMSkyConditionInfo.setVisible(b);
        label9AMPrecipitation.setVisible(b);
        label12PM.setVisible(b);
        label12PMSkyConditionIcon.setVisible(b);
        label12PMTempInfo.setVisible(b);
        label12PMSkyConditionInfo.setVisible(b);
        label12PMPrecipitation.setVisible(b);
        label3PM.setVisible(b);
        label3PMSkyConditionIcon.setVisible(b);
        label3PMTempInfo.setVisible(b);
        label3PMSkyConditionInfo.setVisible(b);
        label3PMPrecipitation.setVisible(b);
        label6PM.setVisible(b);
        label6PMSkyConditionIcon.setVisible(b);
        label6PMTempInfo.setVisible(b);
        label6PMSkyConditionInfo.setVisible(b);
        label6PMPrecipitation.setVisible(b);
        label9PM.setVisible(b);
        label9PMSkyConditionIcon.setVisible(b);
        label9PMTempInfo.setVisible(b);
        label9PMSkyConditionInfo.setVisible(b);
        label9PMPrecipitation.setVisible(b);
    }

	public void setSkyConditionImages(int ID) {
        String icon, background;

		switch (ID) {
            // THUNDERSTORM
            // Thunderstorm with Light Rain
            case 200:
            // Thunderstorm with Rain
            case 201:
            // Thunderstorm with Heavy Rain
            case 202:
            // Light Thunderstorm
            case 210:
            // Thunderstorm
            case 211:
            // Heavy Thunderstorm
            case 212:
            // Ragged Thunderstorm
            case 221:
            // Thunderstorm with Light Drizzle
            case 230:
            // Thunderstorm with Drizzle
            case 231:
            // Thunderstorm with Heavy Drizzle
            case 232:
                icon = "thunder";
                background = "thunder";
                break;
            // DRIZZLE
            // Light Intensity Drizzle
            case 300:
            // Drizzle
            case 301:
            // Heavy Intensity Drizzle
            case 302:
            // Light Intensity Drizzle Rain
            case 310:
            // Drizzle Rain
            case 311:
            // Heavy Intensity Drizzle Rain
            case 312:
            // Shower Rain and Drizzle
            case 313:
            // Heavy Shower Rain and Drizzle
            case 314:
            // Shower Drizzle
            case 321:
                icon = "drizzle";
                background = "rain";
                break;
            // RAIN
            // Light Rain
            case 500:
                // Moderate Rain
            case 501:
                // Heavy Intensity Rain
            case 502:
                // Very Heavy Rain
            case 503:
                // Extreme Rain
            case 504:
                // Shower Rain
            case 521:
                // Heavy Intensity Shower Rain
            case 522:
                // Ragged Shower Rain
            case 531:
                icon = "heavy_rain";
                background = "rain";
                break;
            // Freezing Rain
            case 511:
                icon = "sleet";
                background = "rain";
                break;
            // Light Intensity Shower Rain
            case 520:
                icon = "light_rain";
                background = "rain";
                break;
            // SNOW
            // Light Snow
            case 600:
                // Snow
            case 601:
                icon = "light_snow";
                background = "snow";
                break;
            // Heavy Snow
            case 602:
                // Hurricane
            case 902:
                // Hail
            case 906:
                icon = "heavy_snow";
                background = "snow";
                break;
            // Sleet
            case 611:
                // Shower Sleet
            case 612:
                // Light Rain and Snow
            case 615:
                // Rain and Snow
            case 616:
                icon = "sleet";
                background = "rain";
                break;
            // Light Shower Snow
            case 620:
                // Shower Snow
            case 621:
                // Heavy Shower Snow
            case 622:
                icon = "sleet";
                background = "snow";
                break;
            // ATMOSPHERE
            // Mist
            case 701:
                // Fog
            case 721:
                //Haze
            case 741:
                icon = "mist";
                background = "fog";
                break;
            // Smoke
            case 711:
                // Volcanic Ash
            case 762:
                icon = "mist";
                background = "volcano";
                break;
            // Sand/Dust Whirls
            case 731:
                // Sand
            case 751:
                // Dust
            case 761:
                icon = "mist";
                background = "sand";
                break;
            // Squalls
            case 771:
                icon = "tornado";
                background = "snow";
                break;
            // Tornado
            case 781:
            case 900:
                icon = "tornado";
                background = "tornado";
                break;
            // CLOUDS
            // Sky is clear
            case 800:
                icon = "sun";
                background = "sun";
                break;
            // Calm
            case 951:
                icon = "sun";
                background = "partial_clouds";
                break;
            // Few Clouds
            case 801:
                // Scattered Clouds
            case 802:
                icon = "light_clouds";
                background = "partial_clouds";
                break;
            // Broken Clouds
            case 803:
                // Overcast Clouds
            case 804:
                icon = "heavy_clouds";
                background = "clouds";
                break;
            // EXTREME
            // Tropical Storm
            case 901:
                icon = "tornado";
                background = "rain";
                break;
            // Cold
            case 903:
                icon = "wind";
                background = "snow";
                break;
            // Hot
            case 904:
            case 950:
                icon = "sun";
                background = "sun";
                break;
            // Windy
            case 905:
                // Severe Gale
            case 959:
                // ADDITIONAL
                // Setting
                // Light Breeze
            case 952:
                // Gentle Breeze
            case 953:
                // Moderate breeze
            case 954:
                // Fresh Breeze
            case 955:
                // Strong Breeze
            case 956:
                // High Wind, near Gale
            case 957:
                // Gale
            case 958:
                // Storm
            case 960:
                icon = "wind";
                background = "wind";
                break;
            // Violent Storm
            case 961:
                icon = "wind";
                background = "tornado";
                break;
            // Hurricane
            case 962:
                icon = "tornado";
                background = "hurricane";
                break;
            //failsafe, but shouldn't happen
            default:
                icon = "sun";
                background = "sun";
        }
        skyConditionIconLarge = "src/main/resources/icons/large/" + icon + ".png";
        skyConditionIconSmall = "src/main/resources/icons/small/" + icon + ".png";
        skyConditionBackground = "src/main/resources/backgrounds/" + background + ".jpg";
	}
}
