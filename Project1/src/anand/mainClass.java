package anand;

import java.util.Arrays;
import java.util.Comparator;

public class mainClass {
	
 public static void main(String args[]) {
	 int arr[]= new int[]{4,5,5,2,0,1,2,3};
	 Integer arr1[]=Arrays.stream(arr) // IntStream
             .boxed()                // Stream<Integer>
             .toArray(Integer[]::new);
	 Arrays.sort(arr1,new SortComparator());
	 
	 System.out.println(Arrays.toString(arr1));
	 
	 
 }
 
}
class SortComparator implements Comparator<Integer>{
	public SortComparator() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		return o1-o2;
	}
}
