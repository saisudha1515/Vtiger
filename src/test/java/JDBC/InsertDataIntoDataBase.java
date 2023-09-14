package JDBC;
/**
 * 
 * Select query --> ExecuteQuery --> Fetch/read data from DataBase(return data in the form of Table), 
 * Non Select Query --> ExecuteUpdate --> Insert data into DataBase(return data in the form of +ve and/or -ve Integer)
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import com.mysql.jdbc.Driver;

public class InsertDataIntoDataBase {
public static void main(String[] args) throws Exception {
	//Step1 : Create DataBase and register that DataBase Driver
	Driver driverRef = new Driver();
	DriverManager.registerDriver(driverRef);
	
	//Step2 : Give connection to DataBase, for this we require "DriverManager" Class
	  Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qspiders", "root", "Saisudha@123");
	
	 //Step3 : Create the Statement
	  Statement statement = connection.createStatement();
	
	 //Step4 : Call the query
	  String query =  "insert into Employee(name,salary,address) values('MaheshBabu',100000,'Hyderabad')";
	  String query1 =  "insert into Employee(name,salary) values('Amarnath',80000)"; /// here the default location is "AndhraPradesh" since we have not given the location of the Amarnath..
	
	//Step5 : Execute update since it is a non select query which means query starts with anything other than "Select" command
	 int result = statement.executeUpdate(query1); // pass Query as parameter since i want to update the Query// executeUpdate()method will return data in the form of  +ve and/or -ve Integer... not in the form of Table..
    //Step6 : 
	  /**
	   * why result == 1, means when data is updated/inserted in the DataBase then the result will become 1 so when result is 1 which means the data has been updated in the DataBase.. if the data is not updated/inserted in the database the result will be 0.. 
	   */
	  if(result==1) {
		  System.out.println("======== Data updated Successfully =======");
	  }else {
		  System.out.println("======== Data is not Updated ==========");
	    }
    }
}
