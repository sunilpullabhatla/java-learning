package com.thread.task.wiki;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Callable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchInWiki implements Callable<String> {

	
	private String searchKey;
	
	
	
	
	public SearchInWiki(String searchKey) {
		super();
		this.searchKey = searchKey;
	}

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		 Pattern regexp = Pattern.compile("^\\\\N\\t(\\d)+\\t(\\w)+");
		    Matcher matcher = regexp.matcher("");

		    Path path = Paths.get("");
		    try (
		      BufferedReader reader = Files.newBufferedReader(path);
		      LineNumberReader lineReader = new LineNumberReader(reader);
		    ){
		      String line = null;
		      while ((line = lineReader.readLine()) != null) {
		        matcher.reset(line); //reset the input
		        if (!matcher.find()) {
		          String msg = "Line " + lineReader.getLineNumber() + " is bad: " + line;
		          throw new IllegalStateException(msg);
		        }
		      }      
		    }    
		    catch (IOException ex){
		      ex.printStackTrace();
		    }
		
		
		
		
		String searchKey = "Java";
		
		try {
			
			StringBuffer result = sendGet("https://en.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro=&explaintext=&titles="+searchKey);
			System.out.println(result);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} */
 
	private static StringBuffer sendGet(String url) throws Exception {

		

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");


		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		return response;

	}

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		
		StringBuffer result = new StringBuffer();
		
		try {
			
			result.append(sendGet("https://en.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro=&explaintext=&titles="+searchKey));
			System.out.println(result);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			return result+"";
		}
		
	}
}
