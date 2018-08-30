//Vinit Patel
import java.util.*;
public class cmsc401 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lines = Integer.parseInt(scan.nextLine());
        ArrayList<Integer> answers = new ArrayList<>();
        for(int i = 0; i < lines; i++) {
            String[] currLine = scan.nextLine().substring(1).trim().split(" ");
            int[] values = new int[currLine.length];
            for(int j = 0; j < values.length-2; j++) {
                values[j] = Integer.parseInt(currLine[j]); 
	    }
            answers.add(values[Integer.parseInt(currLine[currLine.length-2])-1] * values[Integer.parseInt(currLine[currLine.length-1])-1]);
	}
        scan.close();
        for(int x : answers) {
            System.out.println(x); 
	} 
    } 
}
