package A83_TXT_To_DProvider;

/*This code handle text or CSV file*/

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class MyFileReader_With_Header {
	public static String[][] ReadFromFile(String filePath) {
		try {
			if (!Files.exists(Paths.get(filePath))) {
				return null;
			}
			

			List<String> list = Files.readAllLines(Paths.get(filePath));
			list.removeIf(new Predicate<String>() {
				@Override
				// Check if Line start with (h) which is mean (Header)and remove it from list.
				public boolean test(String item) {
					String lineType = item.substring(0, 1);
					return (lineType.toLowerCase().indexOf("h") == 0);
				}
			});

			String[][] Data = new String[list.size()][];

			// loop on String List.
			for (int i = 0; i < list.size(); i++) {
				
				//get list value in [linelist]
				List<String> lineList = new LinkedList<>(Arrays.asList(list.get(i).split("\\,")));

				// Check if Line start with (V) which is mean (Value)and remove it from [linelist].
				lineList.removeIf(new Predicate<String>() {
					@Override
					public boolean test(String item) {
						String lineType = item.substring(0, 1);
						return (lineType.toLowerCase().indexOf("v") == 0);
					}
				});
				
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
