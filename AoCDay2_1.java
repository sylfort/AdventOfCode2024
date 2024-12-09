import java.io.*;
import java.util.ArrayList;

public class AoCDay2_1 {

    public static void main(String[] args) {
        try {
            File file = new File("C:/java/input_Day2.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String s;
            int safe = 0;
            int increasing = 0;
            
            while ((s = br.readLine()) != null) {
                String[] tempArr = s.split(" ");
                ArrayList<Integer> arr = new ArrayList<>();
                
                for (String str : tempArr) {           	
                    arr.add(Integer.parseInt(str));
                }
                
                for (int i=0; i<arr.size(); i++) {
              	  int curr = arr.get(i);

              	  System.out.println(curr);
              	}
                
              for (int i = 0; i < arr.size() - 1; i++) {
                  System.out.println(arr.get(i) + "  " + arr.get(i + 1));
                  if(i == 0) {
                      if(     (arr.get(i) - arr.get(i + 1)) == 1 || 
                              (arr.get(i) - arr.get(i + 1)) == 2 || 
                              (arr.get(i) - arr.get(i + 1)) == 3) {
                      			System.out.println("decr");
                                  increasing = 1;
                      }else if((arr.get(i + 1) - arr.get(i)) == 1 || 
                              (arr.get(i + 1) - arr.get(i)) == 2 || 
                              (arr.get(i + 1) - arr.get(i)) == 3) {
              					System.out.println("incr");
                                  increasing = 2;
                      } else {
                          increasing = 0;
                          continue;
                      }                   
                  }
                  
                  if(increasing == 2 &&
                      ((arr.get(i + 1) - arr.get(i)) == 1 || 
                      (arr.get(i + 1) - arr.get(i)) == 2 || 
                      (arr.get(i + 1) - arr.get(i)) == 3)) {
                	  System.out.println("ok");
                  } else if(increasing == 1 &&
                      ((arr.get(i) - arr.get(i + 1)) == 1 || 
                      (arr.get(i) - arr.get(i + 1)) == 2 || 
                      (arr.get(i) - arr.get(i + 1)) == 3)) {
                	  System.out.println("ok");
                  } else {
                	  System.out.println("NOT ok");
                      increasing = 0;
                      continue;
                  }
                  
                  if(i == (arr.size() - 2)) {
                      System.out.println("last comparison: " + arr.get(i) + "  " + arr.get(i + 1));
                  	if(increasing == 2 &&
                      ((arr.get(i + 1) - arr.get(i)) == 1 || 
                      (arr.get(i + 1) - arr.get(i)) == 2 || 
                      (arr.get(i + 1) - arr.get(i)) == 3)) {
                      safe++;
                      System.out.println("safe: " + safe);
                    } else if(increasing == 1 &&
                      ((arr.get(i) - arr.get(i + 1)) == 1 || 
                      (arr.get(i) - arr.get(i + 1)) == 2 || 
                      (arr.get(i) - arr.get(i + 1)) == 3)) {
                      safe++;
                      System.out.println("safe: " + safe);
                    } else {
                    	  System.out.println("NOT SAFE");
                          increasing = 0;
                          continue;
                   }
                  }
                  
                  System.out.println("new arr");
              }
                
            } br.close();
            System.out.println(safe);
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }

}


//7 6 4 2 1 //safe, decreasing by 2
//1 2 7 8 9 // unsafe, increased by 5
//9 7 6 2 1 // unsafe, decreased by 4
//1 3 2 4 5 // unsafe, increased and decreased
//8 6 4 4 1 // unsafe, decreased by 0
//1 3 6 7 9 // sabe increased by 2 and 3

//read each line splitting lines on spaces to get integers
//compare each integer with the following, until i < arr.length - 1
// int safe = 0;
// boolean increasing;
// the first comparison is safe if(Math.abs(arr[i] - arr[i + i]) == 1 || Math.abs(arr[i] - arr[i + i]) == 2 || Math.abs(arr[i] - arr[i + i]) == 3)
//	increasing = true;
// or if(Math.abs(arr[i + i]) - arr[i] == 1 || Math.abs(arr[i + i]) - arr[i] == 2 || Math.abs(arr[i + i] - arr[i]) == 3)
//increasing = false;
// the following comparisons are safe if
// if(increasing = true)
