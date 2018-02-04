package com.thread.task.wiki;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

public class ForkAndJoinWikiReader implements Runnable{

	private String fileName;

	
	
	public ForkAndJoinWikiReader(String fileName) {
		super();
		this.fileName = fileName;
	}

	public static void main(String[] args)  {
		
		ExecutorService executorService = null;
		
		try {
		long startTime = System.currentTimeMillis();
		
		 executorService = Executors.newFixedThreadPool(args.length);
		
		for(String filename : args) {
			
			ForkAndJoinWikiReader fork = new ForkAndJoinWikiReader(filename);
			executorService.execute(fork);
		}
		
		long stopTime = System.currentTimeMillis();
		System.out.println("Processing time in milli sec : "+ (stopTime - startTime));
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			executorService.shutdown();
		}
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		ExecutorService executorService = null;
		
		try {
		
		List<String> lines = Files.readAllLines(Paths.get(fileName));
		List<String> result = new ArrayList<>();
		
		executorService = Executors.newFixedThreadPool(lines.size());
		
		for(String line: lines) {
		
		SearchInWiki swiki = new SearchInWiki(line.replaceAll(" ", "%20"));
		Future<String> future = executorService.submit(swiki);
		
		result.add(future.get());
		}
		
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		WikiRecursiveAction wiki = new WikiRecursiveAction(result,result.size());
		forkJoinPool.invoke(wiki);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			executorService.shutdown();
		}
	}

}
