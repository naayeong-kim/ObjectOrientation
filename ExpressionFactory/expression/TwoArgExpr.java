/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expression;

/**
 * @author Nayeong Kim (s1006313)
 */
public abstract class TwoArgExpr implements BaseExpr{
    protected BaseExpr a;
    protected BaseExpr b;
    
    public TwoArgExpr(BaseExpr a, BaseExpr b){
        this.a = a;
        this.b = b;
    }    
}
