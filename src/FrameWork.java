import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;



public class FrameWork extends JFrame {

	filePresenter presenter;
	
	ArrayList<String> result = new ArrayList<String>();
	ArrayList<String> resultValue = new ArrayList<String>();
	ArrayList<String> resultBinary = new ArrayList<String>();
	
	JPanel resultField;
	JPanel resultFieldColumn;
	JPanel resultField2;
	JLabel comeOut;
	JLabel comeOut2;
	JPanel sideBar;
	JScrollPane scrollPane;
	boolean checkName = false;
	Hashing hashingPeople;
	public String matchResult;
	
	String[] title = { "id ", "First Name", "Last Name", "age" , "gender" , "weight" , "height" , "heart rate"}; 

	public FrameWork(filePresenter filePresenter) {
		this.presenter = filePresenter;
		presenter.attachView(this);
		showGUI();

		// TODO Auto-generated constructor stub
	}

	private void showGUI() {
		presenter.loadfileReader();
		
		result = presenter.firstFileList;
		
		// Get column size
		final int column = title.length;
		final int row = result.size();

		final JFrame theFrame = new JFrame("FrameWork");
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theFrame.setLayout(new BorderLayout());

		final JPanel buttonKeys = new JPanel(new FlowLayout());
		
		// Title Print Out
		final JPanel titleField = new JPanel();
		titleField.setLayout(new GridLayout(0,column));
		titleField.setSize(100, 100);
			
		for(int i = 0; i < title.length; i++)
		{
			titleField.add(new JLabel(title[i]));
		}

		resultField = new JPanel();
		resultField.setLayout(new GridLayout(row,column,100,0));
		

		// Sort by Id, Original 
				
				JButton original = new JButton("Sort by id");
				buttonKeys.add(original);
				original.addActionListener(new ActionListener() {
					

					public void actionPerformed(ActionEvent e) {
						long startTime1 = System.currentTimeMillis();
						
						resultValue.clear();
						
						result = presenter.firstFileList;
						resultField.repaint();
						resultField = new JPanel();
				
						resultField.setLayout(new GridLayout(row,column));	
						
						for(int i = 0; i < result.size(); i++)
						{
							String[] s = result.get(i).split(" ");
							for(String sS : s)
							{
								resultValue.add(sS);
							}
						}
						
						for(int i = 0; i < resultValue.size(); i++)
						{
							comeOut = new JLabel();
							comeOut.setText(resultValue.get(i));
							comeOut.getBounds();
							resultField.add(comeOut);
							
						}						
						theFrame.add(resultField, BorderLayout.CENTER);
						theFrame.setVisible(true);
						// TODO Auto-generated method stub
						
						long stopTime1 = System.currentTimeMillis();
					    long elapsedTime1 = stopTime1 - startTime1;
					    System.out.println(elapsedTime1 + " Running time arraylist");
					}
					

				});
				
				
				
		// Sort by Name	
				JButton original2 = new JButton("Sort by Name");
				buttonKeys.add(original2);
				original2.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						long startTime2 = System.currentTimeMillis();
						
						resultValue.clear();
						
						result = presenter.binaryList;
						resultField.repaint();
						resultField = new JPanel();
				
						resultField.setLayout(new GridLayout(row,column));	
						
						for(int i = 0; i < result.size(); i++)
						{
							String[] s = result.get(i).split(" ");
							for(String sS : s)
							{
								resultValue.add(sS);
							}
						}
						
						for(int i = 0; i < resultValue.size(); i++)
						{
							comeOut = new JLabel();
							comeOut.setText(resultValue.get(i));
							comeOut.getBounds();
							resultField.add(comeOut);
							
						}
						
						theFrame.add(resultField, BorderLayout.CENTER);
						theFrame.setVisible(true);
						// TODO Auto-generated method stub
						
						
						long stopTime2 = System.currentTimeMillis();
					    long elapsedTime2 = stopTime2 - startTime2;
					    System.out.println(elapsedTime2 + " Running time binaryList");
					}

				});

		// Height sort with quick Sort
		JButton quickSortButton = new JButton("Height Sort");
		buttonKeys.add(quickSortButton);
		quickSortButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				long startTime3 = System.currentTimeMillis();
				
				resultValue.clear();
				
				result = presenter.quickSortList;
				resultField.repaint();
				resultField = new JPanel();
		
				resultField.setLayout(new GridLayout(row,column));	
				
				for(int i = 0; i < result.size(); i++)
				{
					String[] s = result.get(i).split(" ");
					for(String sS : s)
					{
						resultValue.add(sS);
					}
				}			
				for(int i = 0; i < resultValue.size(); i++)
				{
					comeOut = new JLabel();
					comeOut.setText(resultValue.get(i));
					comeOut.getBounds();
					resultField.add(comeOut);
				}		

				theFrame.add(resultField, BorderLayout.CENTER);
				theFrame.setVisible(true);
				// TODO Auto-generated method stub
				long stopTime3 = System.currentTimeMillis();
			    long elapsedTime3 = stopTime3 - startTime3;
			    System.out.println(elapsedTime3 + " Running time quickSort");
			}
		});
		
		// Heart Rate Sort 
		JButton heapSortButton = new JButton("Heart Rate Sort");
		buttonKeys.add(heapSortButton);
		heapSortButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				long startTime4 = System.currentTimeMillis();
				
				resultValue.clear();
				
				result = presenter.heapSorterList;
				resultField.repaint();
				resultField = new JPanel();
		
				resultField.setLayout(new GridLayout(row,column));	
				
				for(int i = 0; i < result.size(); i++)
				{
					String[] s = result.get(i).split(" ");
					for(String sS : s)
					{
						resultValue.add(sS);
					}
				}
				
				for(int i = 0; i < resultValue.size(); i++)
				{
					comeOut = new JLabel();
					comeOut.setText(resultValue.get(i));
				
					comeOut.getBounds();
					resultField.add(comeOut);
				}
				
				theFrame.add(resultField, BorderLayout.CENTER);
				theFrame.setVisible(true);
				// TODO Auto-generated method stub
				
				long stopTime4 = System.currentTimeMillis();
			    long elapsedTime4 = stopTime4 - startTime4;
			    System.out.println(elapsedTime4 + " Running time heapSortList");
			}
		});

		// Merge Sort weight
		JButton mergeSortButton = new JButton("Weight Sort");
		buttonKeys.add(mergeSortButton);
		mergeSortButton.addActionListener(new ActionListener() {
			
	

			public void actionPerformed(ActionEvent e) {
				long startTime5 = System.currentTimeMillis();
				
				resultValue.clear();
				

				result = presenter.mergeSortList;
				resultField.repaint();
				resultField = new JPanel();
				resultField.setLayout(new GridLayout(row,column));		
				for(int i = 0; i < result.size(); i++)
				{
					String[] s = result.get(i).split(" ");
					for(String sS : s)
					{
						resultValue.add(sS);
					}
				}	
				for(int i = 0; i < resultValue.size(); i++)
				{
					comeOut = new JLabel();
					comeOut.setText(resultValue.get(i));
					comeOut.setFont(new Font(comeOut.getFont().getName(),comeOut.getFont().getStyle(), 10));
					comeOut.getBounds();
					resultField.add(comeOut);
				}	

				theFrame.add(resultField, BorderLayout.CENTER);
				theFrame.setVisible(true);
				// TODO Auto-generated method stub
				long stopTime5 = System.currentTimeMillis();
			    long elapsedTime5 = stopTime5 - startTime5;
			    System.out.println(elapsedTime5 + " Running time mergeSort");
			}
		});
		
		final JFrame nameFrame = new JFrame(" RESULT ");
		nameFrame.setLayout(new BorderLayout());
			
		final JTextField searchBar = new JTextField("Enter Name", 10);
		buttonKeys.add(searchBar);
		JButton searchButton = new JButton("Search");
		buttonKeys.add(searchButton);
		searchButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				long startTime6 = System.currentTimeMillis();
				
				boolean first = false;
				boolean second = false;
							
				resultField2 = new JPanel();
					
				ArrayList<String> j = new ArrayList<String>();
				
				 JPanel titleField2 = new JPanel();
				titleField2.setLayout(new GridLayout(0,column));
				titleField2.setSize(100, 100);
		
				for(int i = 0; i < title.length; i++)
				{
					titleField2.add(new JLabel(title[i]));
				}
					
				ArrayList<String> sou = new ArrayList<String>();
				BST binaryPeople = new BST();
				binaryPeople.build(hashingPeople.getPersonArray());
				int count = 0;
				matchResult = searchBar.getText();
				System.out.println(binaryPeople.contains(matchResult));
				String[] sMatch = matchResult.split(" ");
				
				long stopTime6 = System.currentTimeMillis();
			    long elapsedTime6 = stopTime6 - startTime6;
			    System.out.println(elapsedTime6 + " Running time Binary Search");
			    
				if( binaryPeople.contains(matchResult))
				{

					for(int i = 0; i < result.size(); i++)
					{
						String[] splitS = result.get(i).split(" "); 
						for(String s : splitS)
						{
							if(s.contains(sMatch[0]))
							{
								first = true;
							}
							if(s.contains(sMatch[1]))
							{
								second = true;
							}
							if(first && second)
							{
								first = false; second = false;
								String[] rest = result.get(i).split(" ");
								String out="";
								for(String abc : rest)
								{
									j.add(abc);
								}
								count++;
							}
						}						
					}		
					int row2 = count;
					resultField2.setLayout(new GridLayout(count,column));
					
					for(int i = 0; i < j.size(); i++)
					{
						comeOut2 = new JLabel();
						comeOut2.setText(j.get(i));
						resultField2.add(comeOut2);
					}
				}
				else
				{
					comeOut2 = new JLabel();
					comeOut2.setText("There is no match found");
					resultField2.add(comeOut2);
					resultField2.setPreferredSize(getPreferredSize());
				}
				nameFrame.add(titleField2,BorderLayout.NORTH);
				nameFrame.add(resultField2,BorderLayout.CENTER);
				nameFrame.setSize(400, 1000);
				nameFrame.pack();
				nameFrame.setVisible(true);
			}
		});
		
		
		for(int i = 0; i < result.size(); i++)
		{
			String[] s = result.get(i).split(" ");
			for(String sS : s)
			{
				resultValue.add(sS);
			}
		}
		
		for(int i = 0; i < resultValue.size(); i++)
		{
			comeOut = new JLabel(resultValue.get(i));
			comeOut.getBounds();
			resultField.add(comeOut);
		}
		

		theFrame.add(buttonKeys, BorderLayout.SOUTH);
		theFrame.add(titleField,BorderLayout.NORTH);		
		try{ theFrame.add(resultField, BorderLayout.CENTER);}
		catch(Exception e){	e.printStackTrace(); }
		theFrame.setSize(800, 900);
		theFrame.pack();
		theFrame.setVisible(true);

	}

}
