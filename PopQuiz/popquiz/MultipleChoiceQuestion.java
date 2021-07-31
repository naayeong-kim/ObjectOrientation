/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popquiz;

/**
 * @author Nayeong Kim (s1006313)
 */
public class MultipleChoiceQuestion extends Question {
    private String question;
    private String[] answers;
    private int correctAnswer;
    private int score = 3;
    
    public MultipleChoiceQuestion(String question, String[] answers, int correctAnswer, int score) {
        this.question = question;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
        setScore(score);
    }
    
    public MultipleChoiceQuestion(String question, String[] answers, int correctAnswer) {
        this.question = question;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }

    @Override
    public String toString() {
        String str = this.question;
        for(String s : answers) {
            str += "\n";
            str += s;
        }
        return str;
    }

    @Override
    public boolean isCorrect(String answer) {
        int idx = Integer.parseInt(answer);
        String ans = this.answers[idx-1];
        return ans.equals(correctAnswer());
    }

    @Override
    public String correctAnswer() {
        String ans = this.answers[this.correctAnswer-1];
        return ans;
    }

    @Override
    public void setScore(int score) {
        if(score >= 1 && score <= 5)
            this.score = score;
    }

    @Override
    public Question duplicate() {
        return new MultipleChoiceQuestion(this.question, this.answers, this.correctAnswer, this.score);
    }

    @Override
    public int getScore() {
        return this.score;
    }
    
}
