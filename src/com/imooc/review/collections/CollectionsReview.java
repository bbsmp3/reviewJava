package com.imooc.review.collections;

import java.util.ArrayList;

public class CollectionsReview {
	ArrayList<String> col;
	
	public static void main(String[] args) {
		CollectionsReview rc = new CollectionsReview();
		rc.test1();
		rc.showAll();
	}
	
	public void test1() {
		col =  new ArrayList<String>();
		col.add(null);
		col.add(null);
		col.add("uu");
	}
	
	public void showAll() {
		for(int i = 0; i < col.size(); i++) {
			System.out.println("element " + i +": " + col.get(i));
		}
	}
	
}
