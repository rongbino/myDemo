package trong.alg;

import java.util.HashMap;

/**
 * 0 is no duplicate
 */
public class FindDuplicateInArray {
  public static void main(String[] args) {
    int[] arrays = {1,2,3,4,5,7,8,9,13,10,11,2};
    int[] sequenceArrays = {1,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17};

    // find the duplicate number in arrays
    FindDuplicateInArray findDuplicateInArray = new FindDuplicateInArray();
    System.out.printf("the only one duplicate number is %d \n", findDuplicateInArray.findDuplicateInArray(arrays));
    System.out.printf("the only one duplicate number in sequence arrays is %d \n", findDuplicateInArray.findDuplicateInSequenceArray(sequenceArrays));
  }

  /**
   * put the number into map
   * if the number is already contain in the map, then return it as duplicate number
   * @param arrays
   * @return
   */
  public int findDuplicateInArray(int[] arrays) {
    HashMap<Integer, Integer> map = new HashMap<>();
    if (arrays.length == 0 || arrays.length == 1) {
      return 0;
    }

    for (int i = 0; i < arrays.length; i++) {
      if (map.containsKey(arrays[i])) {
        return arrays[i];
      } else {
        map.put(arrays[i], i);
      }
    }
    return 0;
  }

  /**
   * The array is sequence array
   * 1. compare every node with next one
   * 2. If they are same, return as duplicate number
   * @param arrays
   * @return
   */
  public int findDuplicateInSequenceArray(int[] arrays) {
    if (arrays.length == 0 || arrays.length == 1) {
      return 0;
    }
    for (int i = 0; i < arrays.length - 1; i++) {
      int next = i + 1;
      if (arrays[i] == arrays[next]) {
        return arrays[i];
      }
    }
    // no duplicate
    return 0;
  }
}
