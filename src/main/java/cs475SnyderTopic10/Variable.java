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
public class Variable implements LambdaExpr {
    private char name;
    
    public Variable(Character c){
        name = c;
    }
    
    @Override
    public LambdaExpr copy() {
        return new Variable(name);
    }

    @Override
    public LambdaExpr substitute(Variable var, LambdaExpr value) {
        if(!this.equals(var)) return null;
        return value;
    }

    @Override
    public ExprKind type() {
        return ExprKind.VARIABLE;
    }

    public char getName() {
        return name;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.name;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Variable other = (Variable) obj;
        if (this.name != other.name) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Variable{" + "name=" + name + '}';
    }
    
    @Override
    public String prettyPrint(){
        return String.format("%c", name);
    }
}
