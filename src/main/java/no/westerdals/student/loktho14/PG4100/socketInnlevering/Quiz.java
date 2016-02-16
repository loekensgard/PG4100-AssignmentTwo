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

    public Quiz() throws SQLException {
        DBhandlerBokliste db = new DBhandlerBokliste();
        bok = db.getTabell();
        int n = random.nextInt(bok.size());

        //System.out.println(bok.size());
        //System.out.println(n);
        //bok.forEach(j -> System.out.println(j));

        setQuiz(n);
        db.close();
    }

    public void setQuiz(int n) {
        question = bok.get(n).getTittel();
        answer = bok.get(n).getForfatter();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Quiz quiz = (Quiz) o;

        return question.equals(quiz.question) && answer.equals(quiz.answer);

    }

    @Override
    public int hashCode() {
        int result = question.hashCode();
        result = 31 * result + answer.hashCode();
        return result;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

}
