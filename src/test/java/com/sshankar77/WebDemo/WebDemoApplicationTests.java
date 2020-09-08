package com.sshankar77.WebDemo;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sshankar77.WebDemo.service.CalcService;

@SpringBootTest
class WebDemoApplicationTests {

	@Autowired
	private CalcService cser;

	@Test
	public void testcase01() {
		assertEquals(cser.validatenum("12"),true);
		System.out.println("validatenum(12)"+"true");

		assertEquals(cser.validatenum("12asd"),false);
		System.out.println("validatenum(12asd)"+"true");
		
		assertEquals(cser.validatenum("12.0"),true);
		System.out.println("validatenum(12.0)"+"true");

		assertEquals(cser.validatenum("-12.0"),true);
		System.out.println("validatenum(-12.0)"+"true");

//		assertEquals(cser.validatenum("12asd",true);
	}

	@Test
	public void testcase02() {
		System.out.println("calc(12+123)"+cser.calc("12","123",'+'));
		assertEquals(cser.calc("12","123",'+'),"135.0");

		System.out.println("calc(12-123)"+cser.calc("12","123",'-'));
		assertEquals(cser.calc("12","123",'-'),"-111.0");

		System.out.println("calc(123-12)"+cser.calc("123","12",'-'));
		assertEquals(cser.calc("123","12",'-'),"111.0");

		System.out.println("calc(123-123)"+cser.calc("123","123",'-'));
		assertEquals(cser.calc("123","123",'-'),"0.0");

		System.out.println("calc(12*123)"+cser.calc("12","123",'*'));
		assertEquals(cser.calc("12","123",'*'),"1476.0");

		System.out.println("calc(120*30)"+cser.calc("120","30",'*'));
		assertEquals(cser.calc("120","30",'*'),"3600.0");

		System.out.println("calc(121/12)"+cser.calc("121","11",'/'));
		assertEquals(cser.calc("121","11",'/'),"11.0");

		System.out.println("calc(12/123)"+cser.calc("12","123",'/'));
		assertEquals(cser.calc("12","123",'/'),"0.0975609756097561");

	}
}
