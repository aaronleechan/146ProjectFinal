import java.util.*;
public class Tests 
{
	public static void main(String[] args)
	{
		Person[] people = new Person[5];
		//Person(String name, int age, int wt, int ht, String gender, int hrt)
		people[0] = new Person("A", 18, 60, 170, "male", 15);
		people[1] = new Person("B", 26, 55, 155, "female", 90);
		people[2] = new Person("C", 33, 80, 165, "female", 22);
		people[3] = new Person("D", 11, 40, 140, "male", 38);
		people[4] = new Person("F", 80, 49, 145, "female", 49);
		
		Person[] temp1 = people.clone();
		ArrayList<String> list1 = MergeSorter.mergeSort(temp1);
		for (int i = 0; i < list1.size(); i++)
		{
			System.out.println(list1.get(i));
		}
	}

}
