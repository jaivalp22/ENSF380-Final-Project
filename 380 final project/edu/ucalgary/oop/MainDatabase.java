import java.sql.DriverManager;
import java.sql.SQLException;

public class MainDatabase {

    public void createConnection(){
        try{
            dbConnect = DriverManager.getConnection("jdbc:postgresql://localhost/ensf380project", "oop", "ucalgary");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

public void close() {
        try {
            results.close();
            dbConnect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
