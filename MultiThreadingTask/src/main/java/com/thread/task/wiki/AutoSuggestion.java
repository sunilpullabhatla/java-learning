package com.thread.task.wiki;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.propertyloader.PropertyLoader;

/**
 * AutoSuggest the given word
 * 
 * @author Sunil Pavan
 *
 */


public class AutoSuggestion {
	
	public AutoSuggestion(String splitter) {
		super();
		this.splitter = splitter;
	}

	public String splitter;
	public static final String DestDir = PropertyLoader.prop.getProperty("wikiIndexed");
	public static String query = "java";
	
	
	
	public static void main(String[] args) {
		
		AutoSuggestion as = new AutoSuggestion(":");
		as.wordSuggest();
	}
	
	public void wordSuggest() {
		try {
			Files.lines(Paths.get(DestDir)).filter(x -> x.split(splitter)[0].indexOf(query) != -1).forEach(x -> System.out.println(x.split(":")[0]));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
