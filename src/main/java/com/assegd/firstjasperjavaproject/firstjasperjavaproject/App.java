package com.assegd.firstjasperjavaproject.firstjasperjavaproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws JRException {

		String sourceFileName = "C://Jasper Reports in Java//Jasper Project//JasperReport_A4.jrxml";

		JasperReport jasperReport = null;

		jasperReport = JasperCompileManager.compileReport(sourceFileName);

		List<EmployeeRecordModel> modelList = new ArrayList<EmployeeRecordModel>();

		modelList.add(new EmployeeRecordModel("1", "Akshay", "IT", "akshaysharma@gmail.com"));

		modelList.add(new EmployeeRecordModel("2", "Rahul", "IT", "rahulgupta@gmail.com"));

		modelList.add(new EmployeeRecordModel("3", "Dev", "IT", "dev@gmail.com"));

		modelList.add(new EmployeeRecordModel("4", "Ankit", "IT", "ankit@gmail.com"));

		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(modelList);

		Map<String, Object> params = new HashMap<String, Object>();

		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);

		String pathPdf = "C://Jasper Reports in Java//demoReportOutput.pdf";
		String pathHtml = "C://Jasper Reports in Java//demoReportOutput.html";
		String pathXml = "C://Jasper Reports in Java//demoReportOutput.xml";

		JasperExportManager.exportReportToPdfFile(jasperPrint, pathPdf);
		JasperExportManager.exportReportToHtmlFile(jasperPrint, pathHtml);
		JasperExportManager.exportReportToXmlFile(jasperPrint, pathXml,false);
	}
}
