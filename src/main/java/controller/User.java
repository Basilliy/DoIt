package controller;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;


public class User {

    private static final String URL = "jdbc:mysql://localhost:3306/trello_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    String login;
    String password;
    String name;
    String picture;
    String bgColor;
    int id;

    public void SetLogin(String login) {
        this.login = login;
    }

    public String GetLogin() {
        return login;
    }

    public void SetPassword(String password) {
        this.password = password;
    }

    public String GetPassword() {
        return password;
    }

    public void SetName(String name) {
        this.name = name;
    }

    public String GetName() {
        return name;
    }

    public void SetPicture(String picture) {
        this.picture = picture;
    }

    public String GetPicture() {
        return picture;
    }

    public void SetBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    public String GetBgColor() {
        return bgColor;
    }

    public boolean SingIn(){
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);

        } catch (SQLException e) {
            System.err.println("We have trouble CAP");
        }
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            PreparedStatement pr_statement = connection.prepareStatement("select * from table users where User_login = ? AND Password = ?");
            pr_statement.setString(1, login);
            pr_statement.setString(2, password);

            
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
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);

        } catch (SQLException e) {
            System.err.println("We have trouble CAP");
        }
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            PreparedStatement pr_statement = connection.prepareStatement("select * from table users where User_login = ? AND Password = ?");
            pr_statement.setString(1, login);
            pr_statement.setString(2, password);

            ResultSet res = pr_statement.executeQuery();

            if (res.next()) {
                PreparedStatement Ins_statement = connection.prepareStatement("INSERT INTO users (User_login, Password) VALUES (?, ?)");
                Ins_statement.setString(1, login);
                Ins_statement.setString(2, password);
                Ins_statement.execute();
                PreparedStatement Ins_statement_2 = connection.prepareStatement("INSERT INTO user_settings (user_name, user_picture, BG_color) VALUES (?, ?, ?)");
                Ins_statement_2.setString(1, name);
                Ins_statement_2.setString(2, picture);
                Ins_statement_2.setString(3, bgColor);
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
                PreparedStatement pr_statement_2 = connection.prepareStatement("UPDATE user_setting SET user_name = ?, user_picture = ?, BG_color = ? WHERE id_user = id");
                pr_statement_2.setString(1, name);
                pr_statement_2.setString(2, picture);
                pr_statement_2.setString(3, bgColor);
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
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);

        } catch (SQLException e) {
            System.err.println("We have trouble CAP");
        }

        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement pr_statement = connection.prepareStatement("select id from table users where User_login = ? AND Password = ?");
            pr_statement.setString(1, login);
            pr_statement.setString(2, password);
            ResultSet res = pr_statement.executeQuery();
            res.next();
            id = res.getInt(1);
        } catch (SQLException e) {
            System.err.println("We have trouble CAP_2");
        }
        return id;
    }
}
