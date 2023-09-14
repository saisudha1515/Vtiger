package dataProvider_Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
	@Test(dataProvider = "getData") //@Test(dataProvider = "getInfo") you can call here also..if do like this make sure there should not be "TypeMismatch" i.e, dataType mismatch..
	public void addProductToCart(String mobileName, String model, String price) {
		System.out.println(mobileName+" - "+model+" - "+price+"\n");
	}

	@DataProvider
	public Object[][] getData(){ // row   cell/column
		Object [][] data = new Object[5][3]; // Since it is an array we can initialize the object array directly with size directly.. 1st array denotes "row" and 2nd arrow denotes "cell/column"..
		/*here 3 2 means, 3 sets of data with 2 fields/cells/columns/information (3X2)*/ // here we are hard coding the data directly not reading from Excel file..
		data[0][0]="Samsung";
		data[0][1]="Sy20";
		data[0][2]="15000";
		
		data[1][0]="Iphone";
		data[1][1]="Ih34";
		data[1][2]="12000";
		
		data[2][0]="Redmi";
		data[2][1]="RY18";
		data[2][2]="19000";
		
		data[3][0]="Oppo";
		data[3][1]="Ou76";
		data[3][2]="20999";
		
		data[4][0]="Poco";
		data[4][1]="Pcu8";
		data[4][2]="23000";
		
		return data; // 2 dimensional object array i am returning..
		
	}
	
	@Test(dataProvider = "getInfo")
	public void addToCart(String name, String model) {
		System.out.println(name+" - "+model+"\n");
	}
		/* n no.of DataProviders we can create in the TestScript */
		@DataProvider
		public Object[][] getInfo(){
			Object[][] data = new Object[3][2];
			data[0][0]="Redmi";
			data[0][1]="RY18";
			
			data[1][0]="Oppo";
			data[1][1]="Ou76";
			
			data[2][0]="Poco";
			data[2][1]="Pcu8";
			
			return data;
		}
	
	}

