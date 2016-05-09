import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class readFile {
	
	public ArrayList<String> storeAllList = new ArrayList<String>();

	//Only to read a file
	
	public void read() {
		
	
		// Read the file
				System.out.println("Read File");
				String filename = new Scanner(System.in).nextLine();
				
				try {    		
					Scanner in = new Scanner(new File(filename), "UTF-8");
					
					while(in.hasNextLine())
					{
						String line = in.nextLine();


						Scanner wd = new Scanner(line);
						while(wd.hasNext())
						{
							String nameFirst = wd.next();
							String nameLast = wd.next();
							String name = nameFirst + " " + nameLast;
							int wt = wd.nextInt();
							int ht = wd.nextInt();
							int age = wd.nextInt();
							String gender = wd.next();
							int hrt = wd.nextInt();

							Person p = new Person(name, age, wt, ht, gender, hrt);
							Hashing.hash(p); //person added to people array
						}

						wd.close();
					}
					in.close();			
						


					for(Person person: Hashing.people){
						if(person != null) storeAllList.add(person.toString());
					}
				

				} catch (FileNotFoundException e) {
				
					e.printStackTrace();
				}	  




		// TODO Auto-generated method stub	

	}
	
	
	public void readFile(){
		
		for(int i = 0; i < storeAllList.size(); i++)
		{
			System.out.println(storeAllList.get(i));
		}


	}


}
	


