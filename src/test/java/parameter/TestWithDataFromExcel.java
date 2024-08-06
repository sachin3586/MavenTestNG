package parameter;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class TestWithDataFromExcel {

    @DataProvider(name = "testData")
    public Object[][] getData() throws IOException {
        // Replace "data.xlsx" with your actual Excel file path
        FileInputStream fis = new FileInputStream("C:\\Users\\lenovo\\Desktop\\Testing\\TestData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0); // Assuming data starts from sheet 0

        int rowCount = sheet.getLastRowNum(); // Get total number of rows (excluding header)
        int colCount = sheet.getRow(0).getLastCellNum(); // Get number of columns from the first row

        Object[][] data = new Object[rowCount][colCount];

        for (int i = 1; i <= rowCount; i++) { // Start from 1 to skip header row
            XSSFRow row = sheet.getRow(i);
            for (int j = 0; j < colCount; j++) {
                // Get cell value based on data type (adjust as needed)
                if (row.getCell(j) != null) {
                    switch (row.getCell(j).getCellType()) {
                        case STRING:
                            data[i - 1][j] = row.getCell(j).getStringCellValue();
                            break;
                        case NUMERIC:
                            data[i - 1][j] = row.getCell(j).getNumericCellValue();
                            break;
                        default:
                            data[i - 1][j] = row.getCell(j).toString(); // Handle other types or errors
                    }
                } else {
                    data[i - 1][j] = null; // Handle missing cells
                }
            }
        }

        workbook.close();
        fis.close();

        return data;
    }

    @Test(dataProvider = "testData")
    public void testWithData(String username, String password, double age) {
        // Your test logic using the data from data provider
        System.out.println("Username: " + username + ", Password: " + password + ", Age: " + age);
    }
}
