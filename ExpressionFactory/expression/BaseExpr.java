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
public interface BaseExpr {
    public BaseExpr pe();
    public double eval(Map<String, Double> env);
    
    
    @Override
    public String toString();
    
}
