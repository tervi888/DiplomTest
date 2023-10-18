package ru.netology.data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.Assertions;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLHelper {
    private static String url = System.getProperty("db.url");
    private static String user = System.getProperty("db.user");
    private static String password = System.getProperty("db.password");

    @SneakyThrows
    public static Payment paymentEntity() {
        String sql = "SELECT status FROM payment_entity ORDER BY created DESC LIMIT 1";
        QueryRunner runner = new QueryRunner();
        Connection conn = getConnection();
        return runner.query(conn, sql, new BeanHandler<>(Payment.class));
    }

    @SneakyThrows
    private static Connection getConnection() {
        return DriverManager.getConnection(
                url, user, password
        );
    }

    @SneakyThrows
    public static void cleanBD() {
        String sql = "Delete from credit_request_entity;";
        String sql1 = "Delete from order_entity;";
        String sql2 = "Delete from payment_entity;";
        QueryRunner runner = new QueryRunner();
        Connection conn = getConnection();
        runner.execute(conn, sql);
        runner.execute(conn, sql1);
        runner.execute(conn, sql2);
    }

    @SneakyThrows
    public static void assertDbEmpty() {
        String sql = "Select count(*) from credit_request_entity;";
        String sql1 = "Select count(*) from order_entity;";
        String sql2 = "Select count(*) from payment_entity;";
        QueryRunner runner = new QueryRunner();
        Connection conn = getConnection();
        Long count0 = runner.query(conn, sql, new ScalarHandler<>());
        Assertions.assertEquals(0, count0);
        Long count1 = runner.query(conn, sql1, new ScalarHandler<>());
        Assertions.assertEquals(0, count1);
        Long count2 = runner.query(conn, sql2, new ScalarHandler<>());
        Assertions.assertEquals(0, count2);
    }
}