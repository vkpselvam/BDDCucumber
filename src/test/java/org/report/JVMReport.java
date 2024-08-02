package org.report;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class JVMReport {
	public static void generateReport(String json) {
		
		//To Locate where the Json file to be stored
		File file = new File("target");
		Configuration con = new Configuration(file, "AdactinHotelLoginPage");
		con.addClassifications("User_ID", "200");
		con.addClassifications("Tool", "BDD Cucumber with Junit");
		
		//Create a empty List
		List<String> li=new LinkedList<String>();
		li.add(json);
		
		//To Generate Report
		ReportBuilder build=new ReportBuilder(li, con);
		build.generateReports();
	}

}
