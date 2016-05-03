package com.swql.myapp.dataprovider;

import java.util.List;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;

public class csvDataProvider {
	
	private static Object[][] data = null;
	
	private static String getPath(String filename){		
		String path = csvDataProvider.class.getClassLoader().getResource("testdata").getPath();		
		path = path.replaceAll("bin", "src");
		path = path + "/" + filename;
		System.out.println("PATH : " + path);
		return path;
	}
		
	public static Object[][] getData(String filename) throws IOException{		
		CSVReader csvReader = new CSVReader(new FileReader(getPath(filename)));	
		
		String[] header = csvReader.readNext();
		List<String[]> dataList = csvReader.readAll();
		data = new Object[dataList.size()][2];				
		for(int i=0; i<dataList.size();i++ ){
						
			String username = dataList.get(i)[0];			
			String password = dataList.get(i)[1];
						
			data[i][0] = username;			
			data[i][1] = password;
		}			
		csvReader.close();
		return data;				
	}	
}
