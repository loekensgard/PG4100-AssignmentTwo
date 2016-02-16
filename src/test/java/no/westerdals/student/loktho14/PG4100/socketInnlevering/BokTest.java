package no.westerdals.student.loktho14.PG4100.socketInnlevering;


import org.junit.Before;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Thorstein on 16.02.2016.
 */
public class BokTest {
    private Bok bok = null;
    private String forfatter = "forfatterTest";
    private String tittel = "tittelTest";
    private String ISBN = "isbnTest";
    private int sider = 2;
    private int utgitt = 2000;


    @Before
    public void setUp() throws Exception {
        bok = new Bok(forfatter, tittel, ISBN, sider, utgitt);

    }

    @org.junit.Test
    public void testGetForfatter() throws Exception {
        String n = bok.getForfatter();

        assertEquals("Forfatter navn er like", n, forfatter);
    }

    @org.junit.Test
    public void testGetTittel() throws Exception {
        String n = bok.getTittel();

        assertEquals("Tittelen er lik", n, tittel);

    }

    @org.junit.Test
    public void testGetIsbn() throws Exception {
        String n = bok.getIsbn();

        assertEquals("ISBN er lik", n, ISBN);
    }

    @org.junit.Test
    public void testGetSider() throws Exception {
        int n = bok.getSider();

        assertEquals("Side antall er likt", n, sider);
    }

    @org.junit.Test
    public void testGetUtgitt() throws Exception {
        int n = bok.getUtgitt();

        assertEquals("Utgivelsesår er likt", n, utgitt);
    }

    @org.junit.Test
    public void testSetForfatter() throws Exception {
        bok.setForfatter("test");

        assertEquals("Forfatter navn er like", bok.getForfatter(), "test");
    }

    @org.junit.Test
    public void testSetTittel() throws Exception {
        bok.setTittel("test");

        assertEquals("Tittlen er lik", bok.getTittel(), "test");
    }

    @org.junit.Test
    public void testSetIsbn() throws Exception {
        bok.setIsbn("test");

        assertEquals("ISBN er lik", bok.getIsbn(), "test");
    }

    @org.junit.Test
    public void testSetSider() throws Exception {
        bok.setSider(4);

        assertEquals("Likt antall sider", bok.getSider(), 4);
    }

    @org.junit.Test
    public void testSetUtgitt() throws Exception {
        bok.setUtgitt(1999);

        assertEquals("Utgivelsesår er likt", bok.getUtgitt(), 1999);
    }

    @org.junit.Test
    public void testToString() throws Exception {
        String n = bok.toString();

        assertEquals("toString stemmer", n, "Forfatter: " + forfatter + " " +
                "Tittel: " + tittel + " " +
                "ISBN: " + ISBN + " " +
                "Sider: " + sider + " " +
                "Utgitt " + utgitt);
    }
}