package com.example.amande.infrastructure.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

@Component
public class PostgreSql {
    
    private final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private final String USER = "postgres";
    private final String PASS = "postgres";

    public ResultSet executeQuery(String sql) throws SQLException {
        
        ResultSet resultSet = null;

        Connection postgresConnection = DriverManager.getConnection(URL, USER, PASS);
        PreparedStatement preparedStatement = postgresConnection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();


        return resultSet;

    }
}
