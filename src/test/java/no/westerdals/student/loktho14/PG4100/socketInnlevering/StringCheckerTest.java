package no.westerdals.student.loktho14.PG4100.socketInnlevering;

import static org.junit.Assert.*;

/**
 * Created by Thorstein on 16.02.2016.
 */
public class StringCheckerTest {

    @org.junit.Test
    public void testCheck() throws Exception {
        assertTrue(StringChecker.check("ola nordmann", "OLA NORDMANN"));
        assertTrue(StringChecker.check("nei", "nei"));
        assertTrue(StringChecker.check("ola nordmann", "nordmann ola"));
        assertTrue(StringChecker.check("gerhrhgehr Ola Nordmann herehjh e hrjeh ", "ola nordmann"));
        assertTrue(StringChecker.check("ola, nordmann", "nordmann ola"));

    }
}