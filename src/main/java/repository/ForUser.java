package repository;

import PlainOldJavaObject.User;
import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

/**
 * Created by russik on 22.02.2016.
 */
public class ForUser {

    private static final String URL = "jdbc:mysql://localhost:3306/trello_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public boolean SingIn(){
        User user = new User();
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);

        } catch (SQLException e) {
            System.err.println("We have trouble CAP");
        }
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            PreparedStatement pr_statement = connection.prepareStatement("select * from table users where User_login = ? AND Password = ?");
            pr_statement.setString(1, user.GetLogin());
            pr_statement.setString(2, user.GetPassword());


            ResultSet res = pr_statement.executeQuery();

            if (res.next()) {
                connection.close();
                return true;
            } else {
                connection.close();
                return false;
            }
        } catch (SQLException e) {
            System.err.println("We have trouble CAP_2");
        }
        return false;
    }

    public boolean SingUp(){
        User user = new User();
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);

        } catch (SQLException e) {
            System.err.println("We have trouble CAP");
        }
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            PreparedStatement pr_statement = connection.prepareStatement("select * from table users where User_login = ? AND Password = ?");
            pr_statement.setString(1, user.GetLogin());
            pr_statement.setString(2, user.GetPassword());;

            ResultSet res = pr_statement.executeQuery();

            if (!res.next()) {
                PreparedStatement Ins_statement = connection.prepareStatement("INSERT INTO users (User_login, Password) VALUES (?, ?)");
                pr_statement.setString(1, user.GetLogin());
                pr_statement.setString(2, user.GetPassword());;
                pr_statement.execute();
                PreparedStatement Ins_statement_2 = connection.prepareStatement("INSERT INTO user_settings (user_name, user_picture, BG_color) VALUES (?, ?, ?)");
                Ins_statement_2.setString(1, user.GetName());
                Ins_statement_2.setString(2, user.GetPicture());
                Ins_statement_2.setString(3, user.GetBgColor());
                Ins_statement_2.execute();
                connection.close();
                return true;
            }
            else { connection.close();return false;}

        } catch (SQLException e) {
            System.err.println("We have trouble CAP_2");
        }

        return true;
    }

    public boolean redaction(int id){
        User user = new User();
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);

        } catch (SQLException e) {
            System.err.println("We have trouble CAP");
        }
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement pr_statement = connection.prepareStatement("select * from table users where id = ? ");
            pr_statement.setInt(1, id);
            ResultSet res = pr_statement.executeQuery();
            if(res.next()){
                PreparedStatement pr_statement_2 = connection.prepareStatement("UPDATE user_setting SET user_name = ?, user_picture = ?, BG_color = ? WHERE id_user = ?");
                pr_statement_2.setString(1, user.GetName());
                pr_statement_2.setString(2, user.GetPicture());
                pr_statement_2.setString(3, user.GetBgColor());
                pr_statement_2.setInt(4, id);
                pr_statement_2.execute();
                connection.close();
                return true;
            }
            else {
                connection.close();
                return false;}
        } catch (SQLException e) {
            System.err.println("We have trouble CAP_2");
        }

        return true;
    }

    public int GetId(){
        int id = 0;
        User user = new User();
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);

        } catch (SQLException e) {
            System.err.println("We have trouble CAP");
        }

        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement pr_statement = connection.prepareStatement("select id from table users where User_login = ? AND Password = ?");
            pr_statement.setString(1, user.GetLogin());
            pr_statement.setString(2, user.GetPassword());
            ResultSet res = pr_statement.executeQuery();
            res.next();
            id = res.getInt(1);
        } catch (SQLException e) {
            System.err.println("We have trouble CAP_2");
        }
        return id;
    }

}
