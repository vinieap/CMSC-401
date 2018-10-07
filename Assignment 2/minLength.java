//Vinit Patel

import java.util.Scanner;

public class minLength{

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberOfHouses = scan.nextInt();
        int[] houseArray = new int[numberOfHouses];
        int result;

        for (int i = 0; i < houseArray.length; i++) {
            houseArray[i] = scan.nextInt();
        }

        scan.close();

        quickSort(houseArray, 0, houseArray.length - 1);

        if (numberOfHouses % 2 == 0) {
            if ((houseArray[numberOfHouses / 2] + houseArray[(numberOfHouses / 2) - 1]) % 2 == 0) {
                result = (houseArray[numberOfHouses / 2] + houseArray[(numberOfHouses / 2) - 1]) / 2;
            } else {
                result = ((houseArray[numberOfHouses / 2] + houseArray[(numberOfHouses / 2) - 1]) / 2) + 1;
            }
        } else {
            result = houseArray[(numberOfHouses / 2) + 1];
        }

        System.out.println(result);
    }

    public static void quickSort(int[] arr, int low, int high) {
        int lowTemp = low;
        int highTemp = high;
        int pivot = arr[(lowTemp + highTemp) / 2];
        int tempNum;

        while (highTemp >= lowTemp) {
            while (pivot > arr[lowTemp]) {
                lowTemp++;
            }

            while (arr[highTemp] > pivot) {
                highTemp--;
            }

            if (highTemp >= lowTemp) {
                tempNum = arr[lowTemp];
                arr[lowTemp] = arr[highTemp];
                arr[highTemp] = tempNum;

                lowTemp++;
                highTemp--;
            }
        }

        if (highTemp > low) {
            quickSort(arr, low, highTemp);
        }
        if (high > lowTemp) {
            quickSort(arr, lowTemp, high);
        }
    }
}
