package search;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DB_Connection {
	private static Connection c = null;
    private static Statement stmt = null;
    private static String url = "jdbc:postgresql://localhost:5432/plains";
    private static String user = "viktor";
	public static String findDep(){ 
    String s = null;
    try {
       Class.forName("org.postgresql.Driver");
       c = DriverManager.getConnection(url, user, "");
       stmt = c.createStatement();
	      ResultSet rs = stmt.executeQuery( "SELECT * FROM flight;" );
	      while ( rs.next() ) {
	            s = rs.getString("number") + rs.getString("airport");
	         }
    } catch (Exception e) {
       e.printStackTrace();
       System.err.println(e.getClass().getName()+": "+e.getMessage());
       System.exit(0);
    }
    System.out.println("Opened database successfully");
    return s;
	}

}
