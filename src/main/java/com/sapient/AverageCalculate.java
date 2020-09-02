/**
 * 
 *//**
 * 
 */
package com.sapient;

/**
 * @author Pankush
 *
 */

import java.io.IOException;
import java.util.Collections;
import java.util.List;


public class App 
{
    public static void main( String[] args )
    {
    	String inputFile = "input.csv";
		String outputFile = "output.csv";
		
		IncomeCalcuate Ic = new IncomeCalcuate();
		
		try {
			
			Ic.ReadFile(inputFile);
			List<String> MyList=AverageCalculate.average(Ic.map);
			Collections.sort(MyList);
			Ic.WriteFile(MyList,outputFile);
			
		} catch (IOException e) {
			e.printStackTrace();
}
    }
}
