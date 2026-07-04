package utils;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

    private static final String FILE_PATH =
            System.getProperty("user.dir")
            + "/src/test/resources/testdata/LoginData.xlsx";

    public static Object[][] getExcelData(String sheetName) {

        Object[][] data = null;

        try {

            FileInputStream fis =
                    new FileInputStream(FILE_PATH);

            XSSFWorkbook workbook =
                    new XSSFWorkbook(fis);

            XSSFSheet sheet = workbook.getSheet(sheetName);

            if (sheet == null) {
                System.out.println("Sheet not found: " + sheetName);

                System.out.println("Available sheets:");

                for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                    System.out.println(workbook.getSheetName(i));
                }
            }

            int rowCount =
                    sheet.getPhysicalNumberOfRows();

            int columnCount =
                    sheet.getRow(0).getPhysicalNumberOfCells();

            data =
                    new Object[rowCount - 1][columnCount];

            DataFormatter formatter =
                    new DataFormatter();

            for (int i = 1; i < rowCount; i++) {

                Row row =
                        sheet.getRow(i);

                for (int j = 0; j < columnCount; j++) {

                    Cell cell =
                            row.getCell(j);

                    data[i - 1][j] =
                            formatter.formatCellValue(cell);
                }
            }

            workbook.close();
            fis.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return data;
    }
}