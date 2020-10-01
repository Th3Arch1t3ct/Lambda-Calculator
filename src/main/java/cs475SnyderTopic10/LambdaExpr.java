/**
 * @author: Evan Snyder
 * @assignment: CS475 Topic 10 Assignment
 * @created: Sep 17, 2020
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
    
    public String prettyPrint();
}
