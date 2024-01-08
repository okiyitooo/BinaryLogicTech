import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		var result = list.stream().filter(e-> e % 2 ==0).map(e->e/3).collect(Collectors.toList());
		System.out.println(result);
		//Making streams
		//Method 1
		Stream<Integer> stream =  list.stream();
		
		//Method 2
		int[] arr = {1,2,3,4,5};
		Arrays.stream(arr);
		
		//Method 3
		Stream .of(1,2,3,4,5);
		
		//Method 4
		Stream<Integer> intStream = Stream.iterate(0, x-> x+1).limit(9);
		
		intStream.forEach(e -> System.out.println(e));
		Random rand = new Random(129013);
		rand.nextInt();
		
		//Method 5
		Stream<Integer> randStream = Stream.generate(() -> (int)(Math.random()*1000)).limit(20);
		randStream.forEach(e->System.out.print(e+", "));
		
		randStream = Stream.generate(()-> (int)(Math.random()*100)).limit(100);
		System.out.println();
		
		HashMap<String,Long> hm= new HashMap<>(new ArrayList<>(List.of("Yo","hi","yo","hi","alfred","pizza","pizza")).stream().collect(Collectors.groupingBy(Function.identity(), HashMap::new,Collectors.counting())));
		System.out.println(hm);
		randStream.forEach(e->System.out.print(e+", "));
		
		List<String> nams = Arrays.asList("Kanaetochi","Tochi","Kanae","Peen","Neep");
		List<String> names = nams.stream().filter(name->name.matches(".*")).peek(System.out::println).collect(Collectors.toList());
		names.stream().forEach(System.out::println);
		
		Optional<Integer> poop = new ArrayList<Integer>(List.of(1,2,3,4,5,6,7,8,9,10)).stream().reduce((x,curr)->curr+x);
		System.out.println(poop.orElseGet(()->3));
	}

}
