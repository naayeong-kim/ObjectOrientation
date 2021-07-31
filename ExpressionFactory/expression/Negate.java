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
public class Negate extends OneArgExpr{

    public Negate(BaseExpr a){
        super(a);
    }

    @Override
    public double eval(Map<String, Double> env) {
        return a.eval(env) * -1 ;
    }

    @Override
    public BaseExpr pe() {
        
        BaseExpr ae = a.pe();
        
        if(ae instanceof Const){
            Const c1 = (Const) ae;        
            return new Const(-1*c1.getValue());
        }
        else{
            return new Negate(ae);
        }
        
    }
    
    @Override
    public String toString() {
        return "-(" + a.toString() + ")";
    }
    
}
