import java.io.*;

public class Main {
	static String fileName = "./inputfiles/name";
	public static void main(String[] a) throws Exception{
		System.out.println("Ali");

		BufferedReader reader = new BufferedReader(new FileReader(fileName));
			String line = reader.readLine();
			while (line != null) {
				System.out.println(line);
				line = reader.readLine();
			}
			reader.close();
	}
}
