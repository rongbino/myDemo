package trong.alg;

import java.util.HashMap;

/**
 * the effect way to find two number pair from arrays add up to Z
 */
public class PairNumToZ {
  public static void main(String[] args) {
    int[] arrays = {1,3,5,6,7,8,3,5,3,5,7,9};
    PairNumToZ pairNumToZ = new PairNumToZ();
    int total = 12;
    int[] result = pairNumToZ.findPairToZ(arrays, total);
    System.out.printf("The pair to %d is %d and %d", total, result[0], result[1]);
  }

  public int[] findPairToZ(int[] arrays, int z) {
    // the result with two number
    int[] result = new int[2];

    HashMap<Integer, Integer> map = new HashMap<>();
    // input the int into map
    for (int i : arrays) {
      map.put(i, 0);
    }
    // find the pair
    int first = 0;
    int last = 0;
    for (int i = 0; i < arrays.length; i++) {
      if (z < arrays[i]) {
        continue;
      } else {
        first = arrays[i];
        last = z - first;
        if (map.containsKey(last)) {
          result[0] = first;
          result[1] = last;
          break;
        }
      }
    }
    return result;
  }
}
