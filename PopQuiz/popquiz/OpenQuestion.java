/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popquiz;

/**
 *
 * @author Nayeong Kim (s1006313)
 */
public class OpenQuestion extends Question {
    private String question;
    private String answer;
    private int score = 3;
    
    public OpenQuestion(String question, String answer, int score) {
        this.question = question;
        this.answer = answer;
        setScore(score);
    }
    public OpenQuestion(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    @Override
    public String toString() {
        return this.question;
    }

    @Override
    public boolean isCorrect(String answer) {
        return answer.equalsIgnoreCase(this.answer);
    }

    @Override
    public String correctAnswer() {
        return this.answer;
    }

    @Override
    public void setScore(int score) {
        if(score >= 1 && score <= 5)
            this.score = score;
    } 

    @Override
    public Question duplicate() {
        return new OpenQuestion(this.question, this.answer, this.score);
    }

    @Override
    public int getScore() {
        return this.score;
    }
}
