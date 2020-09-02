/**
 * 
 */
package com.sapient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AverageCalculate {

	public static List<String> average(HashMap<String, MyClass> map) {
		
		
		List<String> MyString = new ArrayList<String>();
		
		
		for( var temp:map.entrySet())
		{
			MyClass Myclass=temp.getValue();
			Double amount=Myclass.amount/Myclass.people;
			amount=Math.round(amount*100)/100.0;
			MyString.add(temp.getKey()+","+amount);
		}
		
		
		return MyString;
	}
}
