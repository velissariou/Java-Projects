
public abstract class Communication {
	// ����� ��� ������ Communication, protected ��� �� ���� ����� ���� sublcasses PhoneCall , SMS
	protected String phoneNumber1;
	protected String phoneNumber2;
	protected int year;
	protected int month;
	protected int day;
	
	// ������������� Communication �� ��� �� �����
	public Communication(String phoneNumber1, String phoneNumber2, int year, int month, int day) {
		
		this.phoneNumber1 = phoneNumber1;
		this.phoneNumber2 = phoneNumber2;
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	/* ������������� Communication �� ����� ���� ���� 
	 * �������� ��������� ��� ����� ���� �������� 
	 * Registry.getLongestPhoneCallBetween(String number1, String number2
	   ��� Registry.getMessagesBetween(String number1, String number2) */
	
    public Communication(String phoneNumber1, String phoneNumber2) {
		
		this.phoneNumber1 = phoneNumber1;
		this.phoneNumber2 = phoneNumber2;
	}
    
    
    // Getters ��� ������ phoneNumber1 ��� PhoneNumber2
	public String getPhoneNumber1() {
		return phoneNumber1;
	}





	public String getPhoneNumber2() {
		return phoneNumber2;
	}





	
	
    // �������� abstract �������, ����������� ���� ���������� �� override
	public abstract void printInfo() ;
		
	
	
		
	
	
	

}
