import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class filePresenter {
	FrameWork view;
	readFile fileReader;
	QuickSorter quickSortResult;
	MergeSorter mergeSortResult;
	Hashing hashingPeople;
	BST binaryPeople = new BST();
	public boolean resultCheck = false;
	public ArrayList<String> firstFileList = new ArrayList<String>();
	public ArrayList<String> mergeSortList = new ArrayList<String>();
	public ArrayList<String> quickSortList = new ArrayList<String>();
	public ArrayList<String> heapSorterList = new ArrayList<String>();
	public ArrayList<String> binaryPeopleList = new ArrayList<String>();
	public ArrayList<String> binaryList = new ArrayList<String>();
	
	//This is the class that will handle the model <-> UI communication
	void loadfileReader()
	{
		fileReader = new readFile();
		fileReader.read();	
		
		firstFileList = fileReader.storeAllList;
		
		mergeSortList = MergeSorter.mergeSort(hashingPeople.getPersonArray());
		quickSortList = QuickSorter.quicksort(hashingPeople.getPersonArray());
		heapSorterList = HeapSorter.heapSort(hashingPeople.getPersonArray());
	
		//hashingPeople.getPersonArray();
		
		binaryPeople.build(hashingPeople.getPersonArray());
		
		//resultCheck = binaryPeople.containString(view.matchResult);
		
		binaryList = binaryPeople.alphabetize();
		
//		for(int i = 0; i < binaryList.size(); i++)
//		{
//			System.out.println(binaryList.get(i) + " WHWH ");
//		}

	}
	
	void attachView(FrameWork view) {
        this.view = view;
    }

}
