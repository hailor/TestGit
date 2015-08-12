package conm.hand.Eaxm_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("Customer请输入ID：");
    	Scanner in=new Scanner(System.in);
    	int id=in.nextInt();
    	String sql="SELECT * FROM sakila.customer where customer_id=2";
        Connection conn=null;
        Statement  st=null;
        ResultSet rs=null;
      try{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","110932");
			
			st=(Statement) conn.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()){
				
				
					
			
			}
      }catch (Exception e) {
		e.printStackTrace();
	}finally{
		try {
			rs.close();//由小到大关闭
		} catch (Exception e2) {
			// TODO: handle exception
		}
		try {
			st.close();
		} catch (Exception e2) {
			
		}
	}try {
		conn.close();
	} catch (Exception e) {
		
	}
	}
    
}
