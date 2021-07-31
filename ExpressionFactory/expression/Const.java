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
public class Const extends NoArgExpr{
    private double constant;
    
    public Const(double constant){
        this.constant = constant;
    }

    @Override
    public double eval(Map<String, Double> env) {
        return this.constant;
    }

    @Override
    public BaseExpr pe() {
        return this;
    }
    
    @Override
    public String toString(){
        return this.constant + "";
    }

    public double getValue() {
       return this.constant;
    }
}
