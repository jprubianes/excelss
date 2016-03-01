package com.bruteforcesolution.sales;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.xssf.usermodel.helpers.XSSFXmlColumnPr;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;




public class Xls_write {

	public Workbook wb = new XSSFWorkbook();
	
	public void createWorkbook(String sheetname, int rowNum, int cellnum, String data) throws Exception {
		
		Sheet sheet = wb.createSheet(sheetname);
		Sheet s = wb.getSheet(sheetname);
		s.getRow(rowNum).getCell(cellnum).setCellValue(data);
		FileOutputStream fileOut = new FileOutputStream("C:\\Excelf\\Testresult.xlsx");
		wb.write(fileOut);
		fileOut.close();
		
		}	
	

	}
