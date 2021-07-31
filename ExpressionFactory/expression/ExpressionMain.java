/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expression;

import static expression.Factory.*;

/**
 * @author Nayeong Kim (s1006313)
 */
public class ExpressionMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BaseExpr e1 = add(mul(con(2), con(3)), var("x"));
        System.out.println(e1.toString());
        System.out.println(e1.pe().toString());
        
        BaseExpr e2 = mul(var("x"), add(con(5), con(3)));
        System.out.println(e2.toString());
        System.out.println(e2.pe().toString());
        
        BaseExpr e3 = mul(add(var("x"), con(3)), con(5));
        System.out.println(e3.toString());
        System.out.println(e3.pe().toString());
    }
    
}