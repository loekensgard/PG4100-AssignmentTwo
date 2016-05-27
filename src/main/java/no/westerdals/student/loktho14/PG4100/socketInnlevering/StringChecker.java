package no.westerdals.student.loktho14.PG4100.socketInnlevering;


/**
 * Created by Thorstein on 16.02.2016.
 */
public class StringChecker {


    //Method for checking answer agains users input.
    public static boolean check(String input, String answer) {
        input = input.toLowerCase();
        answer = answer.toLowerCase();

        input = input.replace(",", "");
        answer = answer.replace(",", "");

        String[] inputNames = input.split(" ");
        String[] answerNames = answer.split(" ");


        if (input.matches("(.*)" + answer + "(.*)")
                || (inputNames[0].equals(answerNames[0])) && (inputNames[1].equals(answerNames[1]))
                || (inputNames[0].equals(answerNames[1])) && (inputNames[1].equals(answerNames[0]))) {
            return true;
        }

        return false;
    }

}
