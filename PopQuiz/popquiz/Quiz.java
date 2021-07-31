/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popquiz;

import java.util.*;

/**
 *
 * @author Nayeong Kim (s1006313)
 */
public class Quiz {
    private List<Question> questions = new LinkedList<>();
    private List<Question> questions2 = new LinkedList<>();
    
    public Quiz() {
        questions.add(new OpenQuestion(
                "What is the complexity of abinary search?", "O(log N)", 2));
        questions.add(new OpenQuestion(
                "Is there a difference between an interface and an abstract class?", "Yes", 5));
        questions.add(new OpenQuestion(
                "How would you read an integer i from scanner s in Java?", "nextInt();", 2));
        questions.add(new OpenQuestion(
                "What is the minimum amount of constructors you have to define for a class in Java?", "0", 2));
        questions.add(new OpenQuestion(
                "Is there a maximum to the amount of constructors a class an have in Java?", "No"));
        questions.add(new MultipleChoiceQuestion(
                "What is the best achievable complexity of in situ sorting?",
                new String[] {"1. O(N^2)", "2. O(N log N)", "3. O(N)", "4. O(log N)"},
                1, 4));
        questions.add(new MultipleChoiceQuestion(
                "How do you print \"Hello world\" on a line in Java?",
                new String[] {"1. System.out.print(\"Hello world\");", 
                    "2. System.out.println(\"Hello world\");",
                    "3. cout << \"Hello world\";"},
                1));
        questions.add(new MultipleChoiceQuestion(
                "How do you read a non-empty word using scanner s?",
                new String[] {"1. s.nextline()", 
                    "2. s.next(\"\\S+\")",
                    "3. s.next(\"\\a*\")",
                    "4. s.next(\"\\S*\")",
                    "5. s.next(\"\\\\s+\")",
                    "6. s.next(\"\\s+\")",
                    "7. s.nextString(\"\\s*\")",
                    "8. s.next(\"\\\\S+\")",
                    "9. s.nextString()"},
                7, 1));
        questions.add(new ThisThatQuestion(
                "Yes or No: Is there a difference between abstract classes and interfaces in Java?",
                "Yes", "No", 1, 5));
        questions.add(new ThisThatQuestion(
                "Right or Wrong: Each class definition must have a constructor.",
                "Right", "Wrong", 2, 2));
        questions.add(new ThisThatQuestion(
                "Yes or No: Is there a maximum to the amount of constructors a class an have in Java?",
                "Yes", "No", 2));
    }
    
    public void quizgame() {
        Scanner s = new Scanner(System.in);
        System.out.println("[ROUND 1]");
        int score1 = 0, score2 = 0;
        for(Question q : questions) {
            System.out.println("Q. " + q.toString());
            System.out.print("A. ");
            String answer = s.next();
            if(q.isCorrect(answer)) {
                System.out.println("------------------- correct!\n");
                score1 += q.getScore();
            } else {
                System.out.println("------------------- wrong!\n");
                questions2.add(q.duplicate());
            }
        }
        
        if( questions2.isEmpty() ) {
            System.out.println("SCORE: " + score1);
            System.out.println("Excellent!");
        } else {
            System.out.println("[ROUND 2]");
            for(Question q : questions2) {
                System.out.println("Q. " + q.toString());
                System.out.print("A. ");
                String answer = s.next();
                if(q.isCorrect(answer)) {
                    System.out.println("------------------- correct!\n");
                    score2 += q.getScore();
                } else {
                    System.out.println("------------------- wrong!");
                    System.out.println("Correct answer: " +  q.correctAnswer() + "\n");
                } 
            }
            System.out.println("SCORE: (Round 1 = " + score1 + ") + (Round 2 = " 
                    + score2 + ") = " + (score1+score2));
        }
        
    }
    
    
}
