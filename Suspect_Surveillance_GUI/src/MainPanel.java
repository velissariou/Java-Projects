import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainPanel extends JFrame{
	
	private Registry registry;
	private JTextArea suspectPhones,smsText,partnersText, suggestedPartnersText, countryText;
	private JTextField suspectName, suspectCodeName,  phoneSearch;
    private JButton findSMS, returnButton;
    private JLabel partnersLabel, suggestedPartnersLabel;
	private JPanel panel1, panel2, panel3, panel4, panel5, panel6;
	private Suspect givenSuspect;
	private String wantedNumber;
	
	public MainPanel(Suspect givenSuspect, Registry registry) {
		
		this.givenSuspect = givenSuspect;
		this.registry = registry;
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		JPanel panel6 = new JPanel();
		
		this.add(panel1);
		this.add(panel2);
		this.add(panel3);
		this.add(panel4);
		this.add(panel5);
		this.add(panel6);
		
		// #1
		suspectName = new JTextField(givenSuspect.getName());
		suspectCodeName = new JTextField(givenSuspect.getCodeName());
		suspectPhones = new JTextArea(3,0);
		for(String number : givenSuspect.getTelephoneNumbers()) {
			suspectPhones.append(number + System.getProperty("line.separator"));
		}
		suspectName.setEditable(false);
		suspectCodeName.setEditable(false);
		suspectPhones.setEditable(false);
		panel1.add(suspectName);
		panel1.add(suspectCodeName);
		panel1.add(suspectPhones);
		
		// #2
		phoneSearch = new JTextField(10);
		smsText = new JTextArea(10, 20);
		findSMS = new JButton("Find SMS");
		panel2.add(phoneSearch);
		panel2.add(smsText);
		panel2.add(findSMS);
		
		
		// #3
		partnersLabel = new JLabel("Partners");
		partnersText = new JTextArea(10,20);
		for(Suspect suspect : givenSuspect.getPossibleCooperants()) {
			partnersText.append(suspect.getName() + " , " + suspect.getCodeName() + System.getProperty("line.separator"));
		}
		partnersText.setEditable(false);
		panel3.add(partnersLabel);
		panel3.add(partnersText);
		
		
		// #4
		suggestedPartnersLabel = new JLabel("Suggested Partners ------>");
		suggestedPartnersText = new JTextArea(5,20);
		for(Suspect suspect : givenSuspect.getSuggestedPartners(givenSuspect)) {
			suggestedPartnersText.append(suspect.getName() + System.getProperty("line.separator"));
		}
		suggestedPartnersText.setEditable(false);
		panel4.add(suggestedPartnersLabel);
		panel4.add(suggestedPartnersText);
		
		
		//#5
		countryText = new JTextArea(5,30);
		countryText.append("Suspects coming from " + givenSuspect.getCountry());
		countryText.append(System.getProperty("line.separator"));
		for(Suspect suspect : registry.getSuspects()) {
			if(givenSuspect.getCountry().equals(suspect.getCountry())){
				countryText.append(suspect.getName() + System.getProperty("line.separator"));
			}
		}
		panel5.add(countryText);
		
		
		//#6
		returnButton = new JButton("Return to Search Screen");
		panel6.add(returnButton);
		
		
		this.setSize(500, 900);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FindButtonListener findListener = new FindButtonListener();
		findSMS.addActionListener(findListener);
		ReturnToSearchScreen listener = new ReturnToSearchScreen();
		returnButton.addActionListener(listener);
		
	}
	
	class FindButtonListener implements ActionListener {

		
		public void actionPerformed(ActionEvent ae) {
			wantedNumber = phoneSearch.getText();
			
			for(String number : givenSuspect.getTelephoneNumbers()) {
				for(SMS sms : registry.getMessagesBetween(wantedNumber, number)) {
					smsText.append(sms.getSmsText() + System.getProperty("line.separator"));
				}
				
			}
			
		}
		
	}
	
	class ReturnToSearchScreen implements ActionListener {

		
		public void actionPerformed(ActionEvent e) {
			dispose();
			
		}
		
	}

}
