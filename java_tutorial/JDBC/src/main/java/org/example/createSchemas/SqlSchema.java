package org.example.createSchemas;

import org.example.config.DatabaseConfig;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class SqlSchema {
    private static final Connection connection = DatabaseConfig.getDbConnection();

    public static void runCreateSchema() {
        try (Statement statement = connection.createStatement()) {
            String sqlSchemaFile = Files.readString(Paths.get("src/main/resources/schema.sql"));
            String[] statements = sqlSchemaFile.split(";");
            for (String query : statements) {
                if (!query.trim().isEmpty()) {
                    if(statement.execute(query)){
                        System.out.println("Schema has been created");
                    }
                }
            }
        }catch (IOException | SQLException e) {
            System.out.println("Error reading sql schema file");
        }
    }
}
