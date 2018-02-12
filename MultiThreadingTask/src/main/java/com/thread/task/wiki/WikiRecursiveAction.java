package com.thread.task.wiki;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;


/**
 * Writes the result of wiki calls into files by using Fork & Join RecursiveAction.
 * 
 * @author Sunil Pavan
 *
 */

public class WikiRecursiveAction extends RecursiveAction {
 
 
	private static final long serialVersionUID = 1L;
	
    private static final int THRESHOLD = 1;
    private List<String> lines =  new ArrayList<String>();
    private int linesPerFile=0;
    private static final String DestDir = "/Users/sunilp/Downloads/wikiFiles/wiki_result/";
    
    private static Logger logger = 
      Logger.getAnonymousLogger();
 
    public WikiRecursiveAction(List<String> lines,int linesPerFile) {
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
 
    private List<WikiRecursiveAction> createSubtasks() {
        List<WikiRecursiveAction> subtasks = new ArrayList<WikiRecursiveAction>();
 
        List<String> partOne = lines.subList(0, lines.size() / 2);
        List<String> partTwo = lines.subList(lines.size()/ 2, lines.size());
 
        subtasks.add(new WikiRecursiveAction(partOne,partOne.size()));
        subtasks.add(new WikiRecursiveAction(partTwo,partTwo.size()));
 
        return subtasks;
    }
 
    private void write(List<String> lines) {
    	
    	try{    
        FileWriter fw=new FileWriter(DestDir+ThreadLocalRandom.current().nextLong()+".txt");    
        for(String s: lines) {
        fw.write(s);
        fw.write("\n");
        
        }
        fw.close();    
       }catch(Exception e){e.printStackTrace();}    
     }
}