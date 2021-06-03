package tool;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnetion {
    private Connection con;

    public DbConnetion() {
        String className = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/java?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC";
        String userName = "root";
        String password = "123123";
        try {
            Class.forName(className);
            con = DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getCon() {
        return con;
    }
}
