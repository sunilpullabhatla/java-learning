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


/**
 * Perfoms word count by merging all words into single file.
 * 
 * @author Sunil Pavan
 *
 */

public class WordCounter {
	
	public static void main(String[] args) throws IOException {
		
		String dir = "/Users/sunilp/Downloads/wikiFiles";
	
		
		Path tempFile = Paths.get(dir+"/wiki_count/wiki_temp.txt");
		if (Files.exists(tempFile)){
			Files.delete(tempFile);
		}
		Files.createFile(tempFile);
		
			try (Stream<Path> paths = Files.walk(Paths.get(dir+"/wiki_result"))) { paths.forEach(x -> { 
			        	if (!x.endsWith("wiki_result")){
			        		try {
				        			Stream<String> stream = Files.lines(x);
								List<String> list =  stream.map(k -> k.split("\\s+")).flatMap(Arrays::stream).collect(Collectors.toList());
								 
						       String file="";
						       for (String str : list ){
						    	   file = file+str+"\n";
						       }
								Files.write(tempFile,file.getBytes(), StandardOpenOption.APPEND );
								
				             } catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
				        	
			        	}
			        	
			        });
			  
			 
		        Map <String, Integer > counter = Files.lines(tempFile).collect(Collectors.toList()).stream()
		            .collect(Collectors.toMap(k -> k.toLowerCase(), k -> 1, Integer::sum));
		 
		        Map <String, Integer > wordCounter = new TreeMap<String, Integer>(counter);
		        
		        String Actualfile="";
		        for(Map.Entry<String, Integer> map : wordCounter.entrySet()){
		        	Actualfile=Actualfile+map.getKey()+":"+map.getValue()+"\n";
		        }
		        Files.write(Paths.get(dir+"/wiki_count/wordcount.txt"), Actualfile.getBytes(), StandardOpenOption.CREATE);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
