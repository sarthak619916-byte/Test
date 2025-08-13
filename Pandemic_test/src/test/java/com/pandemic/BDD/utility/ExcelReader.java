
 package com.pandemic.BDD.utility;

 import org.apache.poi.ss.usermodel.*;
 import java.io.FileInputStream;
import java.util.Arrays;

 public class ExcelReader {
	 public static void main(String[] args) {
		 String[] arr=getData("Invalid");
		 System.out.println(Arrays.toString(arr));
	 }
     public static String[] getData(String scenarioType) {
         String[] data = new String[5];
         try (FileInputStream fis = new FileInputStream("src/test/resources/TestCases.xlsx");
              Workbook wb = WorkbookFactory.create(fis)) {
             Sheet sheet = wb.getSheet("Test Data");
             for (Row row : sheet) {
                 Cell cell = row.getCell(7);
                 if (cell != null && cell.getStringCellValue().equalsIgnoreCase(scenarioType)) {
                     data[0] = row.getCell(2).getStringCellValue();
                     data[1] = row.getCell(3).getStringCellValue();
                     data[2] = row.getCell(4).getStringCellValue();
                     data[3] = row.getCell(5).getStringCellValue();
                     data[4] = row.getCell(6).getStringCellValue();
                     break;
                 }
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
         return data;
     }
 }
