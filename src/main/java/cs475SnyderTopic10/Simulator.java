/**
 * @author: Evan Snyder
 * @assignment: CS475 Topic 10 Assignment
 * @created: Sep 17, 2020
 */

package cs475SnyderTopic10;

public class Simulator {
    
    /**
     * BIG O Analysis: This one was a tricky one to solve, but I applied the master
     *  theorem to estimate the time complexity of the application.
     *    T(n) = aT(n/b) + f(n) == 2T(n/2) + n^1
     *  Because each child in the expression tree can only have, at most, 2 children,
     *  the size of each problem and sub-problem can only be 2. The non-recursive
     *  portions of the code run in O(n) time. where n is the depth of the expression
     *  tree (substitute, for example must traverse all children to do the substitution).
     *  This makes the recurrence relation of a ? b^d where d = 1
     *  Ultimately, the program runs in:
     *          O(n log n)
     * 
     * @param expr Lambda expression to reduce
     * @return final, normal-form expression
     * @throws DivergentException Infinite loops!
     */
    public LambdaExpr betaReduce(LambdaExpr expr) throws DivergentException {
        // Cannot reduce any further
        if(expr.type() != ExprKind.APPLICATION) return expr;
        
        Application a = (Application)expr;
        
        // We must ensure that operand1 is an abstraction
        // if operand1 is an application, we must beta reduce the application first
        LambdaExpr result = a.getOperand1();
        
        // Detremine if the final child is a Variable. If so, we have 
        // a series of applications that are are already reduced
        Application b = a;
        while(b.getOperand1().type() == ExprKind.APPLICATION){
            if(b.getOperand1().type() == ExprKind.VARIABLE)
                return a;
            b = (Application)b.getOperand1();
        }
        
        if(a.getOperand1().type() == ExprKind.APPLICATION){
            result = betaReduce(a.getOperand1());
        }
        
        if(result.type() != ExprKind.ABSTRACTION) return a;
        
        // At this point, result should be an Abstraction
        Abstraction ab = (Abstraction)result;
        LambdaExpr t = ab.substitute(ab.getBoundVar(), a.getOperand2());
        
        // expression after reduction expr is the same as it was before. Cannot normalize this one.
        if(t.equals(a)) throw new DivergentException("This expression cannot be normalized");
        
        // If we still have an application here, we might need to reduce further
        if(t.type() == ExprKind.APPLICATION)
            t = betaReduce((Application)t);
        
        return t;
    }
}
