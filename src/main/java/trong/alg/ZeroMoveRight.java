package trong.alg;

/**
 * input 1,2,3,0,4,5,0,6
 * output 1,2,3,4,5,6,0,0
 * 1, move the zero the right
 * 2, the non-zero number keep the order
 */
public class ZeroMoveRight {
  public static void main(String[] args) {
    int[] init = {0,1,2,4,5,0,6,7,0,8,0,0,0,1,1};
    // sort the zero to right
    ZeroMoveRight zeroMoveRight = new ZeroMoveRight();
    zeroMoveRight.pushZeroToEnd(init, init.length);
    for (int i = 0; i < init.length; i++) {
      System.out.printf(" %d", init[i]);
    }
  }

  public void pushZeroToEnd(int[] init, int count) {
    int index = 0;
    // copy the non-zero one by one
    for (int i = 0; i < count; i++) {
      if (init[i] != 0) {
        init[index++] = init[i];
      }
    }
    // fill zero in the rest position
    while (index < count) {
      init[index++] = 0;
    }
  }
}
