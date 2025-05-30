package testNGTests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class streamDemo {


@Test
public void sFilter() {

	ArrayList<String> names = new ArrayList<>();
	names.add("Adam");
	names.add("Amy");
	names.add("Andrew");
	names.add("Edward");
	names.add("Donald");
	names.add("Elly");
	names.add("Don");
	names.add("Dave");
	
	for(int i=0; i<names.size(); i++) {
		System.out.println(names.get(i));
	}

	Long c = names.stream().filter(s->s.startsWith("A")).count();
	System.out.println(c);
	
	Long e= Stream.of("Donald", "Don", "Adam", "Amy", "Davidd").filter(s->
	{
		s.startsWith("A");
		return true;
	}).count();
	System.out.println(e);
	
	//names.stream().filter(s->s.length()>5).forEach(s->System.out.println(s));
	names.stream().filter(s->s.length()>5).limit(1).forEach(s->System.out.println(s));
}



@Test
public void stremMap() {
	
	//print names of length with upper case
	Stream.of("Donald", "Don", "Adam", "Amy", "Davidd").filter(s->s.endsWith("d")).
	map(s->s.toUpperCase()).forEach(s->System.out.println(s));
	
	//print names which have first letter as "a" with upper case and sorted
	List<String> name1 = Arrays.asList("Ash", "Den", "Ada", "Am");
	name1.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase())
	.forEach(s->System.out.println(s));
	
	//Concatenate name1 and name2
	List<String> name2 = Arrays.asList("Ash", "Ethan", "Ada", "Noah");
	
	Stream<String> concat = Stream.concat(name1.stream(), name2.stream());
	concat.sorted().distinct().forEach(s->System.out.println("++++++"+s));
	
	//Check if an element is present
	List<String> name3 = Arrays.asList("Liam", "Lucas", "jack", "Leo", "Ash");
	boolean flag = name3.contains("Liam");
	Assert.assertTrue(flag);
	
	//Check if an element is present between 2 arrays
	Stream<String> concat2 = Stream.concat(name2.stream(), name3.stream());
	boolean flag2= concat2.anyMatch(s->s.equalsIgnoreCase("Ash"));
	System.out.println(flag2);
	Assert.assertTrue(flag2);
	
	
	//distinct
	List<String> num = Arrays.asList("1", "2", "2", "3", "4", "4");
	num.stream().distinct().collect(Collectors.toList())
	.forEach(s->System.out.println(s));
	
	Stream<String> concat3 = Stream.concat(name2.stream(), name3.stream());
	concat3.distinct().collect(Collectors.toList()).forEach(s->System.out.println(s));
	
}
@Test
public void streamCollect() {
	
	List<String> sc = Stream.of("Donald", "Don", "Adam", "Amy", "Davidd").filter(s->s.endsWith("d")).
	map(s->s.toUpperCase()).collect(Collectors.toList());
	
	System.out.println("****"+sc.get(1));
	
	//get specific value from a list
	
	List<Integer> values = Arrays.asList(2, 3, 3, 7, 1, 4, 7);
	values.stream().distinct().sorted().forEach(s->System.out.println(s));
	List<Integer> li = values.stream().distinct().sorted().collect(Collectors.toList());
	System.out.println(li.get(0));
	
}

}





