import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.Predicate;
import java.util.function.IntBinaryOperator;

public class Runner {
	public static void main(String[] args) {
//		Shape circle = new Circle();
//		circle.draw();
//		Shape circ = () -> System.out.println("Drawing a circle");
//		circ.draw();
//		circ = () -> System.out.println("Drawing a triangle");
//		circ.draw();
//		System.out.println();
//		IntBinaryOperator sum = (a,b) -> a+b;
//		Consumer <int[]> z = (a) ->{	for(int i : a)
//											System.out.println(sum.applyAsInt(i, 9/i));
//									};
//		Supplier<int[]> y = () -> new int[] {1,2,3,4,5,6,7,8,9,10};
//		z.accept(y.get());
//		
//		Function<Integer,String> x = (a) -> a+"";
//		
//		Predicate<Integer> w = (p) -> p < 90;
//		
		Laptop hpLaptop = new Laptop("HP",20,1);
		Laptop macBook = new Laptop("Apple",201111,0);
		Laptop dellLaptop = new Laptop("Dell",600,3);
		
		List<Laptop> laptops = new ArrayList<>();
		laptops.add(dellLaptop);
		laptops.add(macBook);
		laptops.add(hpLaptop);
		
		Collections.sort(laptops, (a,b)->-a.quality+b.quality);
		Collections.sort(laptops, Comparator.comparingDouble(a->a.getPrice()));
		System.out.println(laptops);
		Consumer<Integer > print = (a)->System.out.println("\n"+a);
		IntBinaryOperator sum = (a,b) -> a+b;
		print.accept(sum.applyAsInt(1, 2));
		Boolean flag1 = false;
		boolean flag2 = true;
		if (flag1 && flag2) {
			System.out.println("".equals(""));
		}
		BiPredicate<String,Integer> bi = (a,b) -> a.equals(b);
		System.out.println(bi.test("2121",2121));
	}
}
