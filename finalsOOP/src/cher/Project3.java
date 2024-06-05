package cher;

//Project by Cherrie Mae A. Dimaala, BSCPE II-GE

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Project3 extends JFrame {
 private JTextField nameField, ageField, severityField, healthField;
 private JComboBox<String> disasterCombo, provinceCombo, cityCombo, barangayCombo;
 private JCheckBox suppliesCheckBox, shelterCheckBox;
 private Map<String, String[]> citiesInProvince;
 private Map<String, String[]> barangaysInCity;

 public Project3() {
     setTitle("CALABARZON Peri-Disaster Assessment - Input Form");
     setSize(1000, 600);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setLayout(new BorderLayout());

     // Set the application icon
     setIconImage(new ImageIcon("C:\\Users\\CHEWIIE\\OneDrive\\Pictures\\ndrrmc.png").getImage());
     
     // Add image as header
     ImageIcon headerImageIcon = resizeImageIcon("C:\\Users\\CHEWIIE\\OneDrive\\Pictures\\post-disaster.png", 1000, 200);
     JLabel headerLabel = new JLabel(headerImageIcon);
     add(headerLabel, BorderLayout.NORTH);

     // Panel for the form
     JPanel formPanel = new JPanel(new GridLayout(12, 2, 5, 5));

     
     Font labelFont = new Font(Font.SANS_SERIF, Font.BOLD, 13); // Font for labels
     
     // Components of the Form Window
     JLabel nameLabel = new JLabel("Enter your name: ");
     nameLabel.setFont(labelFont);
     nameField = new JTextField();
     JLabel ageLabel = new JLabel("Enter your age: ");
     ageLabel.setFont(labelFont);
     ageField = new JTextField();
     JLabel disasterLabel = new JLabel("Choose the type of disaster: ");
     disasterLabel.setFont(labelFont);
     disasterCombo = new JComboBox<>(new String[]{"Earthquake", "Flood", "Typhoon", "Wildfire", "Landslides", "Tornado", "Volcanoes"});
     JLabel severityLabel = new JLabel("Enter the severity level of the disaster (1-10): ");
     severityLabel.setFont(labelFont);
     severityField = new JTextField();
     JLabel healthLabel = new JLabel("Enter your health condition (good/poor): ");
     healthLabel.setFont(labelFont);
     healthField = new JTextField();
     JLabel suppliesLabel = new JLabel("Do you have emergency supplies? (Check if Yes)");
     suppliesLabel.setFont(labelFont);
     suppliesCheckBox = new JCheckBox("Yes, I do.");

     JLabel shelterLabel = new JLabel("Is there a suitable shelter available? (Check if Yes)");
     shelterLabel.setFont(labelFont);
     shelterCheckBox = new JCheckBox("Yes, there is.");
     JLabel provinceLabel = new JLabel("Select your province: ");
     shelterLabel.setFont(labelFont);
     provinceCombo = new JComboBox<>(new String[]{"Batangas", "Cavite", "Laguna", "Quezon", "Rizal" });
     JLabel cityLabel = new JLabel("Select your City/Municipality: ");
     cityLabel.setFont(labelFont);
     cityCombo = new JComboBox<>();
     JLabel barangayLabel = new JLabel("Select your Barangay: ");
     barangayLabel.setFont(labelFont);
     barangayCombo = new JComboBox<>();
     
     // Initialize Maps for cities and barangays
     initializeCitiesInProvince();
     initializeBarangaysInCity();

     provinceCombo.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             String selectedProvince = (String) provinceCombo.getSelectedItem();
             populateCities(selectedProvince);
         }
     });

     cityCombo.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             String selectedCity = (String) cityCombo.getSelectedItem();
             populateBarangays(selectedCity);
         }
     });

     formPanel.add(nameLabel);
     formPanel.add(nameField);
     formPanel.add(ageLabel);
     formPanel.add(ageField);
     formPanel.add(disasterLabel);
     formPanel.add(disasterCombo);
     formPanel.add(severityLabel);
     formPanel.add(severityField);
     formPanel.add(healthLabel);
     formPanel.add(healthField);
     formPanel.add(suppliesLabel);
     formPanel.add(suppliesCheckBox);
     formPanel.add(shelterLabel);
     formPanel.add(shelterCheckBox);
     formPanel.add(provinceLabel);
     formPanel.add(provinceCombo);
     formPanel.add(cityLabel);
     formPanel.add(cityCombo);
     formPanel.add(barangayLabel);
     formPanel.add(barangayCombo);

     // Wrapper panel with margin
     JPanel formWrapperPanel = new JPanel(new BorderLayout());
     formWrapperPanel.setBorder(new EmptyBorder(10, 100, 10, 30));
     formWrapperPanel.add(formPanel, BorderLayout.CENTER);

     add(formWrapperPanel, BorderLayout.CENTER);

     // Add Submit Button
     JButton submitButton = new JButton("Submit");
     submitButton.addActionListener(new SubmitButtonListener());
     add(submitButton, BorderLayout.SOUTH);

     setLocationRelativeTo(null);
 }
 
	    private ImageIcon resizeImageIcon(String imagePath, int width, int height) {
	        try {
	            BufferedImage image = ImageIO.read(new File(imagePath));
	            Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	            return new ImageIcon(resizedImage);
	        } catch (IOException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

 private void initializeCitiesInProvince() {
     citiesInProvince = new HashMap<>();
     citiesInProvince.put("Batangas", new String[]{"Agoncillo", "Alitagtag", "Balayan", "Balete", "Batangas City (Capital)", "Bauan", "Calaca", "Calatagan", "Cuenca", "Ibaan", ""   		
     		+ "Laurel", "Lemery", "Lian", "Lipa City", "Lobo", "Mabini", "Malvar", "Mataasnakahoy", "Nasugbu", "Padre Garcia", "Rosario", "San Jose", ""
     		+ "San Juan", "San Luis", "San Nicolas", "San Pascua", "Santa Teresita" ,"Taal", "Talisay", "Tanauan", "Taysan", "Tingloy", "Tuy" });
     citiesInProvince.put("Cavite", new String[]{"Alfonso", "Amadeo", "Bacoor", "Carmona", "Cavite City", "Dasmariñas", "General Emilio Aguinaldo", ""
     		+ "General Mariano Alvarez", "General Trias", "Imus", "Indang", "Kawit", "Magallanes", "Maragondon", "Mendez (Mendez-Nuñez)", "Naic", "Noveleta", ""
     		+ "Rosario", "Silang", "Tagaytay", "Tanza", "Ternate", "Trece Martires"});
     citiesInProvince.put("Laguna", new String[]{"Alaminos","Bay", "Biñan", "Cabuyao", "Calamba", "Calauan", "Cavinti", "Famy", "Kalayaan",""
     		+ "Liliw", "Los Baños", "Luisiana", "Lumban", "Mabitac", "Magdalena", "Majayjay", "Nagcarlan", "Paete", "Pagsanjan", "Pakil",  ""
     		+ "Pangil", "Pila", "Rizal", "San Pablo City", "San Pedro", "Santa Cruz (Capital)", "Santa Maria", "Santa Rosa", "Siniloan", "Victoria"});
     citiesInProvince.put("Quezon", new String[]{"Agdangan", "Alabat", "Atimonan", "Buenavista", "Burdeos", "Calauag", "Candelaria", "Catanauan", "Dolores", "General Luna"
 			+ "General Nakar", "Guinayangan", "Gumaca", "Infanta", "Jomalig", "Lopez", "Lucban", "Lucena City (Capital)", "Macalelon", "Mauban", "Mulanay", "Padre Burgos", ""
 			+ "Pagbilao", "Panukulan", "Patnanungan", "Perez", "Pitogo", "Plaridel", "Polillo", "Quezon", "Real", "Sampaloc", "San Andres", "San Antonio", ""
 			+ "San Francisco", "San Narciso", "Sariaya", "Tagkawayan", "Tayabas", "Tiaong", "Unisan"});
     citiesInProvince.put("Rizal", new String[]{"Angono", "Antipolo", "Baras", "Binangonan", "Cainta", "Cardona", "Jalajala", "Morong", "Pililla", ""
     		+ "Rodriguez (Montalban)", "San Mateo", "Tanay", "Taytay", "Teresa"});
 }

 private void initializeBarangaysInCity() {
 	barangaysInCity = new HashMap<>();
 	barangaysInCity.put("Agoncillo", new String[] {"Adia", "Bagong Sikat", "Balangon", "Bangin", "Banyaga", "Barigon", "Bilibinwang", ""
 			+ "Coral na Munti", "Guitna", "Mabini", "Pamiga", "Panhulan", "Pansipit", "Poblacion", "Pook", "San Jacinto", "San Teodoro", ""
 			+ "Santa Cruz", "Santo Tomas", "Subic Ibaba", "Subic Ilaya" });
 	barangaysInCity.put("Alitagtag", new String[] {"Balagbag", "Concepcion", "Concordia", "Dalipit East", "Dalipit West", "Dominador East", "Dominador West", ""
 			+ "Munlawin Norte", "Munlawin Sur", "Muzon Primero", "Muzon Segundo", "Pinagkurusan", "Pinag-as", "Poblacion East", "Poblacion West", "San Jose", "San Juan", ""
 			+ "Santa Cruz", "Tadlac" });
 	barangaysInCity.put("Balayan", new String[] {"Baclaran", "Brgy. 1 (Pob.)", "Brgy. 10 (Pob.)", "Brgy. 11 (Pob.)", "Brgy. 12 (Pob.)", ""
 			+ "Brgy. 2 (Pob.)", "Brgy. 3 (Pob.)", "Brgy. 4 (Pob.)", "Brgy. 5 (Pob.)", "Brgy. 6 (Pob.)","Brgy. 7 (Pob.)","Brgy. 8 (Pob.)", ""
 			+ "Brgy. 9 (Pob.)", "Calan", "Caloocan", "Calzada", "Canda", "Carenahan", "Caybunga", "Cayponce", "Dalig", "Dao", "Dilao", ""
 			+ "Duhatan", "Durangao", "Gimalas", "Gumamela", "Lagnas", "Lanatan", "Langgangan", "Lucban Pook", "Lucban Putol", "Magabe", ""
 			+ "Malalay", "Munting Tubig", "Navotas", "Palikpikan", "Patogo", "Pooc", "Sambat", "Sampaga", "San Juan", "San Piro", "Santol", ""
 			+ "Sukol", "Tactac", "Taludtud", "Tanggoy", });
 	barangaysInCity.put("Balete", new String[] {"Alangilan", "Calawit", "Looc", "Magapi", "Makina", "Malabanan", "Paligawan", "Palsara", ""
 			+ "Poblacion", "Sala", "Sampalocan", "San Sebastian", "Solis"});
 	barangaysInCity.put("Batangas City (Capital)", new String[] {"Alangilan", "Balagtas", "Balete", "Banaba Center", "Banaba Ibaba", "Banaba Kanluran", ""
 			+ "Banaba Silangan","Brgy. 1 (Pob.)", "Brgy. 10 (Pob.)", "Brgy. 11 (Pob.)", "Brgy. 12 (Pob.)", "Brgy. 13 (Pob.)", "Brgy. 14 (Pob.)", ""
 			+ "Brgy. 15 (Pob.)", "Brgy. 16 (Pob.)", "Brgy. 17 (Pob.)", "Brgy. 18 (Pob.)", "Brgy. 19 (Pob.)", "Brgy. 2 (Pob.)", "Brgy. 20 (Pob.)", ""
 			+ "Brgy. 21 (Pob.)", "Brgy. 22 (Pob.)", "Brgy. 23 (Pob.)", "Brgy. 24 (Pob.)", "Brgy. 3 (Pob.)", "Brgy. 4 (Pob.)", "Brgy. 5 (Pob.)", ""
 			+ "Brgy. 6 (Pob.)","Brgy. 7 (Pob.)","Brgy. 8 (Pob.)", "Brgy. 9 (Pob.)", "Bilogo", "Bolbok", "Bukal", "Calicanto", "Catandala", ""
 			+ "Concepcion", "Conde Itaas", "Conde Labak", "Cuta", "Dalig", "Dela Paz", "Dela Paz Pulot Aplaya", "Dela Paz Pulot Itaas", ""
 			+ "Domoclay", "Dumantay", "Gulod Itaas", "Gulod Labak", "Haligue Kanluran", "Haligue Silangan", "Ilihan", "Kumba", ""
 			+ "Kumintang Ibaba", "Kumintang Ilaya", "Libjo", "Liponpon, Isla Verde", "Maapas", "Mabacong (Matoco)", "Mahabang Dahilig", ""
 			+ "Mahabang Parang", "Mahacot Kanluran", "Mahacot Silangan", "Malalim", "Malibayo", "Malitam", "Maruclap", "Pagkilatan", ""
 			+ "Paharang Kanluran", "Paharang Silangan", "Pallocan Kanluran", "Pallocan Silangan", "Pinamucan", "Pinamucan Ibaba", ""
 			+ "Pinamucan Silangan", "Sampaga", "San Agapito, Isla Verde", "San Agustin Kanluran, Isla Verde", "San Agustin Silangan, Isla Verde", ""
 			+ "San Andres, Isla Verde", "San Antonio, Isla Verde", "San Isidro", "San Jose Sico", "San Miguel", "San Pedro", "Santa Clara", ""
 			+ "Santa Rita Aplaya", "Santo Domingo", "Santo Niño", "Simlong", "Sirang Lupa", "Sorosoro Ibaba", "Sorosoro Ilaya", ""
 			+ "Sorosoro Karsada", "Tabangao Ambulong", "Tabangao Aplaya (Tabango Proper)", "Tabangao Dao", "Talahib Pandayan", ""
 			+  "Talahib Payapa", "Talumpok Kanluran", "Talumpok Silangan", "Tinga Itaas", "Tinga Labak", "Tulo", "Wawa",""});
 	barangaysInCity.put("Bauan", new String[] {"Alagao", "Aplaya", "As-is", "Bagong Silang", "Baguilawa", "Balayong", "Brgy. I (Pob.)", "Brgy. II (Pob.)", ""
 			+ "Brgy. III (Pob.)", "Brgy. IV (Pob.)", "Bolo", "Colvo", "Cupang", "Durungao", "Gulibay", "Inicbulan", "Locloc", "Magalang-galang", "Malindig", ""
 			+ "Manalupong", "Manghinao Proper", "Manghinao Uno", "New Danglayan", "Orense", "Pitugo", "Rizal", "Sampaguita", "San Agustin", "San Andres Proper", ""
 			+ "San Andres Uno", "San Diego", "San Miguel", "San Pablo", "San Pedro", "San Roque", "San Teodoro", "San Vicente", "Santa Maria", "Santo Domingo", "Sinala"});
 	barangaysInCity.put("Calaca", new String[] {"Baclas", "Bagong Tubig", "Balimbing", "Bambang", ""
 			+ "Brgy. 1 (Pob.)", "Brgy. 2 (Pob.)", "Brgy. 3 (Pob.)", "Brgy. 4 (Pob.)", "Brgy. 5 (Pob.)", "Brgy. 6 (Pob.)",""
 			+ "Bisaya", "Cahil", "Calantas", "Caluangan", "Camastilisan", "Coral ni Bacal", "Coral ni Lopes (Sugod)", "Dacanlao", "Dila", "Loma", "Lumbang Calzada", ""
 			+ "Lumbang na Bata", "Lumbang na Matanda", "Madalunot", "Makina", "Matipok", "Munting Coral", "Niyugan", "Pantay", "Puting Bato East", "Puting Bato West", ""
 			+ "Puting Kahoy", "Quisumbing", "Salong", "San Rafael", "Sinisian", "Taklang Anak", "Talisay", "Tamayo", "Timbain" });
 	barangaysInCity.put("Calatagan", new String[] {"Bagong Silang", "Baha", "Balibago", "Balitoc", "Biga", "Bucal", "Carlosa", "Carretunan", "Encarnacion", "Gulod", ""
 			+ "Hukay", "Lucsuhin", "Luya", "Paraiso", "Brgy. 1 (Pob.)", "Brgy. 2 (Pob.)", "Brgy. 3 (Pob.)", "Brgy. 4 (Pob.)", ""
 			+ "Quilitisan", "Real", "Sambungan", "Sta. Ana", "Talibayog", "Talisay", "Tanagan"});
 	barangaysInCity.put("Cuenca", new String[] {"Balagbag", "Bungahan", "Calumayin", "Dalipit East", "Dalipit West", "Dita", "Don Juan", "Emmanuel", "Ibabao", "Labac", ""
 			+ "Pinagkaisahan", "San Felipe", "San Isidro", "Brgy. 1 (Pob.)", "Brgy. 2 (Pob.)", "Brgy. 3 (Pob.)", "Brgy. 4 (Pob.)", "Brgy. 5 (Pob.)", "Brgy. 6 (Pob.)", ""
 			+  "Brgy. 7 (Pob.)", "Brgy. 8 (Pob.)"});
 	barangaysInCity.put("Ibaan", new String[] {"Bagong Pook", "Balanga", "Brgy. 1 (Pob.)", "Brgy. 2 (Pob.)", "Brgy. 3 (Pob.)", "Brgy. 4 (Pob.)", "Brgy. 5 (Pob.)", "Brgy. 6 (Pob.)", ""
 			+  "Brgy. 7 (Pob.)", "Brgy. 8 (Pob.)", "Brgy. 9 (Pob.)", "Brgy. 10 (Pob.)", "Brgy. 11 (Pob.)", "Brgy. 12 (Pob.)", "Brgy. 13 (Pob.)", "Brgy. 14 (Pob.)", "Brgy. 15 (Pob.)", ""
 			+  "Brgy. 16 (Pob.)", "Bilucao", "Calamias", "Labac", "Lucsuhin", "Malainin", "Malainin East", "Poblacion", "San Agustin"});
 	barangaysInCity.put("Laurel", new String[] {"As-Is", "Balakilong","Brgy. 1 (Pob.)", "Brgy. 2 (Pob.)", "Brgy. 3 (Pob.)", "Brgy. 4 (Pob.)","Brgy. 5 (Pob.)", "Berinayan", ""
 			+ "Bugaan East", "Bugaan West", "Buso-buso", "Dayap Itaas", "Gulod", "J. Leviste", "Molinete", "Niyugan", "Paliparan", ""
 			+ "San Gabriel", "San Gregorio", "Santa Maria", "Ticub"  });
 	barangaysInCity.put("Lemery", new String[] {"Anak-Dagat", "Arumahan", "Ayao-iyao", "Bagong Pook", "Bagong Sikat", "Balanga", "Bukal", "Cahilan I", "Cahilan II", ""
 			+ "Dayapan", "District I (Pob.)", "District II (Pob.)", "District III (Pob.)", "District IV (Pob.)", "Dita", "Gulod", "Lucky", "Maguihan", "Mahabang Dahilig", ""
 			+ "Mahayahay", "Maigsing Dahilig", "Maligaya", "Malinis", "Masalisi", "Mataas Na Bayan", "Matingain I", "Matingain II", "Mayasang", "Niugan", "Nonong Casto", ""
 			+ "Palanas", "Payapa Ibaba", "Payapa Ilaya", "Rizal", "Rizal", "Sambal Ilaya", "San Isidro Ibaba", "San Isidro Itaas", "Sangalang", "Talaga", "Tubigan", ""
 			+ "Tubuan", "Wawa Ibaba", "Wawa Ilaya", "Sinisian East", "Sinisian West" });
 	barangaysInCity.put("Lian", new String[] {"Bagong Pook", "Balibago", "Brgy. 1 (Pob.)", "Brgy. 2 (Pob.)", "Brgy. 3 (Pob.)", "Brgy. 4 (Pob.)","Brgy. 5 (Pob.)", ""
 			+ "Binubusan", "Bungahan", "Cumba", "Humayingan", "Kapito", "Lumaniag", "Luyahan", "Malaruhatan", "Matabungkay", "Prenza", "Puting-Kahoy", "San Diego"});
 	barangaysInCity.put("Lipa City", new String[] {"Adya", "Anilao", "Anilao-Labac", "Antipolo Del Norte", "Antipolo Del Sur", "Bagong Pook", "Balintawak", "Banaybanay", ""
 			+ "Brgy. 1 (Pob.)", "Brgy. 10 (Pob.)", "Brgy. 11 (Pob.)", "Brgy. 2 (Pob.)", "Brgy. 3 (Pob.)", "Brgy. 4 (Pob.)", "Brgy. 5 (Pob.)", "Brgy. 6 (Pob.)", ""
 			+ "Brgy. 7 (Pob.)","Brgy. 8 (Pob.)", "Brgy. 9 (Pob.)", "Brgy. 9-A (Pob.)", "Bolbok", "Bugtong na Pulo", "Bulacnin", "Bulaklakan", "Calamias", "Cumba", "Dagatan", ""
 			+ "Duhatan", "Halang", "Inosluban", "Kayumanggi", "Labac", "Latag", "Lodlod", "Lumbang", "Mabini", "Malagonlong", "Malitlit", "Marauoy", "Mataas na Lupa", ""
 			+ "Munting Pulo", "Pagolingin Bata", "Pagolingin East", "Pagolingin West", "Pangao", "Pinagkawitan", "Pinagtongulan", "Plaridel", "Pusil", "Quezon", "Rizal", ""
 			+ "Sabang", "Sampaguita", "San Benito", "San Carlos", "San Celestino", "San Francisco", "San Guillermo", "San Jose", "San Lucas", "San Salvador", "San Sebastian (Balagbag)"
 			+ "Santo Niño", "Santo Toribio", "Sapac", "Sico", "Talisay", "Tambo", "Tangob", "Tanguay", "Tibig", "Tipacan"});
 	barangaysInCity.put("Lobo", new String[] {"Apar", "Balatbat", "Balibago", "Banalo", "Biga", "Bignay", "Calo", "Calumpit", "Fabrica", "Jaybanga", "Lagadlarin", ""
 			+ "Mabilog na Bundok", "Malabrigo", "Malalim na Sanog", "Malapad na Parang", "Masaguitsit", "Nagtaluntong", "Nagtoctoc", "Olo-olo", "Pinaghawanan", "Poblacion", ""
 			+ "San Miguel", "San Nicolas", "Sawang", "Soloc", "Tayuman"});
 	barangaysInCity.put("Mabini", new String[] {"Bacnit", "Barlo", "Caabiangan", "Cabanaetan", "Cabinuangan", "Calzada", "Caranglaan", "De Guzman", "Luna", "Magalong", ""
 			+ "Nibaliw", "Patar", "Poblacion", "San Pedro", "Tagudin", "Villacorta"});
 	barangaysInCity.put("Tanauan", new String[] {"Altura Bata", "Altura Matanda", "Altura-South", "Ambulong", "Banadero", "Bagbag", "Bagumbayan", "Balele", "Banjo East (Bungkalot)\r\n"
 			+ "Banjo West (Banjo Laurel)", "Bilog-bilog", "Boot", "Cale", "Darasa", "Pagaspas (Balokbalok)", "Gonzales", "Hidalgo", "Janopol", "Janopol Oriental", "Laurel", ""
 			+ "Luyos", "Mabini", "Malaking Pulo", "Maria Paz", "Maugat", "Montaña (Ik-ik)", "Natatas", "Pantay Matanda", "Pantay Bata", "" 			
 			+ "Brgy. 1 (Pob.)", "Brgy. 2 (Pob.)", "Brgy. 3 (Pob.)", "Brgy. 4 (Pob.)", "Brgy. 5 (Pob.)", "Brgy. 6 (Pob.)", "Brgy. 7 (Pob.)", ""
 			+ "Sala", "Sambat", "San Jose", "Santol (Doña Jacoba Garcia)", "Santor", "Sulpoc", "Suplang", "Talaga", "Tinurik", "Trapiche", "Ulango", "Wawa" });
 	
 	barangaysInCity.put("Bacoor", new String[] {"Alima", "Aniban", "Banalo", "Camposanto", "Daang Bukid", "Digman", "Dulong Bayan", "Habay", "Kaingin", "Ligas", "Mabolo", ""
 			+ "Maliksi", "Niog", "Panapaan", "Poblacion", "Real", "Salinas", "San Nicolas", "Sineguelasan", "Talaba", "Zapote", "Bacoor East (District 2)", "Bayanan", ""
 			+ "Mambog", "Molino", "Queens Row Central", "Queens Row East", "Queens Row West"});
 	barangaysInCity.put("Cavite City", new String[] {"Brngy. 1 (Hen. M. Alvarez)", "Brngy. 2 (Hen. C. Tirona)", "Brngy. 3 (Hen. E. Aguinaldo)", "Brngy. 4 (Hen. M. Trias)", ""
 			+ "Brngy. 5 (Hen. E. Evangelista)", "Brngy. 6 (Diego Silang)",  "Brngy. 7 (Kapitan Kong)", "Brngy. 8 (Manuel S. Rojas)", "Brngy. 9 (Kanaway)", "Brngy. 10-M (Kingfisher)", ""
 			+ "Brngy. 10-A (Kingfisher A)", "Brngy. 10-B (Kingfisher B)", "Brngy. 11 (Lawin)", "Brngy. 12 (Love Bird)", "Brngy. 13 (Aguila)", "Brngy. 14 (Loro)", "Brngy. 15 (Kilyawan)", ""
 			+ "Brngy. 16 (Martines)", "Brngy. 17 (Kalapati)", "Brngy. 18 (Maya/Pisces)", "Brngy. 19 (Gemini)", "Brngy. 20 (Virgo)", "Brngy. 21 (Scorpio)", "Brngy. 22 (Leo)", ""
 			+ "Brngy. 22-A (Leo A)", "Brngy. 23 (Aquarius)", "Brngy. 24 (Libra)", "Brngy. 25 (Capricorn)", "Brngy. 26 (Cancer)", "Brngy. 27 (Sagittarius)", "Brngy. 28 (Taurus)", ""
 			+ "Brngy. 29 (Lao-lao/Aries)", "Brngy. 29-A (Lao-lao A/Aries A)", "Brngy. 30 (Bid-bid)", "Brngy. 31 (Maya-maya)", "Brngy. 32 (Salay-salay)", "Brngy. 33 (Buan-buan)", ""
 			+ "Brngy. 34 (Lapu-lapu)", "Brngy. 35 (Hasa-hasa)", "Brngy. 36 (Sap-Sap)", "Brngy. 36-A (Sap-sap A)", "Brngy. 37-M (Cadena de Amor)", "Brngy. 37-A (Cadena de Amor A)", ""
 			+ "Brngy. 38 (Sampaguita)", "Brngy. 38-A (Sampaguita A)", "Brngy. 39 (Jasmin)", "Brngy. 40 (Gumamela)", "Brngy. 41 (Rosal)", "Brngy. 42 (Pinagbuklod)", "Brngy. 42-A (Pinagbuklod A)", ""
 			+ "Brngy. 42-B (Pinagbuklod B)", "Brngy. 42-C (Pinagbuklod C)", "Brngy. 43 (Pinagpala)", "Brngy. 44 (Maligaya)",  "Brngy. 45 (Kaunlaran)", "Brngy. 45-A (Kaunlaran A)", ""
 			+ "Brngy. 46 (Sinagtala)", "Brngy. 47 (Pagkakaisa)", "Brngy. 47-A (Pagkakaisa A)", "Brngy. 47-B (Pagkakaisa B)", "Brngy. 48 (Narra)", "Brngy. 48-A (Narra A)", ""
 			+ "Brngy. 49 (Akasya)", "Brngy. 49-A (Akasya A)", "Brngy. 50 (Kabalyero)"  });
 	barangaysInCity.put("Imus", new String[] {"Alapan", "Bucandala", "Carsadang Bago", "Malagasang", "Medicion", "Pag-asa", "Poblacion", "Toclong", "District II", "Anabu", ""
 			+ "Bagong Silang (Bahayang Pag-asa)", "Bayan Luma", "Buhay na Tubig", "Magdalo", "Maharlika", "Mariano Espeleta", "Palico", "Pasong Buaya", "Pinagbuklod", "Tanzang Luma"});
 	barangaysInCity.put("Tagaytay", new String[] {"Asisan", "Bagong Tubig", "Calabuso", "Dapdap East", "Dapdap West", "Francisco", "Guinhawa North", "Guinhawa South", ""
 			+ "Iruhin East", "Iruhin South", "Iruhin West", "Kaybagal Central", "Kaybagal North", "Kaybagal South (Poblacion)", "Mag-Asawang Ilat", "Maharlika East", "Maharlika West", ""
 			+ "Maitim 2nd Central", "Maitim 2nd East", "Maitim 2nd West", "Mendez Crossing East", "Mendez Crossing West", "Neogan", "Patutong Malaki North", "Patutong Malaki South", ""
 			+ "San Jose", "Silang Junction North", "Silang Junction South", "Sungay East", "Sungay West", "Tolentino East", "Tolentino West", "Zambal" });
 	barangaysInCity.put("Alaminos", new String[] {"Brgy. 1 (Pob.)", "Brgy. 2 (Pob.)", "Brgy. 3 (Pob.)", "Brgy. 4 (Pob.)", "Del Carmen", "Palma", "San Agustin (Antipolo)", "San Andres"});
 	barangaysInCity.put("Biñan", new String[] {"Biñan (Pob.)", "Bungahan", "Santo Tomas (Calabuso)", "Canlalay", "Casile", "De La Paz", "Ganado", "San Francisco (Halang)", "Langkiwa", ""
 			+ "Loma", "Malaban", "Malamig", "Mampalasan", "Platero", "Poblacion", "Santo Niño", "San Antonio", "San Jose", "San Vicente", "Soro-soro", "Santo Domingo", "Timbao", "Tubigan", "Zapote"});
 	barangaysInCity.put("Calamba", new String[] {"Bagong Kalsada", "Bañadero", "Banlic", "Barandal", "Batino", "Brgy. 1 (Pob.)", "Brgy. 2 (Pob.)", "Brgy. 3 (Pob.)", "Brgy. 4 (Pob.)", ""
 			+ "Brgy. 5 (Pob.)", "Brgy. 6 (Pob.)", "Brgy. 7 (Pob.)", "Bubuyan", "Bucal", "Bunggo", "Burol", "Camaligan", "Canlubang", "Halang", "Hornalan", "Kay-Anlog", "Laguerta", "La Mesa", ""
 			+ "Lawa", "Lecheria", "Lingga", "Looc", "Mabato", "Majada-Labas", "Makiling", "Mapagong", "Masili", "Maunong", "Mayapa", "Milagrosa", "Paciano Rizal", "Palingon", ""
 			+ "Palo-Alto", "Pansol", "Parian", "Prinza", "Punta", "Puting Lupa", "Real", "Saimsim", "Sampiruhan", "San Cristobal", "San Jose", "San Juan", "Sirang Lupa", "Sucol", ""
 			+ "Turbina", "Ulango", "Uwisan"});
 	barangaysInCity.put("Los Baños", new String[] {"Anos", "Bagong Silang", "Bambang", "Batong Malake", "Baybayin", "Bayog", "Lalakay", "Maahas", "Malinta", "Mayondon", ""
 			+ "Putho-Tuntungin", "San Antonio", "Tadlac", "Timugan"});
 	barangaysInCity.put("Pakil", new String[] {"Baño (Pob.)", "Banilan", "Burgos (Pob.)", "Casa Real", "Casinsin", "Dorado", "Gonzales (Pob.)", "Kabulusan", "Matikiw", "Rizal (Pob.)", ""
 			+ "Saray", "Taft (Pob.)", "Tavera (Pob.)"});
 	barangaysInCity.put("Rizal", new String[] {"Antipolo", "Entablado", "Laguan", "Paule 1", "Paule 2", "East Poblacion", "West Poblacion", "Pook", "Tala", "Talaga", "Tuy"});
 	
 	barangaysInCity.put("Agdangan", new String[] {"Binagbag", "Dayap", "Ibabang Kinagunan", "Ilayang Kinagunan", "Kanlurang Calutan", "Kanlurang Maligaya", "Salvacion", "Silangang Calutan", ""
 			+ "Silangang Maligaya", "Sildora", "Poblacion I", "Poblacion II"});
 	barangaysInCity.put("Buenavista", new String[] {"Bagong Silang", "Batabat Norte", "Batabat Sur", "Buenavista", "Bukal", "Bulo", "Cabong", "Cadlit", "Catulin", "Cawa", "De La Paz", ""
 			+ "Del Rosario", "Hagonghong", "Ibabang Wasay", "Ilayang Wasay", "Lilukin", "Mabini", "Mabutag", "Magallanes", "Maligaya (Esperanza)", "Manlana", "Masaya", "Poblacion", "Rizal", ""
 			+ "Sabang Pinamasagan", "Sabang Piris", "San Diego", "San Isidro Ibaba", "San Isidro Ilaya", "San Pablo", "San Pedro (Villa Rodrigo)", "San Vicente", "Siain", "Villa Aurora", ""
 			+ "Villa Batabat", "Villa Magsaysay", "Villa Veronica"});
 	barangaysInCity.put("Candelaria", new String[] {"Bukal Norte", "Bukal Sur", "Buenavista East", "Buenavista West", "Kinatihan I", "Kinatihan II", "Malabanban Norte", "Malabanban Sur", ""
 			+ "Mangilag Norte", "Mangilag Sur", "Masalukot I", "Masalukot II", "Masalukot III", "Masalukot IV", "Masalukot V", "Masin Norte", "Masin Sur", "Mayabobo", "Pahinga Norte", ""
 			+ "Pahinga Sur", "Poblacion", "San Andres", "San Isidro", "Santa Catalina Norte", "Santa Catalina Sur"});
 	barangaysInCity.put("Lucban", new String[] {"Abang", "Aliliw", "Atulinao", "Brgy. 1 (Pob.)", "Brgy. 10 (Pob.)", "Brgy. 11 (Pob.)", "Brgy. 2 (Pob.)", "Brgy. 3 (Pob.)", ""
 			+ "Brgy. 4 (Pob.)", "Brgy. 5 (Pob.)", "Brgy. 6 (Pob.)", "Brgy. 7 (Pob.)","Brgy. 8 (Pob.)", "Brgy. 9 (Pob.)", "Igang", "Kabatete", "Kakawit", "Kalangay", "Kalyaat", ""
 			+ "Kilib", "Kulapi", "Mahabang Parang", "Malupak", "Manasa", "May-It", "Nagsinamo", "Nalunao", "Palola", "Piis", "Samil", "Tiawe", "Tinamnan"});
 	barangaysInCity.put("Lucena City (Capital)", new String[] {"Brgy. 1 (Pob.)", "Brgy. 10 (Pob.)", "Brgy. 11 (Pob.)", "Brgy. 2 (Pob.)", "Brgy. 3 (Pob.)", "Brgy. 4 (Pob.)", ""
 			+ "Brgy. 5 (Pob.)", "Brgy. 6 (Pob.)","Brgy. 7 (Pob.)","Brgy. 8 (Pob.)","Brgy. 9 (Pob.)", "Barra", "Bocohan", "Cotta", "Dalahican", "Domoit", "Gulang-Gulang", ""
 			+ "Ibabang Dupay", "Ibabang Iyam", "Ibabang Talim", "Ilayang Dupay", "Ilayang Iyam", "Ilayang Talim", "Isabang", "Market View", "Mayao Castillo", ""
 			+ "Mayao Crossing", "Mayao Kanluran", "Mayao Parada", "Mayao Silangan", "Ransohan", "Salinas", "Talao-Talao" });
 	barangaysInCity.put("Pagbilao", new String[] {"Alupaye", "Añato", "Antipolo", "Bantigue","Brgy. 1 (Pob.)","Brgy. 2 (Pob.)", "Brgy. 3 (Pob.)", "Brgy. 4 (Pob.)", ""
 			+ "Brgy. 5 (Pob.)", "Brgy. 6 (Pob.)", "Bigo", "Binahaan", "Bukal", "Ibabang Bagumbungan", "Ibabang Palsabangon (detour)", "Ibabang Polo", "Ikirin", "Ilayang Bagumbungan", ""
 			+ "Ilayang Palsabangon", "Ilayang Polo", "Kanlurang Malicboy", "Mapagong", "Mayhay", "Pinagbayanan", "Silangang Malicboy", "Talipan", "Talipan" });
 	barangaysInCity.put("Quezon, Quezon", new String[] {"Apad", "Argosino","Brgy. 1 (Pob.)", "Brgy. 2 (Pob.)", "Brgy. 3 (Pob.)", "Brgy. 4 (Pob.)", ""
 			+ "Brgy. 5 (Pob.)", "Brgy. 6 (Pob.)", "Cagbalogo", "Caridad", "Cometa", "Del Pilar", "Guinhawa", "Gumubat", "Magsino", "Mascariña", "Montaña", "Sabang", "Silangan", ""
 			+ "Tagkawa", "Villa Belen", "Villa Francia", "Villa Gomez", "Villa Mercedes"});
 	barangaysInCity.put("Angono", new String[] {"Bagumbayan", "Kalayaan", "Poblacion Ibaba", "Poblacion Itaas", "San Isidro", "San Pedro", "San Roque", "San Vicente", ""
 			+ "Santo Niño", "Mahabang Parang"});
 	
 	barangaysInCity.put("Binangonan", new String[] {"Bangad", "Batingan", "Bilibiran", "Binitagan", "Bombong", "Buhangin", "Calumpang", "Darangan", "Ginoong Sanay", ""
 			+ "Gulod", "Habagatan", "Ithan", "Janosa", "Kalinawan", "Kasile", "Kaytome", "Kinaboogan", "Kinagatan", "Layunan", "Libid", "Libis", "Limbon-limbon", ""
 			+ "Lunsad", "Macamot", "Mahabang Parang", "Malakaban", "Mambog", "Pag-asa", "Palangoy", "Pantok", "Pila Pila", "Pinagdilawan", "Pipindan", "Rayap", ""
 			+ "San Carlos Heights", "Sapang", "Tabon", "Tagpos", "Tatala", "Tayuman"});
 	barangaysInCity.put("Cainta", new String[] {"San Andres (Pob.)", "San Isidro", "San Juan", "San Roque", "Santa Rosa", "Santo Domingo", "Santo Niño"});
 	barangaysInCity.put("Jalajala", new String[] {"Bagumbong", "Bayugo", "Second District (Pob.)", "Third District (Pob.)", "Lubo", "Pagkalinawan", "Palaypalay", ""
 			+ "Punta", "Sipsipin", "First (Special) District (Pob.)", "Paalaman"});
 	barangaysInCity.put("San Mateo", new String[] {"Ampid I", "Ampid II", "Banaba", "Dulong Bayan I", "Dulong Bayan II", "Guinayang", "Guitnang Bayan I", ""
 			+ "Guitnang Bayan II", "Gulod Malaya", "Malanday", "Maly", "Pintong Bukawe", "Santa Ana", "Santo Niño", "Silangan", "San Mateo"});
 	barangaysInCity.put("Taytay", new String[] {"Dolores (Pob.)", "Muzon", "San Isidro", "San Juan", "Santa Ana"});
 }

 private void populateCities(String selectedProvince) {
     String[] cities = citiesInProvince.get(selectedProvince);
     cityCombo.removeAllItems();
     for (String city : cities) {
         cityCombo.addItem(city);
     }
 }

 private void populateBarangays(String selectedCity) {
     String[] barangays = barangaysInCity.get(selectedCity);
     barangayCombo.removeAllItems();
     if (barangays != null) {
         for (String barangay : barangays) {
             barangayCombo.addItem(barangay);
         }
     }
 }

 private class SubmitButtonListener implements ActionListener {
     @Override
     public void actionPerformed(ActionEvent e) {
         try {
             String name = nameField.getText();
             int age = Integer.parseInt(ageField.getText());
             String typeOfDisaster = (String) disasterCombo.getSelectedItem();
             int severityLevel = Integer.parseInt(severityField.getText());
             String healthCondition = healthField.getText();
             boolean hasEmergencySupplies = suppliesCheckBox.isSelected();
             boolean isShelterAvailable = shelterCheckBox.isSelected();
             String province = (String) provinceCombo.getSelectedItem();
             String city = (String) cityCombo.getSelectedItem();
             String barangay = (String) barangayCombo.getSelectedItem();

             String assessmentResult = assessPostDisasterSituation(typeOfDisaster, severityLevel, age, healthCondition,
                     hasEmergencySupplies, isShelterAvailable, province);

             // Create and display the result window
             ResultWindow resultWindow = new ResultWindow(name, province, city, barangay, assessmentResult, typeOfDisaster);
             resultWindow.setVisible(true);
         } catch (NumberFormatException ex) {
             JOptionPane.showMessageDialog(Project3.this, "Please enter valid numbers for age and severity level.", "Input Error", JOptionPane.ERROR_MESSAGE);
         }
     }
 }


 public static String assessPostDisasterSituation(String typeOfDisaster, int severityLevel, int age,
         String healthCondition, boolean hasEmergencySupplies, boolean isShelterAvailable, String location) {
     
 	int ageFactor = (age >= 60) ? 3 : 1;
     int healthFactor = healthCondition.equalsIgnoreCase("poor") ? 3 : 1;
     int suppliesFactor = hasEmergencySupplies ? 1 : 2;
     int shelterFactor = isShelterAvailable ? 1 : 2;
     int severityFactor = severityLevel > 6 ? 3 : 1;
     int dangerMeter;

     switch (typeOfDisaster.toLowerCase()) {
         case "landslides":
         case "earthquake":
             dangerMeter = 4;
             break;
         case "hurricane":
         case "volcanoes":
         	dangerMeter = 3;
             break;
         case "flood":
             dangerMeter = 2;
             break;
         case "tornado":
         case "wildfire":
         	dangerMeter = 5;
             break;
         default:
             dangerMeter = 1;
             break;
     }

     int totalScore = ageFactor + healthFactor + suppliesFactor + shelterFactor + severityFactor + dangerMeter;

     if (totalScore <= 7) {
         return " - You seem to be in a good post-disaster situation.\n   Continue to stay safe.";
     } else if (totalScore <= 10) {
         return " - Your post-disaster situation is moderate.\n - Ensure you have necessary supplies and find suitable shelter.\n - We are connecting "
         		+ "you to your local government agencies...\n - PLEASE REMAIN CALM AND STAY IN YOUR SAFE LOCATION,\n   HELP IS ON THE WAY.";
     } else {
         return " - Your post-disaster situation is challenging.\n - Prioritize finding shelter and supplies.\n - We are connecting to you to your local "
         		+ "government agencies...\n - PLEASE REMAIN CALM AND STAY IN YOUR SAFE LOCATION,\n   HELP IS ON THE WAY.";
     }
 }

 public static void main(String[] args) {
         Project3 frame = new Project3();
         frame.setVisible(true);
 }
}

	class ResultWindow extends JFrame {
 private JTextArea resultArea;
 private JTextArea contactArea;
 private JTextArea dosAndDontsArea;

 public ResultWindow(String name, String province, String city, String barangay, String assessmentResult, String typeOfDisaster) {
     setTitle("Assessment Result");
     setSize(1000, 600);
     setLayout(new BorderLayout());

     // Create a panel to contain severityPanel, contactPanel, and dosAndDontsPanel with margin
     JPanel contentPanel = new JPanel(new BorderLayout());
     contentPanel.setBorder(new EmptyBorder(20, 10, 10, 10));

     // Create three panels
     JPanel severityPanel = new JPanel(new BorderLayout());
     JPanel contactPanel = new JPanel(new BorderLayout());
     JPanel dosAndDontsPanel = new JPanel(new BorderLayout());

     // Add labels to each panel
     JLabel severityLabel = new JLabel("Severity Result");
     JLabel contactLabel = new JLabel("Contact List");
     JLabel dosAndDontsLabel = new JLabel("Do's and Don'ts during Disaster");

     severityPanel.add(severityLabel, BorderLayout.NORTH);
     contactPanel.add(contactLabel, BorderLayout.NORTH);
     dosAndDontsPanel.add(dosAndDontsLabel, BorderLayout.NORTH);

     // Add JTextAreas to each panel
     resultArea = new JTextArea(20, 30);
     resultArea.setEditable(false);
     resultArea.setFont(new Font("Arial", Font.BOLD, 15)); 
     String location = barangay + ", " + city + ", " + province;
     resultArea.setText(" Post-Disaster Assessment Result for " + name + " in\n " + location + ":\n" + assessmentResult);
     JScrollPane resultScrollPane = new JScrollPane(resultArea);

     contactArea = new JTextArea(20, 30);
     contactArea.setEditable(false);
     contactArea.setFont(new Font("Arial", Font.BOLD, 14)); 
     String contactDetails = getContactDetails(province);
     contactArea.setText("For further communication, you may contact the\nNational Hotline Services: 911\nor the following emergency hotlines:\n\n" + contactDetails);
     JScrollPane contactScrollPane = new JScrollPane(contactArea);

     dosAndDontsArea = new JTextArea(20, 30);
     dosAndDontsArea.setEditable(false);
     dosAndDontsArea.setFont(new Font("Arial", Font.BOLD, 14));
     String dosAndDontsInfo = getDosAndDonts(typeOfDisaster);
     dosAndDontsArea.setText(dosAndDontsInfo);
     JScrollPane dosAndDontsScrollPane = new JScrollPane(dosAndDontsArea);

     severityPanel.add(resultScrollPane, BorderLayout.CENTER);
     contactPanel.add(contactScrollPane, BorderLayout.CENTER);
     dosAndDontsPanel.add(dosAndDontsScrollPane, BorderLayout.CENTER);

     // Create split panes
     JSplitPane splitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, severityPanel, contactPanel);
     splitPane1.setDividerLocation(500);

     JSplitPane splitPane2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, splitPane1, dosAndDontsPanel);
     splitPane2.setDividerLocation(300);

     add(splitPane2, BorderLayout.CENTER);

     // Add buttons at the bottom
     JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
     JButton exitButton = new JButton("Exit");


     exitButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             // Exit the program
             System.exit(0);
         }
     });

     buttonPanel.add(exitButton);
     add(buttonPanel, BorderLayout.SOUTH);

     setLocationRelativeTo(null);
 	}
 

 public static String getContactDetails(String province) {
     switch (province) {
         case "Batangas":
             return " Mayor's Action Center: 723-1511 \n PNP Batangas: 723-2030\n BFP Batangas:\n\t425-7163\n\t301-7996\n\t09156021984\n\n"
             		+ " HOSPITALS\n\tBatangas Medical Center: 723-0911\n\tSt. Patrick’s Hospital & Medical Center: 723-1605\n\tJesus of Nazareth Hospital: 723-4144\n"
             		+ "\tGolden Gate General Hospital: 723-2508\n\n"
             		+ " MERALCO - All Departments: 16211/1622-2847\n National Power Corporation: 300-3592\n"
             		+ " PrimeWater Batangas:\n\t09494142633\n\t980-6928\n PDRRMO: 702-3902\n"
             		+ " LTO Batangas: 740-9738";
         case "Cavite":
             return " POLICE STATIONS\n\tBacoor : (046) 417-6366\n\tImus: (046) 471-3993\n\tDasmariñas: (046) 416-0254\n\tTagaytay: (046) 413-1282\n\n"
             		+ " FIRE STATIONS\n\tCavite Provincial Office: (046) 471-4777\n\tBacoor: (046) 417-6060\n\tImus: (046) 970-5161\n"
             		+ "\tDasmariñas: (046) 416-0875\n\tTagaytay: (046) 483-1193\n\n"
             		+ " DRRMO HOTLINES\n\tProvincial: (046) 424-0203\n\tImus: (046) 472-2618\n\tBacoor: (046) 417-0727\n\n"
             		+ " MERALCO - Business Center: (02) 16211\n"
             		+ " Maynilad Water Services, Inc: (046) 471-1594";
         case "Laguna":
             return " PNP Laguna: (02) 8722-0650\n BFP Laguna: (02) 8426-0219\n\n"
             		+ " PDRRMO:\n\t566-6370\n\t501-4672\n\t0917-417-3698\n"
             		+ " Philippine Red Cross:\n\t(049) 501-1114\n\t0915-426-0718\n\t0939-520-7898\n\n"
             		+ " Action Center Office: 501-2628\n Command Center: 545-9211\n Emergency Response Team: 0921-907-8886";
         case "Quezon":
             return " Office of the Governor: (042) 373-6007\n\t 0920-956-2364\n\n"
             		+ " PDRRMO:\n\t(042) 710-3933\n\t0946-274-8706\n\n"
             		+ " Police Provincial Office:\n\t0920-979-6911\n\t0915-789-3115t";
         case "Rizal":
             return " Fire Provincial Marshal: 0920-172-5254\n BFP Taytay: +63 (2) 658-6439\n"
             		+ " PDRRMO: (02) 8571-4375\n"
             		+ " Philippine Red Cross: (02) 661-2138\n"
             		+ " MERALCO - Business Center: 651-0482\n"
             		+ " DPWH 1st District: 0916-381-4990";
         default:
             return "Emergency services: 911";
     }
 }

 public static String getDosAndDonts(String typeOfDisaster) {
     switch (typeOfDisaster.toLowerCase()) {
         case "earthquake":
             return " DO's:\n - Drop, Cover, and Hold On\n - Keep calm and reassure others.\n"
             		+ " - During the event, the safest place is an open space, away from buildings.\n"
             		+ " - If you are indoors, take cover under a desk, table, bed, or doorways and against inside walls and staircase.\n"
             		+ "   Stay away from glass doors, glass panes, windows, or outside doors. Do not rush to go out of the building, to avoid the stampede.\n"
             		+ " - If you are outside, move away from buildings and utility wires.\n"
             		+ " - Once in the open, stay there till the vibrations stop.\n"
             		+ " - If you are in a moving vehicle, stop as quickly as possible and stay in the vehicle.\n"
             		+ " - Free all pets and domestic animals so that they can run outside.\n\n"
             		+ " DON'Ts:\n - Do not use elevators.\n - Do not use candles, matches or other open flames. Put out all fires.\n"
             		+ " - Do not remain close to windows, glass, walls or anything that can fall during an earthquake.\n"
             		+ " - Do not move till the tremor stops\n"
             		+ " - Do not be near bridges and roads damaged by an earthquake.\n"
             		+ " - Do not stand near a doorway.";
         case "flood":
             return " DO's:\n Listen to the radio or television for information.\n"
             		+ " - Be aware that flash flooding can occur. If there is any possibility of a flash flood,\n"
             		+ "   move immediately to higher ground. Do not wait for instructions to move.\n"
             		+ " - Be aware of streams, drainage channels, canyons, and other areas known to flood suddenly.\n"
             		+ "   Flash floods can occur in these areas with or without such typical warnings as rain clouds or heavy rain.\n"
             		+ " - If you have to evacuate, secure your home if you have time.\n"
             		+ " - Move essential items to the second floor of the house in case the floodwater goes higher than a few inches or feet.\n"
             		+ " - Turn off utilities before leaving the house.\n\n"
             		+ " DON'Ts:\n - Do not walk through flowing water. Six inches of moving water can make you fall. If you have to walk in water,\n"
             		+ "   walk where the water is not moving. Use a stick to check the firmness of the ground in front of you.\n"
             		+ " - Do not drive through flooded areas. If floodwaters rise around your car, abandon the car and move to higher ground\n"
             		+ "   if you can do so safely. You and the vehicle can be quickly swept away.";
         case "typhoon":
             return " DO's:\n - Be calm and stay at home.\n"
             		+ " - Monitor weather news and updates.\n"
             		+ " - Avoid flood and landslide prone areas.\n"
             		+ " - Reserve extra food, medicines, clothes, drinking water, and first aid kit.\n"
             		+ " - In case of floods inside home, turn off the electric main swith of your house.\n"
             		+ " - Make sure that important things like appliancese and personal documents are safe from flood water and rains.\n"
             		+ " - Avoid low level areas, rivers, seaside, and mountainous areas."
             		+ " - Keep the phone lines open to facilitate rescue and communication in times of emergencies.\n\n"
             		+ " DON'Ts:\n - Don not leave shelters until informed by the rescue personals.\n"
             		+ " - Don not leave the safer place during lull, however minor repairs can be carried out."
             		+ " - Do not cross on flooded areas or rivers.\n"
             		+ " - Do not use wet or washed out electric appliances or gasoline-operated equipment.\n"
             		+ " - Do not touch the loose and dangling wire from lamp post, it may have electric current.";
         case "wildfire":
             return " DO's:\n - Escape first, then call for help.\n - Before opening a door, feel it with the back of your hand. If the door is hot, do not open it.\n"
             		+ " - If you encounter smoke during your evacuation, stay low to the floor.\n"
             		+ " - Use the appropriate fire extinguisher.\n\n"
             		+ " DON'Ts:\n - Do not use elevators during an evacuation.\n"
             		+ " - Do not return to your home until authorities say it is safe.\n"
             		+ " - Do not attempt to fight the fire unless trained.";
         case "landslides":
             return " DO's:\n - If you stay in a landslide-prone area, then try to evacuate the place as early as possible.\n"
             		+ " - Be aware of unusual cracking or rolling of huge stones.\n"
             		+ " - Keep a watch on the water in the stream or channel. A rise in water level or transformation of colour\n"
             		+ "   from clear to muddy can be alarming.\n"
             		+ " - Stay out of the path of debris or landslides.\n"
             		+ " - Keep watch on the road for mud blocks or debris overflow.\n"
             		+ " - Try to connect with the local authority for relief or help.\n"
             		+ " - Just take your necessary documents and valuables with you.\n"
             		+ " - Prioritize your life more than your furniture at home or vehicles on the road.\n\n"
             		+ " DON'Ts:\n - Do not drive during the landslide.\n"
             		+ " - Do not cross any stream or flooding river.\n"
             		+ " - Do not ignore damp areas or any mark of cracks on roads and buildings.\n"
             		+ " - Do not get close to any loose electrical wiring or pole.\n"
             		+ " - Avoid obstructing the path of a steep slope by placing waste materials or debris.";
         case "tornado":
         	return " DO's:\n - If you are already inside a structure, go to a per-designated shelter area such as a safe room, basement, storm cellar\n"
         			+ "   or the lowest building level. Avoid areas near windows.\n"
         			+ " - Listen to a Weather Radio, regular radio or television for tornado updates.\n"
         			+ " - Crouch as low as possible to the floor, facing down. Cover the back of your head with your hands.\n"
         			+ " - If you're in a mobile home, get out, even if it's tied down. You're probably safer outside, even if that means seeking shelter out in the open.\n"
         			+ " - If you're outside with no shelter, lie flat in a ditch or depression and cover your head with your hands. Be aware of the potential for flooding.\n\n"
         			+ " DON'Ts:\n - Do not use your car as shelter.\n"
         			+ " - Do not open the windows in your home. You may be exposed to flying glass if you're opening windows when the twister hits.\n"
         			+ " - Do not use elevators. You could get trapped if the power is lost.\n"
         			+ " - Do not go to the southwest corner of your shelter, most tornadoes approach from the southwest.\n"
         			+ " - Do not park under an overpass. It may seem like good shelter, but it can actually be more dangerous than open ground.\n"
         			+ "   A wind-tunnel effect can cause higher wind speeds, driving debris toward you and even propelling you out from under the overpass.\n"
         			+ " - Do not light candles, even after the storm has passed. Ruptured gas lines can create a fire hazard so it's better to use flashlights.";
         case "volcanoes":
         	return " DO's:\n - Listen to the radio for instructions.\n"
         			+ " - Follow evacuation plan.\n"
         			+ " - Stay inside the house or a car as much as possible.\n"
         			+ " - Cover your nose and mouth with damp handkerchiefs or use dust masks.\n\n"
         			+ " DON'Ts:\n - Do not panic.\n"
         			+ " - Do not go outside unless you have proper protective gear.\n"
         			+ " - Avoid low lying areas.\n"
         			+ " - Do not watch a volcanic eruption as it can be deadly.";
         default:
             return "General guidelines for disaster preparedness.";
     }
 }
}