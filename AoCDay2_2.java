import java.io.*;
import java.util.ArrayList;

import java.io.*;
import java.util.ArrayList;

public class AoCDay2_2 {

    public static void main(String[] args) {
        try {
            File file = new File("C:/java/input_Day2.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String s;
            int safe = 0;
            int increasing = 0;
            
            int danger = 0;
            
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
//7 6 4 2 1: Safe without removing any level.
//1 2 7 8 9: Unsafe regardless of which level is removed.
//9 7 6 2 1: Unsafe regardless of which level is removed.
//1 "3" 2 4 5: Safe by removing the second level, 3.
//8 6 4 4 1: Safe by removing the third level, 4.
//1 3 6 7 9: Safe without removing any level.
//1 "4" 2 3 5: Safe by removing the second level, 4.
//1 4 "2" 5 6: Safe by removing the third level, 2.

// use flag danger when changes from incr to decr or decr to incr
// or adding > 3 when increasing 
// or subtracting < 1 when decreasing
// use tempDangerIndex to record the i of arr that could be removed
// 
// 1 4 "2" 5 6
// 
// arr[2] changed incr to decr
// 
// create method isIncreasing
// isIncreasing returns boolean
// 
// create method is increasing3orLess
// returns boolean
// create method is decreasing3orLess
// returns boolean
 

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

