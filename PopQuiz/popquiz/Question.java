/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popquiz;

/**
 * @author Nayeong Kim (s1006313)
 */
public abstract class Question {
    @Override
    public abstract String toString();
    
    public abstract boolean isCorrect(String answer);
    
    public abstract String correctAnswer();
    
    public abstract void setScore(int score);
    
    public abstract Question duplicate();
    
    public abstract int getScore();
}
