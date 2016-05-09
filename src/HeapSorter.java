import java.util.ArrayList;
import java.util.Arrays;

public class HeapSorter
{
	/**
	 * Returns index of the left child
	 */
	private static int leftChild(int i) {
		return 2 * i + 1;
	}

	/**
	 * Percolates down
	 */
	private static void percDown(Person[] a, int i, int n) {
		int child;
		Person tmp;

		for (tmp = a[i]; leftChild(i) < n; i = child) {
			child = leftChild(i);
			if (child != n - 1 && a[child].getHrt() < a[child + 1].getHrt())
				child++;
			if (tmp.getHrt() < a[child].getHrt())
				a[i] = a[child];
			else
				break;
		}
		a[i] = tmp;
		//System.out.println(Arrays.toString(a));
	}
	
	public static ArrayList<String> heapSort(Person[] orArray)
	{
		Person[] clone = orArray.clone();
		sort(clone);
		ArrayList<Person> clone2 = new ArrayList<Person>(Arrays.asList(clone));
		ArrayList<String> strings = new ArrayList<String>();
		for (Person p: clone2)
		{
			String person = p.toString();
			strings.add(person);
		}
		return strings;
	}

	/**
	 * Basic heap sort
	 */
	public static void sort(Person[] a) {
		for (int i = a.length / 2; i >= 0; i--)
			/* buildHeap */
			percDown(a, i, a.length);
		for (int i = a.length - 1; i > 0; i--) {
			swapReferences(a, 0, i); /* deleteMax */
			percDown(a, 0, i);
		}
	}
	
	public static void swapReferences(Person[] a, int i, int n)
	{
		Person tmp = a[i];
        a[i] = a[n];
        a[n] = tmp;
	}

}
