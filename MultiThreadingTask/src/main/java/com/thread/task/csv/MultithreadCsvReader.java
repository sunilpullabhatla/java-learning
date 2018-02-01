package com.thread.task.csv;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MultithreadCsvReader {

	/**Java multithreaded reading large files
	 * @param args
	 */
	public static void main(String[] args) {
		Thread t1=new Thread(new MultiThread(),"Thread1");
		t1.start();
	}

}


 class MultiThread implements Runnable{	
	private static BufferedReader br = null;
	
	private static volatile int recordCount=0;
	
	static{
		try {
			br = new BufferedReader(new FileReader("Multithreading_Task1_Books.csv"),10);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run() {
		
		synchronized (br) {
			
		
		
		String line = null;
		int count = 0;
		
			//System.out.println(Thread.currentThread().getName());
			StringBuilder sb = new StringBuilder();
			
			
				try {
					while((line = br.readLine()) != null) {
						if(count<10) {
							
							sb.append(line);
							sb.append("\n");
							count++;
							recordCount++;
						}else {
							
							Thread t = new Thread(new WriterThread(sb,recordCount));
							t.start();
							
							count = 0;
							//break;
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			
		}
		
		
	}
	
	
}
 
 
 class WriterThread implements Runnable{

	StringBuilder sb=null;
	 int recordCount=0;
	 
	 WriterThread(StringBuilder sb,int recordCount){
		 this.sb = sb;
		 this.recordCount = recordCount;
	 }
	 
	public void run() {
		// TODO Auto-generated method stub
		
	
				
				
				  try{    
			           FileWriter fw=new FileWriter("/Users/sunilp/Downloads/Files/"+recordCount+".txt");    
			          
			           fw.write(sb+"");   
			           
			           fw.close();    
			          }catch(Exception e){e.printStackTrace();}    
			        
			      
				
			}
	
 }
 