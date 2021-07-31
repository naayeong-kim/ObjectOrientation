/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expression;

import java.util.Map;

/**
 * @author Nayeong Kim (s1006313)
 */
public class Add extends TwoArgExpr {

    public Add(BaseExpr a, BaseExpr b){
        super(a,b);
    }

    @Override
    public double eval(Map<String, Double> env) {
        return a.eval(env) + b.eval(env);
    }

    @Override
    public BaseExpr pe() {
        BaseExpr ae = a.pe();
        BaseExpr be = b.pe();
        
        if(ae instanceof Const && be instanceof Const){
            Const c1 = (Const) ae; 
            Const c2 = (Const) be;
            
            if(c1.getValue() == 0)
                return new Const(c2.getValue());
            
            else if(c2.getValue() == 0)
                return new Const(c1.getValue());
            
            else
                return new Const(c1.getValue() + c2.getValue()); 
            
        }
        else{
            return new Add(ae, be);
        }
        
    }
    
    @Override
    public String toString() {
        return "(" + a.toString() + "+" + b.toString() + ")";
    }
    
    
}