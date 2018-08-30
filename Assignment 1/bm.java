import java.util.Scanner;
import java.io.File;

public class bm {
	public static void main(String[] args) throws Exception {
		File inputFile = new File("numArrays.txt");
		Scanner scan = new Scanner(inputFile);
		String[] strArray;
		int[] numArray;

		while(scan.hasNextLine()) {
			strArray = scan.nextLine().split(" ");
			numArray = new int[strArray.length];
			for(int i = 0; i < numArray.length; i++) {
				numArray[i] = Integer.parseInt(strArray[i]);
			}
			int candidate = getCandidate(numArray);
			System.out.println(candidate + " is the majority element: " + isMajorityElement(numArray, candidate));
			System.out.println("----------------------------------------------------------------------");
		}
	}
	public static int getCandidate(int[] numArray) {
		int candidate = numArray[0];
		int counter = 1;

		for(int i = 1; i < numArray.length-1; i++) {
			if(numArray[i] == candidate) {
				counter++;
			}
			else {
				counter--;
			}
			if(counter == 0) {
				candidate = numArray[i];
				counter = 1;
			}
		}
		return candidate;
	}
	public static boolean isMajorityElement(int[] numArray, int candidate) {
		int counter = 0;
		for(int x : numArray) {
			if(x == candidate) {
				counter++;
			}
			if(counter > numArray.length/2) {
				return true;
			}
		}
		return false;
	}
}