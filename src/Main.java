package src;

import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    // int[] nums1 = {223, 333, 44, 1 , 2, 5};
    // int[] nums2 = {23, 3, 464, 13 , 29, 5};

    System.out.println("MergeSort: " + Arrays.toString(randomVectorGenerator(2, 100)));
    System.out.println("InserctionSort: " + Arrays.toString(randomVectorGenerator(11, 100)));
  }

  public static int[] randomVectorGenerator(int size, int maximumNumber) {
    if (size <= 0) return null;

    int[] vector = new int[size];

    for (int index = 0; index < size; index++) {
      vector[index] = (int) (Math.random() * maximumNumber);
    }

    return vector;
  }
  
}
