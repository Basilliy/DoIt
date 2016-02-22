package repository;

import PlainOldJavaObject.List;
import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

/**
 * Created by russik on 22.02.2016.
 */
public class ForList {

    private static final String URL = "jdbc:mysql://localhost:3306/trello_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public void AddList(int UserId){
        List list = new List();
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);

        } catch (SQLException e) {
            System.err.println("We have trouble CAP");
        }
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            PreparedStatement pr_statement = connection.prepareStatement("INSERT INTO lists (User_id, Deleteble, Privat, List_name, List_number)" +
                    "VALUES (?, ?, ?, ?, ?)");
            pr_statement.setInt(1, UserId);
            pr_statement.setBoolean(2,list.GetDeleteble());
            pr_statement.setBoolean(3, list.GetPrivat());
            pr_statement.setString(4, list.GetListName());
            pr_statement.setInt(5, list.GetNumber());
            pr_statement.execute();

            // ResultSet res = pr_statement.executeQuery();
            connection.close();
        } catch (SQLException e) {
            System.err.println("We have trouble CAP_2");
        }
    }
    public void RenameListName(int Id){
        List list = new List();
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            System.err.println("We have trouble CAP");
        }
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement pr_statement_2 = connection.prepareStatement("UPDATE lists SET List_name = ? WHERE id = ?");
            pr_statement_2.setString(1, list.GetListName());
            pr_statement_2.setInt(2, Id);
            pr_statement_2.execute();
            connection.close();

        } catch (SQLException e) {
            System.err.println("We have trouble CAP_2");
        }
    }

    public void RenameListNumber(int Id){
        List list = new List();
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            System.err.println("We have trouble CAP");
        }
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement pr_statement_2 = connection.prepareStatement("UPDATE lists SET List_number = ? WHERE id = ?");
            pr_statement_2.setInt(1, list.GetNumber());
            pr_statement_2.setInt(2, Id);
            pr_statement_2.execute();
            connection.close();
        } catch (SQLException e) {
            System.err.println("We have trouble CAP_2");
        }
    }

    public void DeleteList(int Id){
        List list = new List();

        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            System.err.println("We have trouble CAP");
        }
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement pr_statement_2 = connection.prepareStatement("DELETE * FROM lists WHERE id = ?");
            pr_statement_2.setInt(1, Id);
            pr_statement_2.execute();
            connection.close();

        } catch (SQLException e) {
            System.err.println("We have trouble CAP_2");
        }
    }
    public void ShowList(int Id){
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            System.err.println("We have trouble CAP");
        }
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement pr_statement_2 = connection.prepareStatement("SELECT * FROM lists WHERE id = ?");
            pr_statement_2.setInt(1, Id);
            ResultSet res = pr_statement_2.executeQuery();
            res.next();
            connection.close();
            /////////////ДОДЕЛАТЬ <<---
        } catch (SQLException e) {
            System.err.println("We have trouble CAP_2");
        }

    }
}
