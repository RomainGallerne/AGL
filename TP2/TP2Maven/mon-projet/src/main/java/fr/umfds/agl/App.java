package fr.umfds.agl;// dépend de votre groupId
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;

public class App {
	public static void main( String[] args ){
		ArrayListValuedHashMap<String, Integer> map=new
		ArrayListValuedHashMap<>();

		map.put("clef1", 1);
		map.put("clef1", 2);
		map.put("clef2", 3);
		System.out.println(map);
	}
}
