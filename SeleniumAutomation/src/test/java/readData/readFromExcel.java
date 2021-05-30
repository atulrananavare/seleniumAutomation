package readData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readFromExcel {

	public static void main(String[] args) throws IOException {
		File file = new File(
				"C:\\Users\\atul_r" + "ananavare\\ProblemSolvingWorkspace\\SeleniumEasyAutomation\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(file);

		XSSFWorkbook book = new XSSFWorkbook(fis);
		XSSFSheet sheet = book.getSheet("Sheet1");

		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		for (int i = 0; i < rowCount + 1; i++) {
			Row row = sheet.getRow(i);

			for (int j = 0; j < row.getLastCellNum(); j++) {

				// Print Excel data in console

				System.out.print(row.getCell(j).getStringCellValue() + "|| ");
			}
			System.out.println(); 
		}
	}

}
