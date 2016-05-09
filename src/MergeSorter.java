//Mergesorting weights
import java.util.*;
public class MergeSorter {
	
		
	public static ArrayList<String> mergeSort(Person[] orArray)

	{
		Person[] clone = orArray.clone();
		sort(clone);
		ArrayList<Person> clone2 = new ArrayList<Person>(Arrays.asList(clone));
		ArrayList<String>strings = new ArrayList<String>();
		for (Person p: clone2)
		{
			String person = p.toString();
			strings.add(person);
		}
		return strings;
	}
	
	// sorting step of merge sort
	public static void sort(Person[] array) {
		if (array.length <= 1) {
			return;
		}
		Person[] first = new Person[array.length / 2];
		Person[] second = new Person[array.length - first.length];
		for (int i = 0; i < first.length; i++) {
			first[i] = array[i];
		}
		for (int i = 0; i < second.length; i++) {
			second[i] = array[first.length + i];
		}
		sort(first);
		sort(second);
		merge(first, second, array);
	}

	// merging step of merge sort
	public static void merge(Person[] array1, Person[] array2, Person[] temp) {
		int iArray1 = 0;
		int iArray2 = 0;
		int iTemp = 0;
		while (iArray1 < array1.length && iArray2 < array2.length) {
			if (array1[iArray1].getWt() < array2[iArray2].getWt()) {
				temp[iTemp] = array1[iArray1];
				iArray1++;
			} else {
				temp[iTemp] = array2[iArray2];
				iArray2++;
			}
			iTemp++;
		}
		// copy the remains
		while (iArray1 < array1.length) {
			temp[iTemp] = array1[iArray1];
			iArray1++;
			iTemp++;
		}
		while (iArray2 < array2.length) {
			temp[iTemp] = array2[iArray2];
			iArray2++;
			iTemp++;
		}

	}
	

}
