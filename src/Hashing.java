import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Hashing {
	public static Person[] people = new Person[10];
	private static int count = 0;
	
	public static Person[] hash(Person p) {
		// hashcode formula!
		
		if(count == people.length){
			Person[] P_Resize = new Person[people.length*2]; 
			
			for(int i=0; i<people.length; i++)
			{
				P_Resize[i] = people[i];
			}
			
			people = P_Resize;
		}
		
		int code = (p.getName().length() 
					+ p.getAge() + p.getHrt() 
					+ p.getHt() + p.getWt()) % people.length;
		//linear probe!
		while(people[code] != null){
			if(code == people.length-1)
				code = 0;
			else
				code++;
		}
		people[code] = p;
		p.setID(code);
		count++;
		
		return people;
	}
	
	public static Person[] getPersonArray(){
		List<Person> list = new ArrayList<Person>(Arrays.asList(people));
		list.removeAll(Collections.singleton(null));
		return list.toArray(new Person[list.size()]);
	}
}
