package org.example.Repo;

import org.example.config.DatabaseConfig;

import java.sql.Connection;

public class RunSqlQueries {

    private static Connection con = DatabaseConfig.getDbConnection();
}
