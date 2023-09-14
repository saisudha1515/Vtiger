package JDBC;
/**
 * 
 * Select query --> ExecuteQuery --> Fetch/read data from DataBase(return data in the form of Table), 
 * Non Select Query --> ExecuteUpdate --> Insert data into DataBase(return data in the form of +ve and/or -ve Integer)
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ReadDataFromDataBase {
	public static void main(String[] args) throws Exception {
//		// Step1 : Create DataBase and every DataBase will have it's own Driver.. so register that Driver 
		Driver driverRef = new Driver();
//		// class "DriverManager" is needed..
		DriverManager.registerDriver(driverRef);
		
//		// Step2 : Give connection to Database
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qspiders", "root","Saisudha@123");
		
//		// Step3 : write Statement
		Statement statement = connection.createStatement();
		
//		// Step4 : Call the query
		String query = "select * from Employee";
		
//		// Step5 : Execute the query since it is a "selectQuery" which means a query starts with "select" command
		ResultSet result = statement.executeQuery(query); // it will return data in the form of "Table"
		
//		// Step6 : Read/Fetech data from Employee database using While loop (if resultcontains any data fetch it)  // "\t" is for space
		// getString()will convert every thing (whatever you want to try to fetch it from DB) in the form of String and print in the console..  
		while (result.next()) {
		System.out.println(result.getString(1) + "\t" + result.getString(2) + "\t" + result.getString(3));	
		}
		//Step7 : Close the DataBase Connection in order to avoid Memory leakage..
		connection.close();
//=======================================================================================
//		// register driver
//		Driver driverRef1 = new Driver();
//		DriverManager.registerDriver(driverRef1);
//		// Give connection to DataBase
//		Connection connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/database name", "root",
//				"Saisudha@123");
//		// Write Statement
//		Statement statement1 = connection1.createStatement();
//		// call query
//		String query1 = "select * from Employee";
//		// Execute Query
//		ResultSet result1 = statement1.executeQuery(query1);
//		while (result1.next()) {
//			System.out.println(result.getString(3));
//		}
//		connection1.close();
//		
//		/*getString(int columnIndex);// will accept only one column Index form Table
//		getString(String ColumnLable)l'' it will accept all the indexes of the table*/
	    }
    }
