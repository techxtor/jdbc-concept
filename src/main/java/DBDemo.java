import java.sql.*;

public class DBDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

//        Class.forName("Alpha"); // just for concept

        // Query(s)
        String selectOneQuery = "select userName from student where userId=2";
        String selectAllQuery = "select * from student";
        String addStudentQuery = "insert into student values (3, 'Mohini')";
        String preparedQuery = "insert into student values (?,?)";

        // STEP 1: setup connection
        Connection conn = getConnection();

        // STEP 2: setup statements
        Statement st = conn.createStatement(); // statement
        PreparedStatement pSt = conn.prepareStatement(preparedQuery); //prepared statement

        // STEP 3: execute query
        ExecuteQuery executeQuery = new ExecuteQuery();

        executeQuery.executeSelectOneQuery(st, selectOneQuery);
        executeQuery.executeSelectAllQuery(st, selectAllQuery);
        executeQuery.executeInsertStudentQuery(st, addStudentQuery);
        executeQuery.executeInsertStudentQuery(pSt, 4, "Sunny");

        // STEP 4: close connection
        st.close();
        conn.close();
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/techxtor";
        String uname = "root";
        String pass = "root";

        // loads the Driver() class
        // Driver() class has static block with resisters the driver
//        DriverManager.registerDriver(new com.mysql.jdbc.Driver());

        // is same as above line
        Class.forName("com.mysql.jdbc.Driver");

        return DriverManager.getConnection(url, uname, pass);
    }
}

class Alpha {
    static {
        System.out.println("Hi! from static block");
    }
    {
        System.out.println("Hi! from static block");
    }
}
