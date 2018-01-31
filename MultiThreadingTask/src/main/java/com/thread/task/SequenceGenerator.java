package com.thread.task;

public class SequenceGenerator implements Runnable{

	
	
	
	
	public static void main(String[] args)  {
		
		// TODO Auto-generated method stub
		try {
		Thread t1 = new Thread(new SequenceGenerator());
		Thread t2 = new Thread(new SequenceGenerator());
		
		t1.start();
		t1.join();
		t2.start();
		}catch(Exception e) {
			e.printStackTrace();
		}
	

	}

	public void run() {
		// TODO Auto-generated method stub
		for(int i=1;i<=10;i++) {
			System.out.println(Thread.currentThread()+"--->"+i);
		}
	}

}
