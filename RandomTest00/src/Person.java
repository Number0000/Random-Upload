
public class Person{
	String country;
	
	public Person(String person) {
		this.country = person;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Person [country=" + country + "]";
	}
	

}
