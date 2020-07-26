package shuo.laoma.java8.c91;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ListUtilYk {

	static class Student {
	    String name;
	    double score;
	    
	    public Student(String name, double score) {
	        this.name = name;
	        this.score = score;
	    }

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public double getScore() {
			return score;
		}

		public void setScore(double score) {
			this.score = score;
		}

        public static String getCollegeName(){
            return "Laoma School";
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", score=" + score +
                    '}';
        }
    }
	
	public static <E> List<E> filter(List<E> list, Predicate<E> pred) {
	    List<E> retList = new ArrayList<>();
	    for (E e : list) {
	        if (pred.test(e)) {
	            retList.add(e);
	        }
	    }
	    return retList;
	}
	
	public static <T, R> List<R> map(List<T> list, Function<T, R> mapper) {
	    List<R> retList = new ArrayList<>(list.size());
	    for (T e : list) {
	        retList.add(mapper.apply(e));
	    }
	    return retList;
	}
	
    public static <E> void foreach(List<E> list, Consumer<E> consumer) {
        for (E e : list) {
            consumer.accept(e);
        }
    }

    public static <E, R> List<R> getCollegeName(List<E> list, Supplier<R> supplier) {
        List<R> retList = new ArrayList<>(list.size());
        for (E e : list) {
            retList.add(supplier.get());
        }
        return retList;
    }

	
	public static void main(String[] args) {
		List<Student> students = Arrays.asList(new Student[] {
		        new Student("zhangsan", 89d),
		        new Student("lisi", 89d),
		        new Student("wangwu", 98d) });
		
		// 过滤90分以上的
		students = filter(students, t -> t.getScore() > 90);

		//根据学生列表返回名称列表
		List<String> names = map(students, t -> t.getName());
		
		//将学生名称转换为大写
		students = map(students, t -> new Student(t.getName().toUpperCase(), t.getScore()));
		
		foreach(students, t -> t.setName(t.getName().toUpperCase()));
	}

	@Test
	public void testStudent() {
		List<Student> students = Arrays.asList(new Student[] {
				new Student("zhangsan", 89d),
				new Student("lisi", 89d),
				new Student("wangwu", 98d) });

		// filter
		List<Student> passStudents = filter(students, student -> student.getScore()>90);
        System.out.println(Arrays.toString(passStudents.toArray()));

        // map
        List<String> names = map(passStudents, t -> t.getName().toUpperCase());
        System.out.println(Arrays.toString(names.toArray()));
        students = map(students, student -> new Student(student.getName().toUpperCase(), student.getScore()));
        System.out.println(Arrays.toString(students.toArray()));

        // forEach
        foreach(students, student -> student.setScore(70));
        System.out.println(Arrays.toString(students.toArray()));

        // 以上这些示例主要用于演示函数式接口的基本概念，实际中应该使用下节介绍的流API。

        List<String> collegeNames = getCollegeName(students, Student::getCollegeName);
        System.out.println(Arrays.toString(collegeNames.toArray()));

    }

    @Test
	public void testComparator() {
		List<Student> students = Arrays.asList(new Student[] {
				new Student("zhangsan", 89d),
				new Student("lisi", 89d),
				new Student("wangwu", 98d) });
		students.sort(Comparator.comparing(Student::getScore)
				.reversed()
				.thenComparing(Student::getName));
		System.out.println(Arrays.toString(students.toArray()));

	}


}
