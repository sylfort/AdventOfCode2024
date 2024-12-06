import java.io.*;
import java.util.ArrayList;

public class Day1 {
	public static ArrayList<Integer> arr1 = new ArrayList<Integer>();
	public static ArrayList<Integer> arr2 = new ArrayList<Integer>();
	public static ArrayList<Integer> arrFinal = new ArrayList<Integer>();
	public static void main(String[] args) {
		try {

			
			File file = new File("C:/java/lists_inputs.txt");
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			String s;
			while((s = br.readLine()) != null) {
				String[] myArray = s.split("   ");
				arr1.add(Integer.parseInt(myArray[0]));
				arr2.add(Integer.parseInt(myArray[1]));
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		arr1.sort(null);
		arr2.sort(null);
		
		for (int i = 0; i < arr1.size(); i++) {
			int diff;
			System.out.println("arr1 " + arr1.get(i) + "arr2 " + arr2.get(i));
			if(arr1.get(i) > arr2.get(i)) {
				diff = arr1.get(i) - arr2.get(i);
				System.out.println("arr1 " + arr1.get(i) + "arr2 " + arr2.get(i));
			} else if (arr2.get(i) > arr1.get(i)) {
				diff = arr2.get(i) - arr1.get(i);
				System.out.println("arr1 " + arr1.get(i) + "arr2 " + arr2.get(i));
			} else {
				diff = 0;
			}
			arrFinal.add(diff);
		}
		
		int result = arrFinal.stream().reduce(0, (subtotal, element) -> subtotal + element);
		
		System.out.println(result);
	}

}
