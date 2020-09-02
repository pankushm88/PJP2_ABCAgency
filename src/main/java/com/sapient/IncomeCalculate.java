/**
 * 
 */
package com.sapient;

/**
 * @author Pankush
 *
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class IncomeCalculate {


	HashMap<String,MyClass> map=new HashMap<String,MyClass>();



	public void ReadFile(String InputLocation) throws IOException
	{
		
		PojoClass p=new PojoClass();
		String[] Fields;
		BufferedReader bf= new BufferedReader(new FileReader(InputLocation));
		String line="";
		
		
		while ((line=bf.readLine())!=null)
		{

			Fields=line.split(",");
			p.city=Fields[0].toUpperCase();
			p.country=Fields[1].toUpperCase();
			p.gender=Fields[2].toUpperCase();
			p.TypeOfCurrency=Fields[3].toUpperCase();
			p.amount=convertintoUSD(Double.parseDouble(Fields[4]),p.TypeOfCurrency);
			

			StoreAmounOffEachTypeCurrency(p);
			
		}
		bf.close();
		
	}

	
	private void StoreAmounOffEachTypeCurrency(PojoClass p) 
	
	{
		
		String s=null;
		if((p.city).isEmpty())
		{
			s=p.country+","+p.gender;	
		}
		else 
		{
			s=p.city+","+p.gender;
		}
		
		
			if(map.containsKey(s))
			{
				MyClass Myclass=map.get(s);
				Myclass.setAmount(p.amount+Myclass.getAmount());
				Myclass.setPeople(Myclass.getPeople()+1);
				map.put(s, Myclass);
				
			}
			else
			{
				MyClass Myclass=new MyClass(p.amount,1);
				map.put(s, Myclass);
			}	
	}

	

	private Double convertintoUSD(Double amount,String TypeOfCurrency) {
		
		if(TypeOfCurrency.equals("INR"))
		{
			amount=amount/66;
		}
		else if(TypeOfCurrency.equals("GBP"))
		{
			amount=amount/0.67;
		}

		else if(TypeOfCurrency.equals("SGD"))
		{
			amount=amount/1.5;
		}	

		else if(TypeOfCurrency.equals("HKD"))
		{
			amount=amount/8;
		}
		
		return amount;
	}


	public void WriteFile(List<String> MyList,String OutputLocation) throws IOException
	{
		FileWriter MyWriter = new FileWriter(OutputLocation);

		for (String temp : MyList)
			MyWriter.write(temp + "\n");

			MyWriter.close();
		
	}
}
