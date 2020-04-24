
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

public class GUI extends JFrame{
	
	private JPanel findSuspectPanel;
	private JButton findButton, visualizeNetworkButton;
	private JTextField findSuspectTextField;
	private String wantedSuspect;
	private Registry registry;
	private Suspect givenSuspect;

	public GUI(Registry registry) {
		
		this.registry = registry;
		findSuspectPanel = new JPanel();
		findSuspectTextField = new JTextField("Please enter suspect's name");
		findButton = new JButton("Find");
		visualizeNetworkButton = new JButton("Visualize Network");
		
		findSuspectPanel.add(findSuspectTextField);
		findSuspectPanel.add(findButton);
		findSuspectPanel.add(visualizeNetworkButton);

		this.setContentPane(findSuspectPanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setTitle("Find Suspect");
		this.setSize(300, 200);
		
	    ButtonListener listener = new ButtonListener();
		findButton.addActionListener(listener);
		
		
    }
	
	
	class ButtonListener implements ActionListener{
		
        public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(findButton)){
             wantedSuspect = findSuspectTextField.getText();
             
            }
			
			for(Suspect suspect : registry.getSuspects()){
			   if(wantedSuspect.equals(suspect.getName())) {
				   givenSuspect = suspect;
				   MainPanel mainPanel = new MainPanel(givenSuspect, registry);
			   }
			}
		}
	}
	
	
	
	
	
}


