
//Vinit Patel
//Assignment 4 - Minimum Cost Rod Cutting
//CMSC 401 - Fall 2018
//Due: 12/06/2018

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class cmsc401 {

  private static int rodSize;
  private static int[] rod;
  private static int[] cutLocations;

  private static ArrayList<Integer> v;

  private static int[][] dynamicMatrix;
  private static int[][] parent;

  public static void main(String[] args) {
    readInput();
    solve();
  }

  private static void solve() {
    v.add(rodSize);

    int n = v.size();

    cutLocations = new int[n];

    for (int i = 0; i < cutLocations.length; i++) {
      cutLocations[i] = v.get(i);
    }

    v.clear();

    dynamicMatrix = new int[n][n];
    parent = new int[n][n];
    answer = new int[n];

    for (int i = 0; i < n; i++) {
      dynamicMatrix[i] = new int[n];
      parent[i] = new int[n];
      for (int j = 0; j < n; j++) {
        dynamicMatrix[i][j] = -1;
      }
    }

    long lowestPrice = reccurance(0, n - 1);

    System.out.println(lowestPrice);
  }

  private static long reccurance(int l, int r) {
    if (l + 1 >= r)
      return 0;

    long q = (long) dynamicMatrix[l][r];

    if (q != -1)
      return q;

    q = Long.MAX_VALUE;

    int bestIndex = -1;
    long sum = 0;

    for (int i = l + 1; i < r; i++) {
      sum = reccurance(l, i) + reccurance(i, r) + cutLocations[r] - cutLocations[l];
      if (sum < q) {
        q = sum;
        bestIndex = i;
      }
    }

    parent[l][r] = bestIndex;

    return q;
  }

  private static void readInput() {
    Scanner scan = new Scanner(System.in);

    rodSize = scan.nextInt();

    rod = new int[rodSize];

    for (int i = 0; i < rodSize; i++) {
      rod[i] = i + 1;
    }

    int numOfCuts = scan.nextInt();
    cutLocations = new int[numOfCuts];

    for (int i = 0; i < cutLocations.length; i++) {
      cutLocations[i] = scan.nextInt();
    }

    v = new ArrayList<>();
    v.add(0);

    List<Integer> newList = new ArrayList<>();

    for (int x : cutLocations) {
      newList.add(x);
    }

    v.addAll(newList);

    scan.close();
  }
}