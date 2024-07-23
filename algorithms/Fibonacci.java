import java.util.*;
import java.lang.Math.*;
public class Fibonacci{
	public static Map<Integer, Integer> map;
	public static int[] arr;
	public static void main(String[] args){
		map = new HashMap<>();
		ArrayList<Integer> list = new ArrayList<>();
		int n = Integer.valueOf(args[0]);
		arr = new int[n+1];
		arr[0] = 1;
		arr[1] = 1;
		list.add(fibMap(n));
		list.add(fibArr(n-1));

		for(int val : list)
			System.out.println(val);

	}

	public static int fibMap(int n){
		if (map.containsKey(n))
			return map.get(n);
		
		int f; 
		if(n <= 1)
			f = n;
		else{
			f = fibMap(n-1) + fibMap(n-2);
			map.put(n,f);
		}
		return f;
	}

	public static int fibArr(int n){
		if(n < 2)
			return arr[0];
		return arr[n] = fibArr(n-1) + fibArr(n-2);
	}
}
