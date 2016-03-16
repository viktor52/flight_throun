package search;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import search.DB_Connection;

public class SearchFlight {
	DB_Connection db = new DB_Connection();
	
	public String searchDep(){
	      return db.findDep();
	}
	public String searchRet(){
		return "Ret";
	}


}

