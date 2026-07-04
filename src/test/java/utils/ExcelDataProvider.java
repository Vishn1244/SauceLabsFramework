package utils;

import org.testng.annotations.DataProvider;

public class ExcelDataProvider {

    @DataProvider(name = "loginData")
    public Object[][] loginData() {

    	return ExcelReader.getExcelData("Sheet1");
    }
}