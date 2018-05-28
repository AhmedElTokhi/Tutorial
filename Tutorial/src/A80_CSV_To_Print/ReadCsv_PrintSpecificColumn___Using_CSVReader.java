package A80_CSV_To_Print;

//Print all values of array

/*The main steps:
* ==============
* 1- Get file path.
* 2- Create CSV reader.
* 3- Create Array String.
* 4- Read file values via CSV reader and store it in Array String.
* 5- Print Array String values*/

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import org.testng.annotations.Test;
import com.opencsv.CSVReader;

public class ReadCsv_PrintSpecificColumn___Using_CSVReader {
	
	@SuppressWarnings("resource")
	@Test
	public void ReadCSV() throws IOException {
// ==============================
		//1- Get file path.
		String filePath = "D:\\Eclips_Source\\eclipse_Mars2_WorkSpace\\Tutorial\\ReadFrom\\CalcInputWithSeparator.csv";

		//2- Create CSV reader.
		CSVReader reader = new CSVReader(new FileReader(filePath));

	// OR
		// CSVReader reader = new CSVReader(new FileReader("./CalcInputWithSeparator.csv"));
// ==============================
		//3- Create list of Array String.
		//4- Read file values via CSV reader and store it in Array String.
		List<String[]> allLines = reader.readAll();

		// loop in list to read line by line.
		for (int lineNo = 0; lineNo < allLines.size(); lineNo++) {

			// 4.1- Read line by line from List of array "allLines"
			String[] currentLineArray = allLines.get(lineNo);

			// 4.2- Define string variable and add array Sting current value in.
			String currentLine = currentLineArray[3];
			
        	//4.3- Convert the currentLine from being a string into an array of strings(String[]) which can be detected by the "," character
/*::Note:: When add line value that contain "," separator to Array String we MUST define separator*/
			String[] values = currentLine.split(",");

			//5- Print Array String values
			for (int index = 0; index < values.length; index++)
				System.out.println(values[index]);

		}
	}
}
