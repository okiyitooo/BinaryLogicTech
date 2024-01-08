//import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class FindTheFirstRepeatingChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Character> C = new ArrayList<>();
		String s = "iafPNFJOHASKDJFKJASDFBKASKklasfhldbaskhfbdjaskbhfdasjhfkasdj";
		HashSet<Character> set = new HashSet<>();
//		List<Character> list = new ArrayList<>();
//		for (char c : s.toCharArray()) {
//		    list.add(c);
//		}
//		list.stream().forEach(e-> {
//			if (set.contains(e)) C.add(e);
//			else set.add(e);
//		});

		Optional<Character> cc = s.chars().mapToObj(c->(char)c)
				.collect(Collectors.groupingBy(Character::valueOf,Collectors.counting()))
				.entrySet()
				.stream()
				.filter(e->e.getValue()>1)
				.findFirst().map(Entry::getKey);
		
//		Arrays.stream
	}

}
