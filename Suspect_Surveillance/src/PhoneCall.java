
public class PhoneCall extends Communication {
	
	// Πεδίο κλάσης PhoneCall
	private int callDuration;
    
	// Κατασκευαστής με όλα τα πεδία της υποκλάσης και της υπερκλάσης
 	public PhoneCall(String phoneNumber1, String phoneNumber2, int day, int month, int year, int callDuration) {
		super(phoneNumber1, phoneNumber2, year, month, day);
		this.callDuration = callDuration;
		
	}
 	
    /*Κατασκευαστής με δύο πεδία number1, number2 για χρήση στην 
 	 *Registry.getLongestPhoneCallBetween(String number1, String number2)*/
 	
 	public PhoneCall(String number1, String number2) {
		super(number1, number2);
	}


    // Overriden method 
	public void printInfo(){
 		System.out.println("This phone call has the following info:");
 		System.out.println("Between " + phoneNumber1 + "--- " + phoneNumber2);
 		System.out.println("on " + year + "/" + month + "/" + day);
 		System.out.println("Duration: " + callDuration);
 	}

	public int getCallDuration() {
		return callDuration;
	}
 	
 	

}
