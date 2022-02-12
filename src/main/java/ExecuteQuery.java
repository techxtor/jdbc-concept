import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteQuery {
    public void executeSelectOneQuery(Statement st, String selectOneQuery) throws SQLException {
        ResultSet rs = st.executeQuery(selectOneQuery);
        rs.next();
        String name = rs.getString("userName");
        System.out.println(name);
    }
    public void executeSelectAllQuery(Statement st, String selectAllQuery) throws SQLException {
        ResultSet rs = st.executeQuery(selectAllQuery);
        while (rs.next()) {
            String userData = rs.getInt(1) + " : " + rs.getString(2);
            System.out.println(userData);
        }
    }
    public void executeInsertStudentQuery(Statement st, String addStudentQuery) throws SQLException {
        int count = st.executeUpdate(addStudentQuery);
        System.out.println(count + " row(s) affected");
    }

    public void executeInsertStudentQuery(PreparedStatement pSt, int userId, String userName) throws SQLException {
        pSt.setInt(1, userId);
        pSt.setString(2, userName);
        int count = pSt.executeUpdate();
        System.out.println(count + " row(s) affected");
    }
}
