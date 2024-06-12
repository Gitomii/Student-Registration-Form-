package stud;
import java.sql.*;
public class om {
public static void main(String[]om)throws ClassNotFoundException , SQLException  {
	
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost/reg","root","srushti");
	System.out.println("created");
	
	Statement st=con.createStatement();
	String q1="select * from emp";
	String q2="update emp set eid=eid+1 where eid>2";
	
	boolean status=false;
	if(status) {
		System.out.println("selection...");
		ResultSet rs=st.getResultSet();
		
		while(rs.next()) {
			System.out.println(rs.getInt(1)+""+rs.getString(2));
			
		}
	}
	else {
		int a=st.getUpdateCount();
		System.out.println("updated="+a);
		
	}
	st.close();
	con.close();
	System.out.println("closed");
	
}
}
