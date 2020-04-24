import java.util.ArrayList;

public class Suspect {
	// Πεδία κλάσης
	private String name;
	private String codeName;
	private String country;
	private String city;
	private ArrayList<String> telephoneNumbers = new ArrayList<>();
	private ArrayList<Suspect> possibleCooperants = new ArrayList<>();
	
	// Κατασκευαστής της κλάσης Suspect
	public Suspect(String name, String codeName, String country, String city) {
		
		this.name = name;
		this.codeName = codeName;
		this.country = country;
		this.city = city;
	}
	// Κατασκευαστής της κλάσης Suspect, χωρίς πεδία για χρήση σε άλλες μεθόδους
	public Suspect() {
		
	}
	
	// Getters των πεδίων της κλάσης Suspect
	public String getName() {
		return name;
	}
	
	public String getCodeName() {
		return codeName;
	}

	public String getCountry() {
		return country;
	}

	public String getCity() {
		return city;
	}


	public ArrayList<String> getTelephoneNumbers() {
		return telephoneNumbers;
	}
	
    // Μέθοδοι της κλάσης Suspect
	public void addNumber(String number) {
		
		telephoneNumbers.add(number);
	
	}
	
	public void addPossibleCooperant(Suspect aSuspect) {
		if(!(possibleCooperants.contains(aSuspect)))
			possibleCooperants.add(aSuspect);
	}
	
	public boolean isConnectedTo(Suspect aSuspect) {
		return possibleCooperants.contains(aSuspect);
	}
	
	public ArrayList<Suspect> getCommonPartners(Suspect aSuspect) {
		ArrayList<Suspect> commonPartners = new ArrayList<>();
		for(Suspect suspects : possibleCooperants) {
			if(aSuspect.possibleCooperants.contains(suspects)) {
				commonPartners.add(suspects);
			}
		}
		return commonPartners;
	}
	
	public void printPossibleCooperants() {
		for(Suspect suspect: possibleCooperants){
			System.out.println(suspect.getName());
			System.out.println(suspect.getCodeName());
		}
	}

	public ArrayList<Suspect> getPossibleCooperants() {
		return possibleCooperants;
	}
	
	public ArrayList<Suspect> getSuggestedPartners(Suspect wantedSuspect) {
		ArrayList<Suspect> suggestedPartners = new ArrayList<>();
		for(Suspect suspect : wantedSuspect.getPossibleCooperants()) {
			ArrayList<Suspect> suspectList = suspect.getPossibleCooperants();
			suspectList.remove(wantedSuspect);
			for(Suspect aSuspect : suspectList) {
				if (!possibleCooperants.contains(aSuspect)) {
					suggestedPartners.add(aSuspect);
				}
			}
			
		}
		
		return suggestedPartners;
	}
	

}
