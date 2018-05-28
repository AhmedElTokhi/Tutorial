package utils;

/*This code handle text or CSV file structure as following:
 * H,No1,Operator,No1,Result
 * V,10,+,5,15
 * (H) for header and (V) for value
 * */

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ReadTXT {
	public static String[][] ReadFromFile(String filePath) {
		try {
			if (!Files.exists(Paths.get(filePath))) {
				return null;
			}
			

			List<String> list = Files.readAllLines(Paths.get(filePath));
			

			String[][] Data = new String[list.size()][];

			// loop on String List.
			for (int i = 0; i < list.size(); i++) {
				
				//get list value in [linelist]
				List<String> lineList = new LinkedList<>(Arrays.asList(list.get(i).split("\\,")));

				
				//Cast linked list [linelist] to array String [inner]
				String[] inner = new String[lineList.size()];
				lineList.toArray(inner);
				
				//pass array String [inner] to 2D array String [data].
				Data[i] = inner;
			}
			return Data;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}
}
