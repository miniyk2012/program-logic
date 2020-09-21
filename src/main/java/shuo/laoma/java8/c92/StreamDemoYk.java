package shuo.laoma.java8.c92;

import org.junit.Test;
import shuo.laoma.basic.c11.Array;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.util.Collections.reverseOrder;


public class StreamDemoYk {

	private static List<Student> students = Arrays.asList(new Student[] {
	        new Student("zhangsan", 89d),
	        new Student("lisi", 89d),
	        new Student("wangwu", 98d),
			new Student("yangkai", 98d),
			new Student("yuanyuan", 95d),
			new Student("lijin", 98d),
			new Student("lizhen", 98d),
			new Student("sunfang", 95d),
	});
	public static <E> void printList(List<E> list){
		System.out.println(Arrays.toString(list.toArray()));
	}

	@Test
	public void basicFilter(){
		List<Student> above90List = students.stream()
				.filter(t->t.getScore()>90)
				.collect(Collectors.toList());
		printList(above90List);
		above90List = new ArrayList<>();


		for (Student t : students) {
			if (t.getScore() > 90) {
				above90List.add(t);
			}
		}
		printList(above90List);
		System.out.println(above90List);
	}

	@Test
	public void basicMap(){
		List<String> nameList = students.stream()
				.map(Student::getName)
				.collect(Collectors.toList());
		printList(nameList);

		nameList = students.stream()
				.map(t->t.getName())
				.collect(Collectors.toList());
		printList(nameList);

		nameList = new ArrayList<>();
		for (Student s : students) {
			nameList.add(s.getName());
		}
		printList(nameList);
	}

	/**
	 * 实际上，调用filter()和map()都不会执行任何实际的操作，
	 * 它们只是在构建操作的流水线，调用collect才会触发实际的遍历执行，
	 * 在一次遍历中完成过滤、转换以及收集结果的任务。
	 */
	@Test
	public void basicFilterAndMap(){
		List<String> above90Names = students.stream()
				.filter(t->t.getScore()>90)
				.map(Student::getName)
				.collect(Collectors.toList());
		printList(above90Names);
		System.out.println(above90Names);
	}

	@Test
	public void distinct(){
		List<String> list = Arrays.asList(new String[]{"abc","def","hello","Abc"});
		List<String> retList = list.stream()
				.filter(s->s.length()<=3)
				.map(String::toUpperCase)
				.distinct()  // equals()方法来判断
				.collect(Collectors.toList());
		System.out.println(retList);
	}

	/**
	 * 过滤得到90分以上的学生，然后按分数从低到低排序，
	 * 分数一样的，按名称从高到低排序，代码可以为：
	 */
	@Test
	public void sorted(){
		// reversed is applied to the whole comparator
		List<Student> list = students.stream()
				.filter(s->s.getScore()>=90)
				.sorted(Comparator.comparing(Student::getScore)
					.reversed()
					.thenComparing(Student::getName)
					.reversed())
				.collect(Collectors.toList());
		System.out.println(list);

		list = students.stream()
				.filter(s->s.getScore()>=90)
				.sorted(Comparator.comparing(Student::getScore)
					.thenComparing(reverseOrder(Comparator.comparing(Student::getName))))
				.collect(Collectors.toList());
		System.out.println(list);

		list = students.stream()
				.filter(s->s.getScore()>=90)
				.sorted(Comparator.comparing(Student::getScore)
					.thenComparing(Comparator.comparing(Student::getName).reversed()))
				.collect(Collectors.toList());
		System.out.println(list);
	}

	@Test
	public void skipLimit(){
		// skip和limit都是有状态的中间操作，比如保留当前到底处理了几个元素
		List<Student> revserStudents = students.stream()
				.sorted(Comparator.comparing(
						Student::getScore).reversed())
				.collect(Collectors.toList());
		System.out.println(revserStudents);

		List<Student> list = students.stream()
		        .sorted(Comparator.comparing(
		            Student::getScore).reversed())
		        .limit(3)
				.skip(2)
				.collect(Collectors.toList());
		System.out.println(list);
	}

	@Test
	public void peek(){
	    List<String> above90Names = students.stream()
	            .filter(t->t.getScore()>90)
	            .peek(t->System.out.println(t))
	            .map(Student::getName)
	            .collect(Collectors.toList());
		System.out.println(above90Names);

		above90Names = students.stream()
				.filter(t->t.getScore()>90)
				.peek(System.out::println)
				.map(Student::getName)
				.collect(Collectors.toList());
		System.out.println(above90Names);

		above90Names = students.stream()
				.filter(t->t.getScore()>90)
				.peek(s->s.setName(s.getName()+s.getScore()))
				.map(Student::getName)
				.sorted(Comparator.comparing(s->(String)s).reversed())   // 好神奇，必须转换为String
				.collect(Collectors.toList());
		System.out.println(above90Names);

		above90Names = students.stream()
				.filter(t->t.getScore()>90)
				.peek(s->s.setName(s.getName()+s.getScore()))
				.map(Student::getName)
				.sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());
		System.out.println(above90Names);
	}

	@Test
	public void mapToDouble(){
	    double sum = students.stream()
				.filter(Objects::nonNull)
	            .mapToDouble(Student::getScore)
	            .sum();
		System.out.println(sum);

		sum = students.stream()
				.map(Student::getScore)
				.reduce((a,b)->a+b)
				.orElse(0d);
		System.out.println(sum);
	}

	@Test
	public void flatMap(){
		List<?> words0 = Arrays.stream(new String[] {"a", "b", "c"})  // Arrays.stream可以将一个数组转换为一个流
				.map(s->s.length())
				.collect(Collectors.toList());
		System.out.println(words0);

		List<String> lines = Arrays.asList(new String[]{
		        "hello abc",
		        "老马  编程"
		    });
		List<String> words = lines.stream()
		        .flatMap(line -> Arrays.stream(line.split("\\s+")))
		        .collect(Collectors.toList());
		System.out.println(words);
	}

	@Test
	public void max(){
		Student student = students.stream()
//				.filter(s->s.getScore()>100)
		        .max(Comparator.comparing(Student::getScore).reversed())
		        .orElse(null);
		System.out.println(student);
	}

	@Test
	public void count(){
		long above90Count = students.stream()
		        .filter(t->t.getScore()>90)
		        .count();
		System.out.println(above90Count);
	}

	@Test
	public void allMatch(){
		boolean allPass = students.stream()
		        .allMatch(t->t.getScore()>=60);
		System.out.println(allPass);
	}

	@Test
	public void findAny(){
		String name = students.stream()
		        .filter(t->t.getScore()<60)
		        .findAny().orElseGet(()->new Student("invalid", 0)).getName();
		System.out.println(name);
	}

	@Test
	public void forEach(){
		students.stream()
	        .filter(t->t.getScore()>90)
	        .forEach(System.out::println);
	}

	@Test
	public void toArray(){
		Student[] above90Arr = students.stream()
		        .filter(t->t.getScore()>90)
		        .toArray(Student[]::new);  // 这个产生的student是和students里面的原始对象，并没有新建一个，这里Student[]::new只是给出了类型
		System.out.println(Arrays.asList(above90Arr));
	}
	
	@Test
	public void reduceForTopStudent(){
		Student topStudent = students.stream().reduce((accu, t) -> {
		    if (accu.getScore() >= t.getScore()) {
		        return accu;
		    } else {
		        return t;
		    }
		}).get();
		System.out.println(topStudent);

		topStudent = students.stream().max(
					Comparator.comparing(Student::getScore)
					.thenComparing(Comparator.comparing(Student::getName)).reversed())
				.orElse(null);
		System.out.println(topStudent);
	}

	@Test
	public void reduceForSumScore(){
		double sumScore = students.stream().reduce(0d,
		        (sum, t) -> sum += t.getScore(),
		        (sum1, sum2) -> sum1 += sum2   // 不知道combiner有什么用
		    );
		System.out.println(sumScore);

		sumScore = students.stream().mapToDouble(Student::getScore).sum();
		System.out.println(sumScore);
	}
	
	@Test
	public void array2stream(){
		File[] files = new File(".").listFiles();
		Arrays.stream(files)
		    .filter(File::isFile)
		    .map(File::getName)
		    .forEach(System.out::println);
	}

	@Test
	public void randomNum(){
		Stream.generate(()->Math.random())
		    .limit(10)
		    .forEach(System.out::println);

		Stream<Long> natural = Stream.generate(new NaturalSupplier());
		natural.map((x) -> x * x).limit(10).forEach(System.out::println);

		// 生成斐波那契数列的第21-30项
		Stream<Long> fibonacci = Stream.generate(new FibonacciSupplier());
		List<Long> list = fibonacci.skip(20).limit(10).collect(Collectors.toList());
		System.out.println(list);

		// 计算pi，π/4 = 1 - 1/3 + 1/5 - 1/7 + 1/9 - ...
		Stream<Double> piStream = Stream.generate(new PiSupplier());
		System.out.println(piStream.skip(1000).limit(10).findFirst().orElse(0d));
	}

	@Test
	public void oddNums(){
		Stream.iterate(1, t->t+2)
				.limit(100)
				.filter(n->n<10)
				.forEach(System.out::println);
	}

}
