import java.sql.*;
import java.sql.SQLException;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i =0;
        while(i<4){
            String message = sc.nextLine();
            System.out.println("hello, i'm "+message);
            i++;
        }
    }

    public void updateMember(MemberVO vo){
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        MemberVO vo = null;

        try {

        Class.forName("oracle.jdbc.driver.OracleDriver");
        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", 
        "scott", "tiger");
        String sql = "select * from student where id=?";
        pstmt = con.prepareStatement(sql);
        pstmt.setString(1, "id");
        rs = pstmt.executeQuery();

        if(rs.next()){
            vo = new MemberVO();
            vo.setId(rs.getString("id"));
            vo.setPass(rs.getString("pass"));
            vo.setZip(rs.getString("zip"));
            vo.setAddress(rs.getString("address"));
        }
        
        } catch (SQLException se) {
            se.printStackTrace();
        }

        finally{
            if(con!=null){
                try {
                    con.close();
                } catch (SQLException ss) {
                    ss.printStackTrace();
                }
            }
                if(pstmt!=null){
                try {
                    pstmt.close();
                } catch (SQLException ss) {
                    ss.printStackTrace();
                }
            }
                if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ss) {
                    ss.printStackTrace();
                }
            }
        }
    }
}

