import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class Set_Java {

	public static void main(String[] args) {
		Set<String> s=new HashSet<String>();
		s.add("1");
		s.add("2");
		System.out.println(s.size());
		s.add("2"); // duplicates are not added to a set
		//no indexing like in list
		//no order of elements
		System.out.println(s.size());
 // we can use an iterator to retrieve the elements in it, since there is no get method.
		
		Iterator<String> it= s.iterator();
		while(it.hasNext())
		System.out.println(it.next());
	}

}
