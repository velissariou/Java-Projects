import java.util.ArrayList;

public class Registry {
	// Πεδία κλάσης
	private ArrayList<Communication> communications = new ArrayList<>();
	private ArrayList<Suspect> suspects = new ArrayList<>();
	

	public ArrayList<Suspect> getSuspects() {
		return suspects;
	}


	// Μέθοδοι κλάσης
	public void addSuspect(Suspect aSuspect) {
		
		suspects.add(aSuspect);
	}
	
	
	public void addCommunication(Communication aCommunication) {
		communications.add(aCommunication);
		// Ενημέρωση λίστας πιθανών συνεργατών
		for(Suspect cooperant1 : suspects) {
			if(cooperant1.getTelephoneNumbers().contains(aCommunication.getPhoneNumber1())) {
				for(Suspect cooperant2 : suspects) {
					if(cooperant2.getTelephoneNumbers().contains(aCommunication.getPhoneNumber2())){
						cooperant1.addPossibleCooperant(cooperant2);
						cooperant2.addPossibleCooperant(cooperant1);
					}
				}
			}
		}
	}
	
	public Suspect getSuspectWithMostPartners() {
		Suspect topSuspect = new Suspect();
		for(Suspect aSuspect: suspects) {
			if(aSuspect.getPossibleCooperants().size() >= topSuspect.getPossibleCooperants().size()) {
				topSuspect = aSuspect;
			}
		}
		return topSuspect;
	}
	
	public void printSuspectsFromCountry(String country) {
		for(Suspect aSuspect : suspects) {
			if(aSuspect.getCountry().equals(country)) {
				System.out.println(aSuspect.getName() + " (" + aSuspect.getCodeName() + ")");
			}
				
		}
	}
	 
	public PhoneCall getLongestPhoneCallBetween(String number1, String number2){
		PhoneCall longestPhoneCall = new PhoneCall(number1, number2);
		for(Communication  aPhoneCall : communications) {
			if(aPhoneCall instanceof PhoneCall && aPhoneCall.getPhoneNumber1().equals(number1) && aPhoneCall.getPhoneNumber2().equals(number2) || aPhoneCall instanceof PhoneCall && aPhoneCall.getPhoneNumber1().equals(number2) && aPhoneCall.getPhoneNumber2().equals(number1)) {
				if(((PhoneCall) aPhoneCall).getCallDuration() > longestPhoneCall.getCallDuration())
				    longestPhoneCall = (PhoneCall) aPhoneCall;
			}
		}
		return longestPhoneCall;
	}
	
	public ArrayList<SMS> getMessagesBetween(String number1, String number2){
		ArrayList<SMS> listOfMessages = new ArrayList<>();
		for(Communication aSMS : communications) {
			// Έλεγχος αν το αντικείμενο aSMS ειναι στιγμιότυπο κλάσης SMS και αν έχει πεδία τους ζητούμενους αριθμούς
			if(aSMS instanceof SMS && aSMS.getPhoneNumber1().equals(number1) && aSMS.getPhoneNumber2().equals(number2) || aSMS instanceof SMS && aSMS.getPhoneNumber1().equals(number2) && aSMS.getPhoneNumber2().equals(number1) ) {
				if(((SMS) aSMS).getSmsText().contains("Bomb") ||  ((SMS) aSMS).getSmsText().contains("Gun") || ((SMS) aSMS).getSmsText().contains("Attack") || ((SMS) aSMS).getSmsText().contains("Explosives") )         
					listOfMessages.add((SMS) aSMS);
			}
			
		}
		return listOfMessages;
		
	}

}
