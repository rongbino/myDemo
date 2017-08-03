package com.sogou.test;

/**
 * Created by rongbin on 2017/6/16.
 */
public class ExceptionTest {
  
  public static void main(String[] args) {
    try {
      ExceptionTest.exception(1);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      ExceptionTest.exception(2);
    }
  }
  
  public static void exception(int i) {
    throw new RuntimeException("I am wrong " + i);
  }
}
