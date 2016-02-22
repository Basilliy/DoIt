package PlainOldJavaObject;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

/**
 * Created by russik on 21.02.2016.
 */
public class List {

    //int UserId;
    boolean deleteble;
    boolean privat;
    String ListName;
    int number;

    public void SetDeleteble(boolean deleteble){
        this.deleteble = deleteble;
    }

    public boolean GetDeleteble(){
        return deleteble;
    }

    public void SetPrivat(boolean privat){
        this.privat = privat;
    }

    public boolean GetPrivat(){
        return privat;
    }

    public void SetListName(String ListName){
        this.ListName = ListName;
    }

    public String GetListName(){
        return ListName;
    }

    public void SetNumber(int number){
        this.number = number;
    }

    public int GetNumber(){
        return number;
    }


}
