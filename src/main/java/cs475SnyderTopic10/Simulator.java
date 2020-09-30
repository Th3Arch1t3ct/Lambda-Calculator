/**
 * @author: Evan Snyder
 * @assignment: CS444 Final Project
 * @created: Sep 17, 2020
 */

package cs475SnyderTopic10;

/**
 * 
 *
 * @author Evan Snyder
 */
public class Simulator {
    public LambdaExpr betaReduce(LambdaExpr expr) throws DivergentException {
        
        if(expr.type() == ExprKind.VARIABLE) return expr;
        
        switch(expr.type()){
            case VARIABLE:
            case ABSTRACTION:
                return expr;
        }
        Application a = (Application)expr;
        LambdaExpr t = expr.substitute(new Variable('t'), a.getOperand2());
        
        return new Application();
    }
}
