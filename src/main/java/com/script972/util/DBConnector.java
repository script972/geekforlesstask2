package com.script972.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBConnector {
    private String host="jdbc:mysql://localhost:3306/task2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private String username="root";
    private String password="root";

    private Connection connection;

    public DBConnector() {
        initProperties();
        try {
            connection= DriverManager.getConnection(host, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        createTable();
    }

    private void initProperties() {
        Properties props = new Properties();
        try {
            props.load(new FileInputStream(new File("dbsetting.ini")));
            this.host = props.getProperty("HOST");
            this.username = props.getProperty("USERNAME");
            this.password=props.getProperty("PASSWORD");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void createTable() {
        String sqlQuery="CREATE TABLE IF NOT EXISTS  receipt" +
                "(" +
                "    id INT PRIMARY KEY AUTO_INCREMENT," +
                "    name VARCHAR(255)," +
                "    town VARCHAR(255)," +
                "    passport_ser TINYTEXT," +
                "    number INT," +
                "    take VARCHAR(500)," +
                "    home VARCHAR(500)," +
                "    landlord VARCHAR(500)," +
                "    sum VARCHAR(500)," +
                "    dateExpire DATE" +
                "); ";
        try {
            Statement statement = connection.createStatement();
            statement.execute(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
