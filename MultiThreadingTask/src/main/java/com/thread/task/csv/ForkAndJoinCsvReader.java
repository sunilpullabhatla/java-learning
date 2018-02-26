package com.thread.task.csv;

import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ForkJoinPool;

import com.propertyloader.PropertyLoader;


/**
 * Invoking & Testing CSV reader using Fork & join 
 * 
 * @author Sunil Pavan
 *
 */

public class ForkAndJoinCsvReader {

	
	public static void main(String[] args)  {
		
		try{
		long startTime = System.currentTimeMillis();
		
		List<String> lines = Files.readAllLines(Paths.get(PropertyLoader.prop.getProperty("fileName")));
		
		ForkJoinPool forkJoinPool = new ForkJoinPool(4);
		CsvRecursiveAction csv = new CsvRecursiveAction(lines,lines.size());
		forkJoinPool.invoke(csv);
		
		long stopTime = System.currentTimeMillis();
		System.out.println("Processing time in milli sec : "+ (stopTime - startTime));
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
