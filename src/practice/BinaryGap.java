package practice;

import java.util.Arrays;

// https://app.codility.com/demo/results/trainingTC7RGX-K9G/
public class BinaryGap {

	public int solution(int N) {
		long startTime = System.nanoTime();
		int result = calculate1(N);
		long endTime = System.nanoTime();
		System.out.println("time: " + (endTime - startTime));
		
//		long startTime2 = System.nanoTime();
//		int result2 = calculate2(N);
//		long endTime2 = System.nanoTime();
//		System.out.println("time2: " + (endTime2 - startTime2));

		return result;
	}

	public int calculate1(int N) {
		String binaryString = Integer.toBinaryString(N);
		System.out.println("input: " + N);
		System.out.println("binaryString: " + binaryString);
		String[] splitVal = binaryString.substring(0, binaryString.lastIndexOf("1")).split("1");
		return Arrays.stream(splitVal).filter(element -> element != null).map(element -> element.length())
				.reduce((a, b) -> Integer.max(a, b)).orElse(0);
	}

	public int calculate2(int N) {
		String binaryString = Integer.toBinaryString(N);
		System.out.println("input: " + N);
		System.out.println("binaryString: " + binaryString);
		int binaryGap = 0;
		int maxBinaryGap = 0;
		boolean counting = false;
		for (char element : binaryString.toCharArray()) {
			if (element == '0') {
				binaryGap = binaryGap + 1;
			} else {
				if (counting) {
					// maxBinaryGap = Math.max(maxBinaryGap, binaryGap);
					if (binaryGap > maxBinaryGap) {
						maxBinaryGap = binaryGap;
					}
					binaryGap = 0;
				} else {
					counting = true;
				}
			}
		}
		return maxBinaryGap;
	}

	public static void main(String[] args) {
		BinaryGap binaryGap = new BinaryGap();
		int output = binaryGap.solution(9);
		System.out.println("output:" + output);
	}
}
