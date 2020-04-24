
public abstract class Communication {
	// Πεδία της κλάσης Communication, protected για να είνα ορατά στις sublcasses PhoneCall , SMS
	protected String phoneNumber1;
	protected String phoneNumber2;
	protected int year;
	protected int month;
	protected int day;
	
	// Κατασκευαστής Communication με όλα τα πεδία
	public Communication(String phoneNumber1, String phoneNumber2, int year, int month, int day) {
		
		this.phoneNumber1 = phoneNumber1;
		this.phoneNumber2 = phoneNumber2;
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	/* Κατασκευαστής Communication με πεδία μόνο τους 
	 * αριθμούς τηλεφώνου για χρήση στις μεθόδους 
	 * Registry.getLongestPhoneCallBetween(String number1, String number2
	   και Registry.getMessagesBetween(String number1, String number2) */
	
    public Communication(String phoneNumber1, String phoneNumber2) {
		
		this.phoneNumber1 = phoneNumber1;
		this.phoneNumber2 = phoneNumber2;
	}
    
    
    // Getters των πεδίων phoneNumber1 και PhoneNumber2
	public String getPhoneNumber1() {
		return phoneNumber1;
	}





	public String getPhoneNumber2() {
		return phoneNumber2;
	}





	
	
    // Μοναδική abstract μέθοδος, υλοποιείται στις υποκλάσεις με override
	public abstract void printInfo() ;
		
	
	
		
	
	
	

}
