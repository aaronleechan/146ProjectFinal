import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;



public class FrameWork extends JFrame {

	filePresenter presenter;
	
	ArrayList<String> result = new ArrayList<String>();
	ArrayList<String> resultValue = new ArrayList<String>();
	JPanel resultField;
	JPanel resultFieldColumn;
	JPanel resultField2;
	JLabel comeOut;
	JLabel comeOut2;
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
		//buttonKeys.add(new JLabel());
		
		// Title Print Out
		final JPanel titleField = new JPanel();
		titleField.setLayout(new GridLayout(0,column));
		titleField.setSize(100, 100);
			
		for(int i = 0; i < title.length; i++)
		{
			titleField.add(new JLabel(title[i]));
		}

		resultField = new JPanel();
		resultField.setLayout(new GridLayout(row,column));
        

		// Merge Sort weight
				JButton original = new JButton("Sort by id");
				buttonKeys.add(original);
				original.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
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
							resultField.add(comeOut);
						}
						
						theFrame.add(resultField, BorderLayout.CENTER);
						theFrame.setVisible(true);
						// TODO Auto-generated method stub
					}

				});

		// Height sort with quick Sort
		JButton quickSortButton = new JButton("Height Sort");
		buttonKeys.add(quickSortButton);
		quickSortButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
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
					resultField.add(comeOut);
				}		
				theFrame.add(resultField, BorderLayout.CENTER);
				theFrame.setVisible(true);
				// TODO Auto-generated method stub
			}
		});
		
		// Heart Rate Sort 
		JButton heapSortButton = new JButton("Heart Rate Sort");
		buttonKeys.add(heapSortButton);
		heapSortButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
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
					resultField.add(comeOut);
				}
				
				theFrame.add(resultField, BorderLayout.CENTER);
				theFrame.setVisible(true);
				// TODO Auto-generated method stub
			}
		});

		// Merge Sort weight
		JButton mergeSortButton = new JButton("Weight Sort");
		buttonKeys.add(mergeSortButton);
		mergeSortButton.addActionListener(new ActionListener() {
			

			@Override
			public void actionPerformed(ActionEvent e) {		
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
					resultField.add(comeOut);
				}		
				theFrame.add(resultField, BorderLayout.CENTER);
				theFrame.setVisible(true);
				// TODO Auto-generated method stub
			}
		});
		
		final JFrame nameFrame = new JFrame(" RESULT ");
		nameFrame.setLayout(new BorderLayout());
		final JLabel res = new JLabel();
			
		final JTextField searchBar = new JTextField("Enter Name", 10);
		buttonKeys.add(searchBar);
		JButton searchButton = new JButton("Search");
		buttonKeys.add(searchButton);
		searchButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
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
				System.out.println(binaryPeople.containString(matchResult));
				String[] sMatch = matchResult.split(" ");
				if( binaryPeople.containString(matchResult))
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
			resultField.add(comeOut);
		}
		
		JPanel sideBar = new JPanel();
		sideBar.setLayout(new BorderLayout(0,0));
		JScrollPane scrollPane = new JScrollPane(resultField);
		sideBar.add(scrollPane);
		
		theFrame.add(sideBar,BorderLayout.CENTER);
		theFrame.add(buttonKeys, BorderLayout.SOUTH);
		theFrame.add(titleField,BorderLayout.NORTH);		
		try{ theFrame.add(resultField, BorderLayout.CENTER);}
		catch(Exception e){	e.printStackTrace(); }
		theFrame.setSize(800, 900);
		theFrame.setVisible(true);

	}

}
