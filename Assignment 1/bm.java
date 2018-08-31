//Vinit Patel
import java.util.Scanner;

public class bm {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int nums = scan.nextInt();
		int[] numArray = new int[nums];
		for(int i = 0; i < nums; i++) {
			numArray[i] = scan.nextInt();
		}
		System.out.println(isMajorityElement(numArray,getCandidate(numArray)));
	}
	public static int getCandidate(int[] numArray) {
		int candidate = numArray[0];
		int counter = 1;
		for(int i = 1; i < numArray.length-1; i++) {
			if(numArray[i] == candidate) { counter++; }
			else { counter--; }
			if(counter == 0) {
				candidate = numArray[i];
				counter = 1;
			}
		}
		return candidate;
	}
	public static int isMajorityElement(int[] numArray, int candidate) {
		int counter = 0;
		for(int x : numArray) {
			if(x == candidate) { counter++; }
			if(counter > numArray.length/2) { return candidate; }
		}
		return -1;
	}
}