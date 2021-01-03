package anand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class mainClass {
	
 public static void main(String args[]) {
	 int arr[]= new int[]{4,5,5,2,0,1,2,3};
	 Integer arr1[]=Arrays.stream(arr) // IntStream
             .boxed()                // Stream<Integer>
             .toArray(Integer[]::new);
	 System.out.println(arr1.length);
	 
	 HashMap<Integer,Integer> hm=new HashMap<>();
	 for(int a:arr1) {
		 if(!hm.containsKey(a))
			 hm.put(a, 0);
		 hm.put(a, hm.get(a)+1);
	 }
	 //Arrays.sort(arr1,new SortComparator(hm));
	 Arrays.sort(arr1,Collections.reverseOrder());
	 
	 ArrayList<Integer> arr2=new ArrayList<Integer>(Arrays.asList(arr1));
	 System.out.println(arr2.toString());
	 
	 System.out.println(Collections.binarySearch(arr2, 2,Collections.reverseOrder()));
	
	 Collections.sort(arr2);
	 //Upper bound lower bound not present
	 System.out.println(arr2.toString());
	 //System.out.println(lowerBound(arr2,5));
	 System.out.println(upperBound(arr2,5));
	 
	 
 }
 
 public static int lowerBound(ArrayList<Integer> arr,int k) {
	 int low=0;
	 int high=arr.size()-1;
	 
	 System.out.println(low+" "+high);
	 while(low<high)
	 {	 int mid=(low+high)/2;
		 if(arr.get(mid)<k)
			low=mid+1;
	     if(arr.get(mid)>=k)
	    	high=mid;
		 System.out.println(low+" "+high+"mid=");
	 }
	 return low;
 }
 
 public static int upperBound(ArrayList<Integer> arr,int k) {
	 int low=0;
	 int high=arr.size()-1;
	 
	 System.out.println(low+" "+high);
	 while(low<high)
	 {	 int mid=(low+high)/2;
	 	 if(arr.get(mid)<k)
			low=mid+1;
	     if(arr.get(mid)>=k)
	    	high=mid;
		 System.out.println(low+" "+high);
	 }
	 return high;
 }
 
}
class SortComparator implements Comparator<Integer>{
	HashMap<Integer,Integer> hm=new HashMap<>();
	public SortComparator(HashMap<Integer,Integer> hm) {
		this.hm=hm;
	}
	
	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		if(hm.get(o1)-hm.get(o2)==0)
			return o1-o2;
		
		return hm.get(o1)-hm.get(o2);
	}
}
