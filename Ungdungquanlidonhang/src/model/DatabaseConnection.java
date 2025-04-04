package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL =
            "jdbc:sqlserver://localhost:1433;databaseName=QuanLyDonHang;user=sa;password=123456789;encrypt=true;trustServerCertificate=true;";


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}
