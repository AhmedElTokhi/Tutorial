package A80_CSV_To_Print;
	
// Print specific column value in  array String.

/*The main steps:
 * ==============
 * 1- Get file path.
 * 2- Create CSV reader.
 * 3- Create Array String.
 * 4- Read file values via CSV reader and store it in Array String.
 * 5- Print Array String values*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class ReadCSV_PrintSpecificColumn___Using_BufferedReader {
	
    public static void main(String[] args) {

        // 1- Get file path.
//      String csvFile = "./country1.csv"; //-----------------(1)
//    	String csvFile = "./country2.csv"; //-----------------(2)
    	String csvFile = "./ReadFrom/CalcInputWithSeparator.csv"; //-----------------(3)
    	String line = "";
        String cvsSplitBy = ",";

        //2- Create CSV reader.
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

            	//3- Create Array String.
            	//4- Read file values via CSV buffer reader and store it in Array String using "line" String.
/*::Note:: When add line value that contain "," separator to Array String we MUST define separator*/
                String[] country = line.split(cvsSplitBy);

                //5- Print Array String values.
                // Print country1--------------------(1) 
//              System.out.println("Country [code= " + country[0] + " , name=" + country[5] + "]");
                
                // Print country2--------------------(2)
//                System.out.println("Country [id= " + country[0] + ", code= " + country[1] + " , name=" + country[2] + "]");
                
                //Print CalcInputWithSeparator--------------------(3)
              System.out.println("No1 " + country[0] + " , Operator " + country[1] +" , No2 " + country[2] +", result " + country[3]+"]");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}