/**
 * 
 */
package p1;

/**
 * @author samuelbennett
 *
 */
public class helloworld {

	/**
	 * 
	 */
	
	int num;
	public helloworld(int num) {
		this.num = num;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		helloworld test = new helloworld(5);
		System.out.println("Hello World");
		System.out.println(test.num);
		test.num = 10;
		System.out.println(test.num);
		System.out.println("Hello");
	}

}
