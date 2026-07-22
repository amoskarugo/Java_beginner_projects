package org.example.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/*
* config class that establishes database connection. It is a single to style for creating database connection
* all fields are private to ensure they are only accessible to this class only
* A private constructor to prevent instantiation.
* */
public class DatabaseConfig {
    private static final String PASSWORD = "amoh2068";
    private static final String USERNAME = "postgres";
    private static final String URL = "jdbc:postgresql://localhost:5432/app";
    private static final String DRIVER_CLASS = "org.postgresql.Driver";

    //create and return a connection object
    private static Connection connection;


    private DatabaseConfig() {}

    public static Connection getDbConnection()  {
        try  {
            if ((connection == null || connection.isClosed()))
            {
                Class.forName(DRIVER_CLASS);// optional

                /*
                * This class implements a single style connection holder, consider using Hikari pool in case of mu
                * -multiple connection at once
                * */
                connection =  DriverManager.getConnection(URL, USERNAME, PASSWORD);
                System.out.println("connection to database established");
            }


        } catch (ClassNotFoundException e) {
            System.out.println("PostgresSql driver Class not found");
        }

        catch(SQLException e){
            System.out.println("Error connecting to database" + e.getMessage());
        }
        return connection;
    }
}
