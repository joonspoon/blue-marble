package org.curiousworks;

import java.util.ArrayList;

public class BetterString extends ArrayList {
	
	public static void main(String[] args) {
		new BetterString().go();
	}
	
	void go() {
		this.add(3);
		this.add(4);
		this.insert(1, 1);
//		System.out.println(this.toString(this.sum()));
//		System.out.println(this.getRandomElement());
		System.out.println(this.pop());
//		this.getMax();
		//is2D
		//containsNull
		
		//print
		this.print();
		
	}

	private void print() {
		System.out.println(this);
		
	}

	private void insert(int i, int j) {
		// TODO Auto-generated method stub
		
	}

	private Object pop() {
		return this.get(size() - 1);
		
	}


}
