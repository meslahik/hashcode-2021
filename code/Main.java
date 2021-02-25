import java.io.*;
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
	static Map<Integer, ArrayList<Street>> intersections = new HashMap ();

	static String fileName = "./inputfiles/a.txt";

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
			if(!intersections.containsKey(B))
				intersections.put(B, new ArrayList<>());
			intersections.get(B).add(sss);
		}

		for(int i = 0; i < V; i++){
			String[] cLine = reader.readLine().split(" ");
			int P = Integer.valueOf((cLine[0]));
			ArrayList<String> cStreets = new ArrayList<>();
			for(int j = 0; j < P ; j++){
				cStreets.add(cLine[j + 1]);
			}
			cars.add(new Car(cStreets));
		}
		System.out.println("D: " + D);
	}
	public static void main(String[] a) throws Exception{
		System.out.println("Ali");

		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		readFile(reader);
		reader.close();
	}

}
