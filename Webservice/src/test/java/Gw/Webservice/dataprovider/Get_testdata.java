package Gw.Webservice.dataprovider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Get_testdata {
  @DataProvider(name = "inputs")
  public Object[][] dpi()throws IOException {
	  FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//Testdata/API data.xlsx");
	  XSSFWorkbook wb = new XSSFWorkbook(fis);
	  XSSFSheet sh = wb.getSheetAt(0);
	  Object[][] d = new Object[3][4];
	  for(int i = 2; i<= sh.getLastRowNum(); i++) {
		  for (int j = 4 ; j<= 7; j++) {
			  d[i-2][j-4] = sh.getRow(i).getCell(j).getStringCellValue();
		  } }
	  return d;
  }
  
  @DataProvider(name = "outputs")
  public Object[][] dpo()throws IOException {
	  FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//Testdata/API data.xlsx");
	  XSSFWorkbook wb = new XSSFWorkbook(fis);
	  FileOutputStream fos = new FileOutputStream(System.getProperty("usre.dir")+"//Testdata/API data");
	  wb.write(fos);
	  XSSFSheet sh = wb.getSheetAt(0);
	  Object[][] d = new Object[sh.getLastRowNum()][];
	  for(int i = 2; i<= sh.getLastRowNum(); i++) {
		  for (int j = 9 ; j<= 11; j++) {
			 // d[i][j] = sh.createRow(i).createCell(j).setCellValue(value);
		  } }
	  return d;
  }
  
}
