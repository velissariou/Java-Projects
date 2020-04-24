
public class SMS extends Communication {
	
	// �������� ����� ������ SMS
	private String smsText;

	// K������������ �� ��� �� ����� ��� ��������� ��� ��� ����������
	public SMS(String phoneNumber1, String phoneNumber2, int day, int month, int year, String smsText) {
		super(phoneNumber1, phoneNumber2, year, month, day);
		this.smsText = smsText;
	}
	
	// Overriden method 
	public void printInfo(){
 		System.out.println("This SMS has the following info:");
 		System.out.println("Between " + phoneNumber1 + "--- " + phoneNumber2);
 		System.out.println("on " + year + "/" + month + "/" + day);
 		System.out.println("Text: " + smsText);
 	}

	public String getSmsText() {
		return smsText;
	}
	
	

}
