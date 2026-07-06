import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.*;

public class CrudOperations{

    public static final String url = "jdbc:mysql://localhost:3306/demoscoe";
    public static final String user = "root";
    public static final String password = "sasuekzzz";

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        Connection con = DriverManager.getConnection(url,user,password);

        String sqlQuerry = "Insert into student(id,name,dept) values (?,?,?);";
        PreparedStatement pr = con.prepareStatement(sqlQuerry);

        pr.setInt(1,100);
        pr.setString(2,"Student1");
        pr.setString(3,"Computer");

        
    }


}