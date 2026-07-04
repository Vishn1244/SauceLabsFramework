package tests;

import org.testng.annotations.Test;

import utils.ExcelReader;

public class ExcelReaderTest {

    @Test
    public void readExcel() {

        Object[][] data =
        		ExcelReader.getExcelData("Sheet1");

        for (Object[] row : data) {

            for (Object cell : row) {

                System.out.print(cell + "    ");
            }

            System.out.println();
        }
    }
}