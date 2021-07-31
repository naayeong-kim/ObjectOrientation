/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popquiz;

/**
 * @author Nayeong Kim (s1006313)
 */
public class ThisThatQuestion extends Question {
    private String question;
    private String answer1;
    private String answer2;
    private int correctAnswer;
    private int score = 3;
    
    public ThisThatQuestion(String question, String answer1, String answer2, int correctAnswer, int score) {
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.correctAnswer = correctAnswer;
        setScore(score);
    }
    
    public ThisThatQuestion(String question, String answer1, String answer2, int correctAnswer) {
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.correctAnswer = correctAnswer;
    }
    
    @Override
    public String toString() {
        return this.question;
    }

    @Override
    public boolean isCorrect(String answer) {
        String ans = correctAnswer();
        return answer.equalsIgnoreCase(ans);
    }

    @Override
    public String correctAnswer() {
        if(this.correctAnswer == 1)
            return answer1;
        else
            return answer2;
    }

    @Override
    public void setScore(int score) {
        if(score >= 1 && score <= 5)
            this.score = score;
    }

    @Override
    public Question duplicate() {
        return new ThisThatQuestion(this.question, this.answer1, this.answer2, this.correctAnswer, this.score);
    }

    @Override
    public int getScore() {
        return this.score;
    }
    
}
