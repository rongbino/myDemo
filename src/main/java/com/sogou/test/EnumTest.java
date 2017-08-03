package com.sogou.test;

/**
 * Created by rongbin on 2017/6/2.
 */
public class EnumTest {
  
  public static enum Status {
    CREATED(1), RUNNING(2), FINISHED(3), FAILED(4), CANCELED(5), TIMEOUT(6), GONE(7), UPDATED(8), WRITEFINISHED(9);
    
    private int value;
    Status(int value) {this.value = value;}
    public int getValue() {return this.value;}
  }
   
  public static void main(String[] args) {
    System.out.println(Status.RUNNING.getValue());
    System.out.println(Status.FINISHED.toString());
    
    if (Status.CANCELED.toString().equals("CANCELED")) {
      System.out.println("aa");
    } else {
      System.out.println("bb");
    }
  }
}
