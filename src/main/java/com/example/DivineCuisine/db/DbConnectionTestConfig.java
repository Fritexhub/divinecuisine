package com.example.DivineCuisine.db;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DbConnectionTestConfig {
    @Bean
    public CommandLineRunner testDbConnection() {
        return args -> {
            try {
                DbConnect db = DbConnect.getInstance();
                if (db.getConnection() != null && !db.getConnection().isClosed()) {
                    System.out.println("Connection to PostgreSQL successful (from CommandLineRunner)!");
                }
            } catch (Exception e) {
                System.err.println("Connection failed:");
                e.printStackTrace();
            }
        };
    }
}