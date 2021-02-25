import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

class Street {
	int B;
	int E;
	String name;
	int L;

	Street(int B, int E, String name, int L){
		this.B = B;
		this.E = E;
		this.name = new String(name);
		this.L = L;
	}
	
	@Override
	public int hashCode() {
		return name.hashCode();
	}
}

class Car {
	ArrayList<String> cStreets;
	Car(ArrayList<String> st){
		this.cStreets = st;
	}
}

public class Main {
	static int D;
	static int I;
	static int S;
	static int V;
	static int F;
	static ArrayList<Street> streets = new ArrayList<>();
	static ArrayList<Car> cars = new ArrayList<>();
	static Map<Integer, ArrayList<Street>> intersections = new HashMap<> ();
	static Map<String, Integer> popularStreet = new HashMap<>();

	static String fileName = "./inputfiles/d.txt";
	static String outputName = "/Users/ali/Desktop/d.txt";

	public static void readFile(BufferedReader reader) throws Exception{
		String[] fLine = reader.readLine().split(" ");
		D = Integer.valueOf((fLine[0]));
		I = Integer.valueOf((fLine[1]));
		S = Integer.valueOf((fLine[2]));
		V = Integer.valueOf((fLine[3]));
		F = Integer.valueOf((fLine[4]));

		for(int i = 0; i < S; i++){
			String[] sLine = reader.readLine().split(" ");
			int B = Integer.valueOf((sLine[0]));
			int E = Integer.valueOf((sLine[1]));
			String name = sLine[2];
			int L = Integer.valueOf((sLine[3]));
			Street sss = new Street(B, E, name, L);
			streets.add(sss);
			if(!intersections.containsKey(E))
				intersections.put(E, new ArrayList<>());
			intersections.get(E).add(sss);
		}

		for(int i = 0; i < V; i++){
			String[] cLine = reader.readLine().split(" ");
			int P = Integer.valueOf((cLine[0]));
			ArrayList<String> cStreets = new ArrayList<>();
			for(int j = 0; j < P ; j++){
				String stName = cLine[j + 1];
				cStreets.add(stName);


				if(!popularStreet.containsKey(stName)){
					popularStreet.put(stName, 0);
				}else{
					popularStreet.put(stName, popularStreet.get(stName) + 1);
				}
			}
			cars.add(new Car(cStreets));
		}
		System.out.println("Input is read!");
	}

	public static void appendFile(int txt){
		appendFile(txt + "");
	}	

	public static void appendFile(String txt){
		txt = txt + "\n";
		try {
			Files.write(Paths.get(outputName), txt.getBytes(), StandardOpenOption.APPEND);
		}catch (IOException e) {
			System.out.println(e.getMessage());
			//exception handling left as an exercise for the reader
		}
	}
	public static void main(String[] a) throws Exception{
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		readFile(reader);
		reader.close();

		appendFile(intersections.size());
		Set<Integer> keys = intersections.keySet(); 
		for(int key: keys){
			appendFile(key);
			appendFile(intersections.get(key).size());
			for(Street t: intersections.get(key)){
				if(popularStreet.containsKey(t.name))
					appendFile(t.name + " " + (popularStreet.get(t.name) > 10 ? 10 : 2));
				else
					appendFile(t.name + " " + 1);
					
			}
		}
	}

}
