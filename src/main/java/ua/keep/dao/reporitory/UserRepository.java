package ua.keep.dao.reporitory;

import ua.keep.dao.entities.User;

import java.sql.*;

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

    public void saveUser(User user) {
        DataSource dataSource = new DataSource();
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement("INSERT INTO user (userName, email, password) VALUES (?,?,?)")
        ) {
            stmt.setString(1, user.getUserName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());

            stmt.executeUpdate();
        }  catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
