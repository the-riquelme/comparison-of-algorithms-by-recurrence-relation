package src;

public class Main {

  public static void main(String[] args) {
    int[] nums1 = randomVectorGenerator(5, 100);
    // int[] nums2 = randomVectorGenerator(5, 100);

    // System.out.println("MergeSort: " + );
    System.out.println("InserctionSort: " + Ordination.inserctionSort(nums1));
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
