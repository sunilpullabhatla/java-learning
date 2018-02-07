package com.thread.task.wiki;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AutoSuggestion {
	
	public AutoSuggestion(String fileName) {
		super();
		this.fileName = fileName;
	}

	public String fileName;
	public static final String DestDir = "/Users/sunilp/Downloads/wikiFiles/wiki_count/wordcount.txt";
	public static String query = "java";
	
	
	
	public static void main(String[] args) {
		
		try {
			Files.lines(Paths.get(DestDir)).filter(x -> x.split(":")[0].indexOf(query) != -1).forEach(x -> System.out.println(x.split(":")[0]));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
