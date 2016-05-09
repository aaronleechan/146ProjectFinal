import java.util.Comparator;

public class BST implements Comparator<String> {
	
	public BST(){	root = null;	}
	
	//generic node class
	class Node<Person>{
		Person ele;	Node<Person> left;	Node<Person> right;
		// inner class constructor
		Node(Person element){
			this(element, null, null);
		}

		// inner class constructor
		Node(Person element, Node<Person> lt, Node<Person> rt){
			ele = element;	left = lt;	right = rt;
		}
	}
	
	public Node<Person> root(){
		return this.root;
	}
	
	public boolean isEmpty(){
		return root == null;
	}
	
	public boolean containString(String x)
	{
		return contains(x, root);
			
	}
	
	public boolean contains(Person x){
		return contains(x.getName(), root);
	}
	/*
	 * contains method returns true when Person's name exists in tree
	 */
	private boolean contains(String x, Node<Person> t){
		if(t == null)	return false;
		//compares x name to name of t
		int comparison = compare(x, t.ele.getName());
		
		if(comparison < 0)	return contains(x, t.left);
		else if(comparison > 0)		return contains(x, t.right);
		else	return true;
	}

	public int compare(String x, String anotherString){
		int i=0; int j=0;
		while(i < x.length() && j < anotherString.length()){
			if(x.charAt(i) < anotherString.charAt(j))	return -1;
			else if(x.charAt(i) > anotherString.charAt(j))	return 1;
			i++; j++;
		}
		 //if x shorter than aStr
		if(x.length() < anotherString.length())		return -1;
		else if(x.length() > anotherString.length())	return 1;
		return 0;
	}
	
	//instantiate root, count
	private Node<Person> root;
	
	//insert method
	public void insert(Person x)
	{
		root = insert(x, root);
	}
	
	private Node<Person> insert(Person x, Node<Person> t)
	{
		if(t == null)
			return new Node<Person>(x, null, null);
		//compares x name to name of t
		int comparison = compare(x.getName(), t.ele.getName());
		
		if(comparison < 0)
			t.left = insert(x, t.left);
		else if(comparison > 0)
			t.right = insert(x, t.right);
		else{;}
		
		return t;
	}
	
	public void build(Person[] ppl){
		for(Person p : ppl){
			insert(p);
		}
	}
	
//		for testing	
//	public static void main(String[] args){
//		BST b = new BST();
//		b.insert("Penny");
//		b.insert("Penne");
//		b.insert("Penna");
//		System.out.print(b.contains("Penna"));
//	}
}