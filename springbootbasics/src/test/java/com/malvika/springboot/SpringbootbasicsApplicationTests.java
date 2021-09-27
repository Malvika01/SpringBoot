package com.malvika.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.malvika.springboot.sum.SumOfNumbers;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SpringbootbasicsApplicationTests {
	
	@Autowired 
	SumOfNumbers num;

	@Test
	void testSum() {
		assertEquals(5,num.sum(2,3));
	}

}
