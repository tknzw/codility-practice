package practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// https://app.codility.com/demo/results/trainingCS3PSH-JVH/
public class CyclicRotation2 {

	public int[] solution(int[] A, int K) {
		if (A == null || A.length == 0) {
			return A;
		}
		List<Integer> list = Arrays.stream(A).boxed().collect(Collectors.toList());
		for (int i = 0; i < K; i++) {
			Integer tmpValue = list.get(list.size() - 1);
			list.remove(list.size() - 1);
			list.add(0, tmpValue);
		}
		int[] result = list.stream().mapToInt(value -> value.intValue()).toArray();
		return result;
	}
	
	public static void main(String[] args) {
		CyclicRotation cyclicRotation = new CyclicRotation();
		int[] input = { 2, 5, 6, 1, 4 };
		int[] output = cyclicRotation.solution(input, 3);
		System.out.println("output:" + Arrays.toString(output));
	}
}
