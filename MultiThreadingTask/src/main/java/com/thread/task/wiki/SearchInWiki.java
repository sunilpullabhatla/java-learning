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

import org.json.JSONObject;


/**
 * Performs wiki calls using executor framework.
 * 
 * @author Sunil Pavan
 *
 */

public class SearchInWiki implements Callable<String> {

	
	private String searchKey;
	private static final String URL = "https://en.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro=&explaintext=&titles=";
	
	
	
	public SearchInWiki(String searchKey) {
		super();
		this.searchKey = searchKey;
	}

 
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
			
			result.append(sendGet(URL+searchKey));
			System.out.println(result);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			return result+"";
		}
		
	}
}
