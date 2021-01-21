package Gw.Webservice.REST_TC;

import org.apache.poi.hssf.record.common.ExtendedColor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import Gw.Webservice.Utills.Baseclass;
import Gw.Webservice.dataprovider.Get_testdata;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class tc1_Get extends Baseclass {
  @Test(dataProvider = "inputs", dataProviderClass = Get_testdata.class)
  public void test(String endpoint, String req, String code, String Line) {
	  test = report.createTest("tc1_Get");
	given()
		.when().get(endpoint+""+req)
		.then().statusCode(200)
				.statusLine(Line);	 
}}
