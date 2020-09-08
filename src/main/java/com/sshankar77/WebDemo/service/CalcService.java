package com.sshankar77.WebDemo.service;

import org.springframework.stereotype.Service;

@Service
public class CalcService {
    public boolean validatenum(String num) {
    	try{
    		Double.parseDouble(num);
    		return true;
    	}
    	catch (NumberFormatException e) {
    		return false;
    	}
    }
    public String calc(String num1,String num2,char operation) {
    	Double dnum1 = Double.parseDouble(num1);
    	Double dnum2 = Double.parseDouble(num2);
    	Double res = 0.00;
    	switch (operation) {
    		case '+':
    			res = dnum1 + dnum2;
    			break;
    		case '-':
    			res = dnum1 - dnum2;
    			break;
    		case '*':
    			res = dnum1 * dnum2;
    			break;
    		case '/':
    			res = dnum1 / dnum2;
    			break;
    	}
//    	System.out.println("dnum1="+dnum1);
//    	System.out.println("dnum2="+dnum2);
//    	System.out.println("res="+res);
//    	System.out.println("<=====>");
        return Double.toString(res);
    }
}
