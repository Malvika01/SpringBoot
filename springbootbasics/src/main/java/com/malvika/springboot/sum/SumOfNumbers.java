package com.malvika.springboot.sum;

import org.springframework.stereotype.Repository;

@Repository
public class SumOfNumbers {
	

public int sum(int a,int b) {
	return a+b;
}
}
