import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] argos = {"Hello","He","Hell"};
		Map<String,List<String>> map = new HashMap<>();
		for (String s : argos) {
			String C = "";
			for (char c : s.toCharArray()) {
				C+=c;
				map.putIfAbsent(C, new ArrayList<>());
				map.get(C).add(s);
			}
		}
		//
		System.out.println(map);
	}

}
