package A83_TXT_To_DProvider;

public class Program_RUN {

	public static void main(String[] args) {
		String[][] myData = MyFileReader.ReadFromFile("./ReadFrom/TestFile.txt");

		//Loop for print
		// 1- loop in 2D array [MyData] Rows. 
		for (int i = 0; i < myData.length; i++) {
			String[] inner = myData[i];

			// 1- loop in 2D array [MyData] columns.
			for (int j = 0; j < inner.length; j++) {
				if (j == inner.length - 1)
					System.out.print(myData[i][j]);
				else
					System.out.print(myData[i][j] + ",");
			}
			System.out.println();
		}
	}
}
