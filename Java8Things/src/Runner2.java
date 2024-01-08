
public class Runner2 {
	public static void main(String[] args) throws InterruptedException {
		System.out.println(true |false);
		Boolean b = Boolean.TRUE;
//		b.wait(10000);
		System.out.println(b);
		char c = (char)(65+131072);
		System.out.println(c);
		Byte byt = (byte)148;
		double d = 100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000d;
		long   l = 1000000000000000000l;
		System.out.println(byt);
		System.out.println(1.0/0.0);
//		System.out.println(-1.0/0.0);
		Float dub = (float) (-1.0/0.0);
		System.out.println(dub.getClass());
		System.out.println(-0.0);
		System.out.println(5/2);
		System.out.println(7/2);
	}
}
