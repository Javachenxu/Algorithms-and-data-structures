package com.cx;

import java.util.Comparator;

import com.cx.printer.BinaryTrees;

public class Main {
	
	private static class PersonComparetor implements Comparator<Person> {
		@Override
		public int compare(Person e1, Person e2) {
			// TODO Auto-generated method stub
			return e1.getAge() - e2.getAge();
		}
	}
	
	private static class PersonComparetor2 implements Comparator<Person> {
		@Override
		public int compare(Person e1, Person e2) {
			// TODO Auto-generated method stub
			return e2.getAge() - e1.getAge();
		}
	}

	public static void main(String[] args) {
	Integer data[] = new Integer[] {
			7,4,9,2,5,8,11,3,1,12,6,25
	};
	BinarySearchtree<Integer> bst = new BinarySearchtree<>();
	for (int i = 0; i < data.length; i++) {
		bst.add(data[i]);
		}
	BinaryTrees.println(bst);
	/*BinarySearchtree<Person> bst4 = new BinarySearchtree<>(new PersonComparetor());
	bst4.add(new Person(12));
	bst4.add(new Person(15));

	BinarySearchtree<Person> bst3 = new BinarySearchtree<>(new PersonComparetor2());
	bst3.add(new Person(12));
	bst3.add(new Person(15));
	}*/
	}

}


