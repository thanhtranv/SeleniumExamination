package dataobjects;

public class InformationAccount {
	public String gender;
	public String customerFirstName;
	public String customerLastName;
	public String email;
	public String password;
	public String dateOfBirth;
	public String monthOfBirth;
	public String yearOfBirth;
	public boolean receiveOffer;
	public String firstName;
	public String lastName;
	public String address;
	public String city;
	public String state;
	public String postCode;
	public String country;
	public String phoneMobile;
	public String alias;
	
	public InformationAccount() {
		
	}
	
	public InformationAccount(String _gender, String _customerFirstName, String _customerLastName, String _email, String _password, String _dateOfBirth, String _monthOfBirth, String _yearOfBirth, boolean _receiveOffer, String _firstName, String _lastName, String _address, String _city, String _state, String _postCode, String _country, String _phoneMobile, String _alias) {
		super();
		this.gender = _gender;
		this.customerFirstName = _customerFirstName;
		this.customerLastName = _customerLastName;
		this.email = _email;
		this.password = _password;
		this.dateOfBirth = _dateOfBirth;
		this.monthOfBirth = _monthOfBirth;
		this.yearOfBirth = _yearOfBirth;
		this.receiveOffer = _receiveOffer;
		this.firstName = _firstName;
		this.lastName = _lastName;
		this.address = _address;
		this.city = _city;
		this.state = _state;
		this.postCode = _postCode;
		this.country = _country;
		this.phoneMobile = _phoneMobile;
		this.alias = _alias;
	}
}
