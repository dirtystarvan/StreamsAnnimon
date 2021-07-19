import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
	private static final String delimeter = "=====the next=====";

	public static void main(String[] args) {
		Stream.iterate(1, x -> x * 2)
				.limit(6)
				.forEach(System.out::println);
		//1, 2, 4, 8, 16, 32

		System.out.println(delimeter);

		Stream.iterate(4, x -> x < 100, x -> x * 4)
				.forEach(System.out::println);

		//4, 16, 64

		System.out.println(delimeter);

		Stream.concat(
				Stream.of(10),
				Stream.of(4, 16)
		).forEach(System.out::println);

		System.out.println(delimeter);

		Stream.Builder<Integer> sb = Stream.<Integer>builder().add(0).add(1);

		for (int i = 2; i <= 8; i += 2) {
			sb.accept(i);
		}

		sb.add(9).add(10).build().forEach(System.out::println);

		//0, 1, 2, 4, 6, 8, 9, 10

		System.out.println(delimeter);

		IntStream.range(2, 9)
				.filter(x -> x % 3 == 0)
				.forEach(System.out::println);

		System.out.println(delimeter);

		Stream.of("10", "11", "32")
				.map(x -> Integer.parseInt(x, 16))
				.forEach(System.out::println);

		System.out.println(delimeter);

		Stream.of(1, 2, 3, 4, 5, 6)
				.flatMap(x -> {
					switch (x % 3) {
						case 0:
							return Stream.of(x, x * x, x * x * 2);
						case 1:
							return Stream.of(x);
						case 2:
						default:
							return Stream.empty();
					}
				}).forEach(System.out::println);

		System.out.println(delimeter);

		Stream.of(120, 410, 85, 32, 314, 12)
				.limit(2)
				.limit(5)
				.forEach(System.out::println);

		Stream.of(19)
				.limit(0)
				.forEach(System.out::println);

		//Вывода нет

		System.out.println(delimeter);

		IntStream.range(0, 10)
				.limit(5)
				.skip(3)
				.forEach(System.out::println);

		//3 4

		System.out.println(delimeter);

		IntStream.range(0, 10)
				.skip(5)
				.limit(3)
				.skip(1)
				.forEach(System.out::println);

		//6 7

		System.out.println(delimeter);

		Stream.of(120, 410, 85, 32, 314, 12)
				.sorted(Comparator.reverseOrder())
				.forEach(System.out::println);

		System.out.println(delimeter);

		IntStream.concat(
				IntStream.range(2, 5),
				IntStream.range(0, 4))
				.distinct()
				.forEach(System.out::println);

		//2 3 4 0 1

		System.out.println(delimeter);

		IntStream.range(2, 7)
				.takeWhile(x -> x != 5)
				.forEach(System.out::println);

		System.out.println(delimeter);

		IntStream.range(2, 7)
				.dropWhile(x -> x < 5)
				.forEach(System.out::println);

		System.out.println(delimeter);

		IntStream.of(1, 3, 2, 0, 5, 4)
				.dropWhile(x -> x % 2 == 1)
				.forEach(System.out::println);

		System.out.println(delimeter);

		System.out.println(
				IntStream.rangeClosed(-3, 6)
						.count()
		);

		System.out.println(delimeter);

		System.out.println(
				Stream.of(0, 2, 9, 13, 5, 11)
						.map(x -> x * 2)
						.filter(x -> x % 2 == 1)
						.count()
		);

		System.out.println(delimeter);

		Optional<Integer> some = Stream.<Integer>empty().reduce(Integer::sum);
		System.out.println(some.isPresent() ? some.get() : some.isPresent());

		System.out.println(delimeter);

		int sum = IntStream.of(2, 4, 6, 8)
				.reduce(5, (acc, x) -> acc + x);

		System.out.println(sum);

		System.out.println(delimeter);

		int product = IntStream.range(0, 10)
				.filter(x -> x++ % 4 == 0)
				.reduce((acc, x) -> acc * x)
				.getAsInt();

		System.out.println(product);

		System.out.println(delimeter);

		boolean result = Stream.of(120, 410, 85, 32, 314, 12)
				.allMatch(x -> x % 2 == 0);

		System.out.println(result);

		System.out.println(delimeter);


	}
}