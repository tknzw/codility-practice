package practice;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// https://app.codility.com/demo/results/trainingQ62MP7-6RB/
public class CyclicRotation {

	public int[] solution(int[] A, int K) {
		if (A == null || A.length == 0) {
			return A;
		}
		List<Integer> list = Arrays.stream(A).boxed().collect(Collectors.toList());
		AutoRemovingDeque<Integer> deque = new AutoRemovingDeque<>(A.length);
		deque.addAll(list);
		for (int i = 0; i < K; i++) {
			deque.addFirst(deque.peekLast());
		}
		int[] result = deque.stream().mapToInt(value -> value.intValue()).toArray();
		return result;
	}

	public static void main(String[] args) {
		CyclicRotation cyclicRotation = new CyclicRotation();
		int[] input = { 2, 5, 6, 1, 4 };
		int[] output = cyclicRotation.solution(input, 3);
		System.out.println("output:" + Arrays.toString(output));
	}
}

class AutoRemovingDeque<E> extends ArrayDeque<E> {
	private static final long serialVersionUID = 1L;
	private int capacity;

	public AutoRemovingDeque(int capacity) {
		super(capacity);
		this.capacity = capacity;
	}

	@Override
	public boolean add(E e) {
		boolean added = super.add(e);
		if (size() > capacity) {
			removeFirst();
		}
		return added;
	}

	@Override
	public void addFirst(E e) {
		super.addFirst(e);
		if (size() > capacity) {
			removeLast();
		}
	}

	@Override
	public void addLast(E e) {
		super.addLast(e);
		if (size() > capacity) {
			removeFirst();
		}
	}
}
