package no.westerdals.student.loktho14.PG4100.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Created by Thorstein on 10.02.2016.
 */
public class ConnectToDB implements AutoCloseable {
    Connection con;

    public ConnectToDB(String server, String database, String user, String password) throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://" + server + "/" + database, user, password);
    }

    public void close() throws SQLException {
        con.close();
    }

    public Connection getConnection() {
        return con;
    }
}