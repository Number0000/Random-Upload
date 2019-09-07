
public class Book extends Student{
	String bookName;
	
	public Book(String bookName, String name, Person person){
		super(name, person);
		this.bookName = bookName;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	@Override
	public String toString() {
		return (super.toString() + "Book [bookName=" + bookName + "]");
	}
	
}
