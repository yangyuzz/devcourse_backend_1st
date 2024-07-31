package test01;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection conn= null;
        String SQL = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            // 1. 커넥션 생성
            conn = DriverManager.getConnection("jdbc:mysql://59.27.84.200:3306/workshop","grepp","grepp");
            // 2. SQL 작성
            SQL = "insert into book_tb(title, writer, price, publisher) values('mysql easyzz','yangyu',30000,'grepp')";
            // 3. PreparedStatement or Statement에 명령어 담기
            pstmt = conn.prepareStatement(SQL); // Statement는 이렇게 미리 SQL을 넣지 않고 execute 하는 시점에 넣는 차이가 있음.
            // 4. 실행하기
            //  4.1 insert/update/delete : int
            //  4.2 select : ResultSet
            int result = pstmt.executeUpdate();
            // 5. 결과값 처리
            System.out.println("SQL 실행이 완료되었습니다."+result);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            // 6. 사용 완료한 리소스 반납(생성한 순서의 역순으로)
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

            if(pstmt!=null){
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
