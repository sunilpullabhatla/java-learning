package com.thread.task.csv;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;

public class CsvRecursiveAction extends RecursiveAction {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    private static final int THRESHOLD = 10;
    private List<String> lines =  new ArrayList<String>();
    private int linesPerFile=0;
 
    private static Logger logger = 
      Logger.getAnonymousLogger();
 
    public CsvRecursiveAction(List<String> lines,int linesPerFile) {
        this.lines = lines;
        this.linesPerFile = linesPerFile;
    }
 
    @Override
    protected void compute() {
        if (lines.size() > THRESHOLD) {
            ForkJoinTask.invokeAll(createSubtasks());
        } else {
        	write(lines);
        }
    }
 
    private List<CsvRecursiveAction> createSubtasks() {
        List<CsvRecursiveAction> subtasks = new ArrayList<CsvRecursiveAction>();
 
        List<String> partOne = lines.subList(0, lines.size() / 2);
        List<String> partTwo = lines.subList(lines.size()/ 2, lines.size());
 
        subtasks.add(new CsvRecursiveAction(partOne,partOne.size()));
        subtasks.add(new CsvRecursiveAction(partTwo,partTwo.size()));
 
        return subtasks;
    }
 
    private void write(List<String> lines) {
    	
    	try{    
        FileWriter fw=new FileWriter("/Users/sunilp/Downloads/Files/"+ThreadLocalRandom.current().nextLong()+".txt");    
        for(String s: lines) {
        fw.write(s);
        fw.write("\n");
        
        }
        fw.close();    
       }catch(Exception e){e.printStackTrace();}    
     }
}