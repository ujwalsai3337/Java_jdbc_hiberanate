import java.sql.*;

public class Demojdbc {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/jdbc_demo";
        String user = "postgres";
        String password = "Ujwal@123";

        try {
            // Load PostgreSQL JDBC driver
//            Class.forName("org.postgresql.Driver");

            // Connect to the database
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connection established");
            String sql="insert into student values(6,'janau',443)";
            Statement st=con.createStatement();
            st.executeQuery(sql);
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()) {
                String name =rs.getString("sname");
                System.out.println("the name of the student is " + name);

            };

            // Close the connection
            con.close();
            System.out.println("connection closed");
        } catch (Exception e) {
            System.out.println("error out there "+e);
        }
    }
}
