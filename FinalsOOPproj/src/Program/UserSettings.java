package Program;

import java.awt.Image;

import javax.swing.ImageIcon;

// This class is responsible for managing the user settings.

public class UserSettings extends MainGUI {

	private static final long serialVersionUID = 3705913131416158542L;
	
	private static String username = "";
	private static String profilePic = "../FinalsOOPproj/Exercises/th.jpg";
	private static int startHour = 0;
	private static int startMinute = 0;
	private static int enduranceRate = 0;
	private static int strengthRate = 0;
	private static int balanceRate = 0;
	private static int flexibilityRate = 0;
	private static Boolean notify = false;
	private static Boolean randomizeAct = false;
	private static Boolean hidePastAct = false;
	private static Boolean incrementAct = false;
	private static int cycleCountIncrmt = 0;
	private static int numberOfTimesRunned = 0;
	
	//get methods
	public static String getUsername() {
		return username;
	}
	
	public static String getProfilePic() {
		return profilePic;
	}
	
	public static int getStartHour() {
		return startHour;
	}
	
	public static int getStartMinute() {
		return startMinute;
	}
	
	public static int getEnduranceRate() {
		return enduranceRate;
	}
	
	public static int getStrengthRate() {
		return strengthRate;
	}
	
	public static int getBalanceRate() {
		return balanceRate;
	}
	
	public static int getFlexibilityRate() {
		return flexibilityRate;
	}
	
	public static Boolean getNotify() {
		return notify;
	}
	
	public static Boolean getRandomizeAct() {
		return randomizeAct;
	}
	
	public static Boolean getHidePastAct() {
		return hidePastAct;
	}
	
	public static Boolean getIncrementAct() {
		return incrementAct;
	}
	
	public static int getCycleCountIncrmt() {
		return cycleCountIncrmt;
	}
	
	public static int getNumberOfTimesRunned() {
		return numberOfTimesRunned;
	}
	
	public static void setEnduranceRate(int rate) {
		enduranceRate = rate;
	}

	public static void setStrengthRate(int rate) {
		strengthRate = rate;
	}

	public static void setBalanceRate(int rate) {
		balanceRate = rate;
	}
	
	public static void setFlexibilityRate(int rate) {
		flexibilityRate = rate;
	}

	public static void setNumberOfTimesRunned(int times) {
		numberOfTimesRunned = times;
	}
	
	//get settings from UI
	public static void getSettingsFromUI() {
    username = username_input.getText();
    profilePic = profile_picture;
    startHour = (int)(txtStartHour.getValue());
    startMinute = (int)(txtStartMinute.getValue());
    enduranceRate = (int)(endurance_slider.getValue());
    strengthRate = (int)(strength_slider.getValue());
    balanceRate = (int)(balance_slider.getValue());
    flexibilityRate = (int)(flexibility_slider.getValue());
    notify = chckbxNotify.isSelected();
    randomizeAct = chckbxRandomizeActivities.isSelected();
    hidePastAct = chckbxHidePastActivities.isSelected();
    incrementAct = chckbxHidePastActivities.isSelected();
    cycleCountIncrmt = (int)cycleCountIncrement_spinner.getValue();
	}
	//save settings to file
	public static void saveSettingsToFile() {
		FileHandler fileHandler = new FileHandler();
		String path = "Exercises/usersettings.txt";
		String content = username + "\n" + profilePic + "\n" + startHour +
				"\n" + startMinute + "\n" + enduranceRate + "\n" + strengthRate +
				"\n" + balanceRate + "\n" + flexibilityRate + "\n" + notify + "\n" +
				randomizeAct + "\n" + hidePastAct + "\n" + incrementAct + "\n" + cycleCountIncrmt +
				"\n" + numberOfTimesRunned;
		fileHandler.writeFile(path, content);
	}
	//load settings from file to UI
	public static void loadSettingsFromFileToUi() {
		loadSettingsFromFile();
        username_input.setText(username);
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(profilePic).getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT));
        picture_profile.setIcon(imageIcon);
        txtStartHour.setValue(startHour);
        txtStartMinute.setValue(startMinute);
        endurance_slider.setValue(enduranceRate);
        strength_slider.setValue(strengthRate);
        balance_slider.setValue(balanceRate);
        flexibility_slider.setValue(flexibilityRate);
        chckbxNotify.setSelected(notify);
        chckbxRandomizeActivities.setSelected(randomizeAct);
        chckbxHidePastActivities.setSelected(hidePastAct);
        chckbxIncrementActivities.setSelected(incrementAct);
        cycleCountIncrement_spinner.setValue(cycleCountIncrmt);
        Exercisio.numberOfTimesRunned = numberOfTimesRunned;
	}
	//load settings from file
	public static void loadSettingsFromFile() {
		FileHandler fileHandler = new FileHandler();
        String path = "Exercises/usersettings.txt";
        String content = fileHandler.readFile(path);
        String[] settings = content.split("\n");
        
        username = settings[0];
        profilePic = settings[1];
        startHour = Integer.parseInt(settings[2]);
        startMinute = Integer.parseInt(settings[3]);
        enduranceRate = Integer.parseInt(settings[4]);
        strengthRate = Integer.parseInt(settings[5]);
        balanceRate = Integer.parseInt(settings[6]);
        flexibilityRate = Integer.parseInt(settings[7]);
        notify = Boolean.parseBoolean(settings[8]);
        randomizeAct = Boolean.parseBoolean(settings[9]);
        hidePastAct = Boolean.parseBoolean(settings[10]);
        incrementAct = Boolean.parseBoolean(settings[11]);
        cycleCountIncrmt = Integer.parseInt(settings[12]);
        numberOfTimesRunned = Integer.parseInt(settings[13]);
	}
}
