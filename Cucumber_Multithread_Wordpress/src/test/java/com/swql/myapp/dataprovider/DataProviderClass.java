package com.swql.myapp.dataprovider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	
	@DataProvider(name="getDataFromCSV")
	public static Object[][] getDataFromCSV() throws IOException{
		return csvDataProvider.getData("table1.csv");		
	}
	/*
	@DataProvider(name="getDataFromCSV1")
	public static Object[][] getDatafromCsvdata1(){
		return csvDataProvider.getCsvData("table.csv");		
	}*/
}
