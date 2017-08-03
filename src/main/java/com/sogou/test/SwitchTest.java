package com.sogou.test;

/**
 * Created by rongbin on 2017/6/30.
 */
public class SwitchTest {

  public static void main(String[] args) {
    SwitchTest.printMsg(1);
    SwitchTest.printMsg(2);
    SwitchTest.printMsg(3);
  }

  public static void printMsg(int i) {
    switch (i) {
      case 1:
      case 2:
        System.out.println(i);
        break;
      default:
        System.out.println("default");
    }
  }
}
