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
	JLabel comeOut;
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
		/////////////////////////////////////////////////////////////////////////
		resultField = new JPanel();
		resultField.setLayout(new GridLayout(row,column));
        
		
		
		// Merge Sort weight
				JButton original = new JButton("Sort by id");
				buttonKeys.add(original);
				original.addActionListener(new ActionListener() {
					

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
		nameFrame.setLayout(new FlowLayout());
		nameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final JLabel res = new JLabel();
		
		
		final JTextField searchBar = new JTextField("Enter Name", 10);
		buttonKeys.add(searchBar);
		JButton searchButton = new JButton("Search");
		buttonKeys.add(searchButton);
		searchButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				ArrayList<String> sou = new ArrayList<String>();
				BST binaryPeople = new BST();
				binaryPeople.build(hashingPeople.getPersonArray());
				
				matchResult = searchBar.getText();
				System.out.println(binaryPeople.contains(matchResult));
				String[] sMatch = matchResult.split(" ");
				if( binaryPeople.contains(matchResult))
				{
					System.out.println("come in");
					for(int i = 0; i < result.size(); i++)
					{
						String[] splitS = result.get(i).split(" "); 
						for(String s : splitS)
						{
							if(s.contains(sMatch[0]) || s.contains(sMatch[1]))
							{
								res.setText(result.get(i));
							}
						}						
					}					
				}
				nameFrame.add(res);
				nameFrame.setSize(300, 300);
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
		//try{ theFrame.add(resultField, BorderLayout.CENTER);}
		//catch(Exception e){	e.printStackTrace(); }
		
		theFrame.setSize(800, 900);
		theFrame.setVisible(true);

	}

}
