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
public class Variable extends NoArgExpr {
    private String name;
    
    public Variable(String name){
        this.name = name;
    }

    @Override
    public double eval(Map<String, Double> env) {
        return env.get(name);
    }

    @Override
    public BaseExpr pe() {
        return this;
    }

    @Override
    public String toString(){
        return this.name;
    }
    
}
