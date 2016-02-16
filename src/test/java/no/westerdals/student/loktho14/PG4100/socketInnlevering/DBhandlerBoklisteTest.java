package no.westerdals.student.loktho14.PG4100.socketInnlevering;

import org.mockito.Mockito;

import java.util.ArrayList;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.mock;


/**
 * Created by Thorstein on 16.02.2016.
 */
public class DBhandlerBoklisteTest {

    @org.junit.Test
    public void test_that_Close_is_called() throws Exception {
        DBhandlerBokliste dbMock = mock(DBhandlerBokliste.class);
        dbMock.close();

        verify(dbMock).close();
    }

    @org.junit.Test
    public void test_that_it_returns_an_arrayList_with_books() throws Exception {
        DBhandlerBokliste dbMock = mock(DBhandlerBokliste.class);

        Mockito.when(dbMock.getTabell()).thenReturn(new ArrayList<Bok>());
    }
}