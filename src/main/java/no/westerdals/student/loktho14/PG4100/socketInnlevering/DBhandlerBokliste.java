package no.westerdals.student.loktho14.PG4100.socketInnlevering;

import no.westerdals.student.loktho14.PG4100.utils.ConnectToDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by Thorstein on 10.02.2016.
 */
public class DBhandlerBokliste {
    private ConnectToDB db;
    private Connection con;
    private final String TABELL_NAVN = "bokliste";
    private PreparedStatement psGetTabell;
    private final String bruker = "root";
    private final String passord = "......"; //Remember to update this.

    public DBhandlerBokliste() throws SQLException {
        db = new ConnectToDB("localhost", "pg4100innlevering2", bruker, passord);
        con = db.getConnection();


        psGetTabell = con.prepareStatement("SELECT * FROM " + TABELL_NAVN);

    }

    public  void close() throws SQLException{
        psGetTabell.close();
        db.close();
    }

    public ArrayList<Bok> getTabell() throws SQLException{
        ArrayList<Bok> bokListe = new ArrayList<>();
        ResultSet rs = psGetTabell.executeQuery();


        while (rs.next()){
            bokListe.add(new Bok(
                    rs.getString("forfatter"),
                    rs.getString("tittel"),
                    rs.getString("ISBN"),
                    rs.getInt("sider"),
                    rs.getInt("utgitt")));
        }

        return bokListe;
    }


}