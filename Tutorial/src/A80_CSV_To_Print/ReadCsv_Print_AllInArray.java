package A80_CSV_To_Print;

// Print all values of array

/*The main steps:
 * ==============
 * 1- Get file path.
 * 2- Create CSV reader.
 * 3- Create Array String.
 * 4- Read file values via CSV reader and store it in Array String.
 * 5- Print Array String values*/

import java.io.FileReader;
import org.testng.annotations.Test;

import au.com.bytecode.opencsv.CSVReader;

public class ReadCsv_Print_AllInArray {

	//1- Get file path
	private static final String FILE_PATH = "./ReadFrom/CalcInput.csv"; 			

	@SuppressWarnings("resource")
	@Test
	
	public void Read_CSV_File() throws Exception {

		//2- Create "Reader" object from CSVReader
		CSVReader reader = new CSVReader(new FileReader(FILE_PATH));

		//3- Create Array String nextLine[].
		String[] nextLine;
	//OR	
//::Note:: To escape (1st Row = row 0) as a header, we can do as following.
//		String[] nextLine= reader.readNext();
		
// ============Print Value by Value ======================				
//		//4- Read file values via CSV reader and store it in Array String
//		//a conditional procedure that will be executed only if the file has a next non-empty line
//		while ((nextLine = reader.readNext()) != null) {
//			
//			// 5- For loop to print array values
//			for (int i = 0; i < nextLine.length; i++) {
//				System.out.println("Value by Value" + ": [" + nextLine[i] + "]");
//			}
//		}

//OR ======== Print line by line ==========================
		//4- Read file values via CSV reader and store it in Array String
		//a conditional procedure that will be executed only if the file has a next non-empty line
		while ((nextLine = reader.readNext()) != null) {
			String Value = "";
			
			// For loop to print array values
			for (int i = 0; i < nextLine.length; i++) {

				Value=Value+nextLine[i];
			}
			// 5- For loop to print array values
			System.out.println("The line Value " + ":" + Value );
			Value="";
		}

		
		
		
		
		/*::Notes::
		 * 1- Now we can read CSV file date. 
		 * 1-1- If Have an issue in console output. (Create CSV file by Notepad and we can change its Encoding)
		 * 
		 * https://www.youtube.com/watch?v=2Hz4gXEGYmg
		 * https://www.youtube.com/watch?v=2i5GgpwzTDY
		 * 
		 * 2- load CSV file data to Object array, and use it as a data provider
		 * in test case. https://www.youtube.com/watch?v=l1dfVwLqaX8
		 * 
		 * 
		 * 3- Read data from EXCEL. https://www.youtube.com/watch?v=2vaVbnL-4iQ
		 * 4- Read data from DB.
		 * 
		 */
	}

}