package com.sogou.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
  final static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  public static void main(String[] args) throws InterruptedException {
    
    Worker worker1=new Worker("zhang san", 5000);
    Worker worker2=new Worker("li si", 8000);
    Worker worker3=new Worker("rong b", 8000);
    CountDownLatch latch=new CountDownLatch(3);//两个工人的协作
    worker1.setLatch(latch);
    worker2.setLatch(latch);
    worker3.setLatch(latch);
    worker1.start();//
    worker2.start();//
    worker3.start();//
    latch.await();//等待所有工人完成工作
    System.out.println("all work done at "+sdf.format(new Date()));
  }
  
  
  static class Worker extends Thread{
    String workerName;
    int workTime;
    CountDownLatch latch;
    public Worker(String workerName ,int workTime){
      this.workerName=workerName;
      this.workTime=workTime;
    }
    public void run(){
      System.out.println("Worker "+workerName+" do work begin at "+sdf.format(new Date()));
      doWork();//工作了
      System.out.println("Worker "+workerName+" do work complete at "+sdf.format(new Date()));
      latch.countDown();//工人完成工作，计数器减一
      
    }
    
    public void setLatch(CountDownLatch latch) {
      this.latch = latch;
    }
    
    private void doWork(){
      try {
        Thread.sleep(workTime);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
  
  
}