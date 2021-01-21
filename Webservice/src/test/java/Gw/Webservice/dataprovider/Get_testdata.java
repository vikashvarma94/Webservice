package Gw.Webservice.dataprovider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Get_testdata {
  @DataProvider(name = "inputs")
  public Object[][] dpi()throws IOException {
	  FileInputStream fis = new FileInputStream(System.getProperty("usre.dir")+"//Testdata/API data");
	  XSSFWorkbook wb = new XSSFWorkbook(fis);
	  XSSFSheet sh = wb.getSheetAt(0);
	  Object[][] d = new Object[sh.getLastRowNum()][];
	  for(int i = 0; i<= sh.getLastRowNum(); i++) {
		  for (int j = 0 ; j<= 2; j++) {
			  d[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
		  } }
	  return d;
  }
  
  @DataProvider(name = "outputs")
  public Object[][] dpo()throws IOException {
	  FileInputStream fis = new FileInputStream(System.getProperty("usre.dir")+"//Testdata/API data");
	  XSSFWorkbook wb = new XSSFWorkbook(fis);
	  XSSFSheet sh = wb.getSheetAt(0);
	  Object[][] d = new Object[sh.getLastRowNum()][];
	  for(int i = 0; i<= sh.getLastRowNum(); i++) {
		  for (int j = 0 ; j<= 2; j++) {
			  d[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
		  } }
	  return d;
  }
  
}
