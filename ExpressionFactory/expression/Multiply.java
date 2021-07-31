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
public class Multiply extends TwoArgExpr {

    public Multiply(BaseExpr a, BaseExpr b) {
        super(a, b);
    }

    @Override
    public double eval(Map<String, Double> env) {
        return a.eval(env) * b.eval(env);
    }

    @Override
    public BaseExpr pe() {
        BaseExpr ae = a.pe();
        BaseExpr be = b.pe();

        if (ae instanceof Const && be instanceof Const) {
            Const c1 = (Const) ae;
            Const c2 = (Const) be;

            if (c1.getValue() == 0 || c2.getValue() == 0)
                return new Const(0);
            else
                return new Const(c1.getValue() * c2.getValue());
        }

        else if (ae instanceof Const) {
            Const c1 = (Const) ae;
            switch((int)c1.getValue()) {
                case 0:
                    return new Const(0);
                case 1:
                    return be.pe();
                default: 
                    return new Multiply(ae,be);
            }
        }
        
        else if (be instanceof Const) {
            Const c1 = (Const) be;
            switch((int)c1.getValue()) {
                case 0:
                    return new Const(0);
                case 1:
                    return ae.pe();
                default: 
                    return new Multiply(ae,be);
            }
        } 
        
        else 
            return new Multiply(ae,be);
    }

    @Override
    public String toString() {
        return "(" + a.toString() + "*" + b.toString() + ")";
    }

}