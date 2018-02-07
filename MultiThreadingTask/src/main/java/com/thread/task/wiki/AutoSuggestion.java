package com.thread.task.wiki;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AutoSuggestion implements Runnable{
	
	public AutoSuggestion(String fileName) {
		super();
		this.fileName = fileName;
	}

	public String fileName;
	public static final String DestDir = "/Users/sunilp/Downloads/wikiFiles/";
	public String query = "java";
	
	
	
	public static void main(String[] args) {
		
		
		try {
			
			File directory = new File(DestDir);
	        //get all the files from a directory
	        File[] fList = directory.listFiles();
	        
	        ExecutorService executor = Executors.newFixedThreadPool(fList.length) ;
	        
	        for (File file : fList){
	        	
	        	executor.execute(new AutoSuggestion(file.getName()));
	          
	        }
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		  try {
			Files.lines(Paths.get(DestDir+this.fileName))
				.filter(x -> x.split("extract")[1].indexOf(query) != -1).forEach(x -> System.out.println(x.split("extract")[1]));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
