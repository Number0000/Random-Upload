
public class Student{
	String name;
	Person person;
	
	public Student(String name, Person person) {
		this.name = name;
		this.person = person;
	}
	
	void setName(String name){
		this.name = name;
	}
	String getName(){
		return name;
	}
	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", person=" + person + "]";
	}


}
