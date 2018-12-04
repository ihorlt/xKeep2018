package ua.keep.controller.dao.reporitory;

import ua.keep.controller.dao.entities.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Getting / Putting Data into / from Database
 */
public class UserRepository {

    public User getUserByEmailByPassword(String email, String password) {
        DataSource dataSource = new DataSource();

        String query = "SELECT id, userName, email, password, role FROM user " +
                "WHERE user.email='" + email + "' AND user.password='" + password + "'";

        try ( Connection conn = dataSource.getConnection();
              Statement stmt = conn.createStatement();
              ResultSet rs = stmt.executeQuery(query);
        ) {
            if ( rs.next() ) {
                User user = new User(
                        rs.getLong("id"),
                        rs.getString("userName"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getInt("role")
                );

                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}
