package no.westerdals.student.loktho14.PG4100.socketInnlevering;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Thorstein on 16.02.2016.
 */
public class Quiz {
    private String question;
    private String answer;
    private ArrayList<Bok> bok = new ArrayList<>();
    private Random random = new Random();

    public Quiz(String brukernavn, String passord) throws SQLException {
        DBhandlerBokliste db = new DBhandlerBokliste(brukernavn, passord);
        bok = db.getTabell();
        int n = random.nextInt(bok.size());

        System.out.println(bok.size());
        System.out.println(n);

        bok.forEach(j -> System.out.println(j));

        setQuiz(n);

    }

    public void setQuiz(int n) {
        question = bok.get(n).getTittel();
        answer = bok.get(n).getForfatter();
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }


   /* public static void main(String []args)throws SQLException{
        Quiz q = new Quiz("brukernavn","passord");
        System.out.println(q.getQuestion());
        System.out.println(q.getAnswer());
    }*/
}
