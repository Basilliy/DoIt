package PlainOldJavaObject;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;


public class User {
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

}
