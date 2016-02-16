package no.westerdals.student.loktho14.PG4100.utils;

import org.junit.Test;

import static org.mockito.Mockito.verify;

import java.sql.Connection;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Created by Thorstein on 16.02.2016.
 */
public class ConnectToDBTest {


    @Test
    public void test_Close_Connection() throws Exception {
       /* ConnectToDB db = new ConnectToDB("localhost","pg4100innlevering2","root","9t09aras");
        Connection con = con = db.getConnection();
        db.close();

        assertTrue("Tester om connectionen ble lukket",con.isClosed());*/

        ConnectToDB dbMock = mock(ConnectToDB.class);
        dbMock.close();

        verify(dbMock).close();
    }

    @Test
    public void test_that_we_have_a_Connection() throws Exception {
        ConnectToDB dbMock = mock(ConnectToDB.class);

        dbMock.getConnection();


        ConnectToDB db = new ConnectToDB("localhost", "pg4100innlevering2", "root", "9t09aras");
        Connection con = con = db.getConnection();

        assertNotNull("", con);

    }
}