import java.util.ArrayList;
import java.util.List;


public class Lists {

	public static void main(String[] args) {
		List<String> l=new  ArrayList<String>();
		System.out.println("Total List size : "+ l.size());
		l.add("Test1"); //0th place 
		l.add("Test2"); //1st
		l.add("Test3"); //2nd
		l.add("Test4"); //3rd
		System.out.println("Total List size : "+ l.size());
		System.out.println("1st element : " + l.get(0));

	}

}
