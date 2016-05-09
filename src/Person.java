public class Person {

	private int ID;
	private String name;
	private int ht;
	private int wt;
	private int age;
	private int hrt;
	private String gender;

	public Person(String name, int age, int wt, int ht, String gender, int hrt) {
		this.name = name;
		this.age = age;
		this.wt = wt;
		this.ht = ht;
		this.gender = gender;
		this.hrt = hrt;

	}

	public int getAge() {
		return this.age;
	}

	public int getWt() {
		return this.wt;
	}

	public int getHt() {
		return this.ht;
	}

	public int getHrt() {
		return this.hrt;
	}

	public String getName() {
		return this.name;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String toString(){
		return ID + " " + name + " " + age + " " + gender + " " + wt + " " + ht + " " + hrt;
	}

}
