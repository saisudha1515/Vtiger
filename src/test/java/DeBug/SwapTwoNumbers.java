package DeBug;

public class SwapTwoNumbers {
	public static void main(String[] args) {
		int a, b, temp;
		a = 10;
		b = 20;
		System.out.println("Value stored in a beore swapping :" + a);
		System.out.println("Value stored in b before swapping : " + b);
		temp = a;
		a = b;
		b = temp;
		System.out.println("Value stored in a after swapping :" + a);
		System.out.println("Value stored in b after swapping : " + b);

	}
}
