/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs475SnyderTopic10;

/**
 *
 * @author night
 */
public interface LambdaExpr {
    public LambdaExpr copy();
    public LambdaExpr substitute(Variable var, LambdaExpr value);
    public ExprKind type();
}
