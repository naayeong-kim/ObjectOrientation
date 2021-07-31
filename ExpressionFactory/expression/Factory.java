/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expression;

/**
 * @author Nayeong Kim (s1006313)
 */
public class Factory {
    
    public static Add add(BaseExpr a, BaseExpr b){
        return new Add(a, b);       
    }
    public static Multiply mul(BaseExpr a, BaseExpr b){
        return new Multiply(a, b);
    }
    public static Negate neg(BaseExpr a){
        return new Negate(a);
    }
    public static Variable var(String a){
        return new Variable(a);
    }
    public static Const con(int a){
        return new Const(a);
    }
}
