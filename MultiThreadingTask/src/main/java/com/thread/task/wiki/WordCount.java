package com.thread.task.wiki;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class WordCount {
	
	public static void main(String[] args) throws IOException {
		
		String dir = "/Users/sunilp/Downloads/wikiFiles/";
		
		Path intermediatePath = Paths.get(dir);
		if (Files.exists(intermediatePath)){
			Files.delete(intermediatePath);
		}
		Files.createFile(intermediatePath);
		
			try (Stream<Path> paths = Files.walk(Paths.get("dir"))) {
			    paths
			        .forEach(x -> { 
			        	if (!x.endsWith("wiki_output")){
			        		try {
				        		
				        		
								Stream<String> stream = Files.lines(x);
								List<String> list =  stream.map(w -> w.split("\\s+")).flatMap(Arrays::stream)
							            .collect(Collectors.toList());
								 
						       String file="";
						       for (String str : list ){
						    	   file = file+str+"\n";
						       }
								Files.write(intermediatePath,file.getBytes(), StandardOpenOption.APPEND );
								
								
				
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
				        	
			        	}
			        	
			        });
			    
			  //perform a word count now on the file
				;
				 
		        Map <String, Integer > wordCounter = Files.lines(intermediatePath)
			            .collect(Collectors.toList()).stream()
		            .collect(Collectors.toMap(w -> w.toLowerCase(), w -> 1, Integer::sum));
		 
		        Map <String, Integer > wordCounter1 = new TreeMap<String, Integer>(wordCounter);
		        String file1="";
		        for(Map.Entry<String, Integer> map : wordCounter1.entrySet()){
		        	file1=file1+map.getKey()+":"+map.getValue()+"\n";
		        }
		        Files.write(Paths.get("dir"), file1.getBytes(), StandardOpenOption.CREATE);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
