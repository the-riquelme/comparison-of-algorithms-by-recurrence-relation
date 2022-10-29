package src;

import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    int[] nums1 = {223, 333, 44, 1 , 2, 5};
    int[] nums2 = {23, 3, 464, 13 , 29, 5};

    System.out.println("MergeSort: " + Arrays.toString(Ordination.mergeSort(nums1)));
    System.out.println("InserctionSort: " + Arrays.toString(Ordination.inserctionSort(nums2)));
  }
  
}
