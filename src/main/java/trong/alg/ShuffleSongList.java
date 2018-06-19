package trong.alg;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Random;

public class ShuffleSongList {
  public static void main(String[] args) throws JsonProcessingException{
    // init the array
    int[] intArray = {1,2,3,4,5,6,7,8};
    ShuffleSongList shuffleSongList = new ShuffleSongList();
    // print the init array
    for (int i:intArray) {
      System.out.print(i + " ");
    }

    System.out.println();
    shuffleSongList.shuffleArray(intArray, intArray.length);
    // print the shuffle array
    for (int i : intArray) {
      System.out.print(i + " ");
    }

    HashMap<String, Integer> count = new HashMap<>();
    count.put("key", 1);
    ObjectMapper mapper = new ObjectMapper();
    System.out.println(mapper.writeValueAsString(count));
  }

  public int[] shuffleArray(int[] array, int length) {
    Random random = new Random();
    for (int i = length-1; i > 0; i--) {
      int index = random.nextInt(i);
      int tmp = array[index];
      array[index] = array[i];
      array[i] = tmp;
    }
    return array;
  }
}
