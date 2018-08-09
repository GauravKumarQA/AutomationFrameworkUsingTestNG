package tests.dataProvider;

import java.util.ArrayList;

public class RemoveChrFromString {

 public static void main(String args[]) {
   String org = "aaahhbffdsoo";
   String toRemove = "a";
   
   char[] array = org.toCharArray();
   
   ArrayList<String> arr = new ArrayList<String>();
   for(int i = 0 ;i<array.length;i++) {
     arr.add(String.valueOf(array[i]));
   }
  
   while(arr.contains(toRemove)) {
   arr.remove(toRemove);
   }
   System.out.println(arr);
   
   
 }
}
