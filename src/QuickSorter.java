import java.util.ArrayList;

// Quicksorting by the heights
public class QuickSorter {

	// change Comparable[] to Person[]
	public  static ArrayList<String> quicksort(Person[] a) {
		Person[] result = a.clone();
		quicksort(result, 0, result.length - 1);
		
	    ArrayList<String> ResultList = new ArrayList<String>();
		for(Person p: result) ResultList.add(p.toString());
		return ResultList;
	}
	private static final int CUTOFF = 10;
	
	// Swapping two people if their heights are contradict
	public static final void swapReferences(Person[] a, int index1, int index2) {
		Person tmp = a[index1];
		a[index1] = a[index2];
		a[index2] = tmp;
	}

	 // Internal quicksort method that makes recursive calls. Uses
	 // median-of-three partitioning and a cutoff of 10.
	private static void quicksort(Person[] a, int low, int high) {
		if (low + CUTOFF > high)
			insertionSort(a, low, high);
		else {
			// Sort low, middle, high
			int middle = (low + high) / 2;
			// if (a[middle].compareTo(a[low]) < 0)
			if (a[middle].getHt() < a[low].getHt())
				swapReferences(a, low, middle);
			//if (a[high].compareTo(a[low]) < 0) 
			if (a[high].getHt() < a[low].getHt())
				swapReferences(a, low, high);
			//if (a[high].compareTo(a[middle]) < 0) 
			if (a[high].getHt() < a[middle].getHt())
				swapReferences(a, middle, high);

			// Place pivot at position high - 1
			swapReferences(a, middle, high - 1);
			Person pivot = a[high - 1];

			// Begin partitioning
			int i, j;
			for (i = low, j = high - 1;;) {
				//while (a[++i].compareTo(pivot) < 0) 
				while(a[++i].getHt() < pivot.getHt())
					;
				//while (pivot.compareTo(a[--j]) < 0) 
				while(pivot.getHt() < a[--j].getHt())
					;
				if (i >= j)
					break;
				swapReferences(a, i, j);
			}

			// Restore pivot
			swapReferences(a, i, high - 1);

			quicksort(a, low, i - 1); // Sort small elements
			quicksort(a, i + 1, high); // Sort large elements
		}
	}

     // Internal insertion sort routine for subarrays
     // that is used by quicksort.
    private static void insertionSort( Person[ ] a, int low, int high )
    {
        for( int p = low + 1; p <= high; p++ )
        {
            Person tmp = a[ p ];
            int j;

            //for( j = p; j > low && tmp.compareTo( a[ j - 1 ] ) < 0; j-- ) 
            for( j = p; j > low && tmp.getHt() < a[ j - 1 ].getHt(); j--)
                a[ j ] = a[ j - 1 ];
            a[ j ] = tmp;
        }
    }
}
