package org.example.singleton;

public class DatabaseConnection implements Connection {
    private static DatabaseConnection instance;

    private DatabaseConnection() {

    }

    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    @Override
    public void connect() {
        System.out.println("Подключение к базе данных...");
    }

    @Override
    public void disconnect() {
        System.out.println("Отключение от базы данных...");
    }
}
