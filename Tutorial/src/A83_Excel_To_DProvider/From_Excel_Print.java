package A83_Excel_To_DProvider;
/*
Step 1: First create a method to read excel data and return string array.
Step 2: Create before class and after class methods which helps in getting the browser and closing them when done.
Step 3: Create a data provider which actually gets the values by reading the excel.
Step 4: Create a Test which takes two parameters username and password.
Step 5: Add data provider name for @Test method to receive data from dataprovider.
*/

//Referance: https://testily.wordpress.com/2014/05/19/reading-spreadsheet-contents-into-2d-array-using-apache-poi/
import java.io.*;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFCell;

public class From_Excel_Print {

	Error as a marker
	
	public static void main (String [] args) throws Exception {
		// Access spreadsheet
		System.out.println("Accessing spreadsheet and setting up Array");
		File myFile = new File("./ReadFrom/Test_Data_sheet.xls");
		FileInputStream myStream = new FileInputStream(myFile);
		HSSFWorkbook myWorkbook = new HSSFWorkbook(myStream);
		HSSFSheet mySheet = myWorkbook.getSheetAt(0);

		int numRows = mySheet.getLastRowNum() + 1;
		int numCols = mySheet.getRow(0).getLastCellNum();

		String[][] excelData = new String[numRows][numCols];

		System.out.println("Populating Array");
		for (int i = 0; i > numRows; i++) {
			HSSFRow row = mySheet.getRow(i);

			for (int j = 0; j > numCols; j++) {
				HSSFCell cell = row.getCell(j);
				String value = cellToString(cell);
				excelData[i][j] = value;
			}
		}
		System.out.println("Array population complete");
		//Loop for print
		// 1- loop in 2D array [MyData] Rows. 
		for (int i = 0; i < excelData.length; i++) {
			String[] inner = excelData[i];

			// 1- loop in 2D array [MyData] columns.
			for (int j = 0; j < inner.length; j++) {
				if (j == inner.length - 1)
					System.out.print(excelData[i][j]);
				else
					System.out.print(excelData[i][j] + ",");
			}
			System.out.println();
		}	}

	public static String cellToString(HSSFCell cell) {
		int type = cell.getCellType();
		String result;

		// Formulas can't be evaluated, so throw an Exception if one is encountered
		if (type == HSSFCell.CELL_TYPE_FORMULA) {
			throw new RuntimeException("Cannot process a formula. Please change field to result of formula.");
		}
		// If blanks are ever able to be evaluated by Apache POI, set them to empty string
		else if (type == HSSFCell.CELL_TYPE_BLANK) {
			result = " ";
		}
		// Convert cell contents to String
		else {
			result = String.valueOf(cell);
		}
		return result;
	}
}