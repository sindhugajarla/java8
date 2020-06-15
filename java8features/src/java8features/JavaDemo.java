package java8features;

import java.util.Arrays;
import java.util.List;

public class JavaDemo {
	public static void main(String[] args) {
		List<Integer> values= Arrays.asList(1,2,3,4,5,6);
		System.out.println(values.stream().map(i-> i*i+2).reduce(0,(c,e)-> c+e));
	}

}
