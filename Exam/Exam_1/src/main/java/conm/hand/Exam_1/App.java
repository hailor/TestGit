package conm.hand.Exam_1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("请输入CountryID：");
    	@SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
    	int id=in.nextInt();
    	String sql="SELECT * FROM sakila.country where country_id=89";
        Connection conn=null;//数据库链接
        Statement  st=null;//发送SQL语句
        ResultSet rs=null;//封装从数据库查询到的数据
        try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","110932");
			
			st=(Statement) conn.createStatement();
			rs=st.executeQuery(sql);
		while(rs.next()){
			//PreparedStatement ps=(PreparedStatement) conn.prepareStatement(sql);
				
				System.out.println(rs.getString("country")+"的城市->"+"城市ID"+"\t"+rs.getInt(id)+"\t"+"城市名称"+"\t"+rs.getString("country"));
				//String updateSql="SELECT * FROM sakila.country where country_id=?";
				//PreparedStatement ps=(PreparedStatement) conn.prepareStatement(updateSql);
				//ps.setArray(id, null);;
			}
		} catch (Exception e) {
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
