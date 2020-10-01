/**
 * @author: Evan Snyder
 * @assignment: CS444 Final Project
 * @created: Sep 17, 2020
 */

package cs475SnyderTopic10;

import java.util.Objects;

/**
 * 
 *
 * @author Evan Snyder
 */
public class Application implements LambdaExpr {
    private LambdaExpr operand1;
    private LambdaExpr operand2;
    
    @Override
    public LambdaExpr copy() {
        Application newApp = new Application();
        
        newApp.setOperand1(operand1.copy());
        newApp.setOperand2(operand2.copy());
        
        return newApp;
    }

    @Override
    public LambdaExpr substitute(Variable var, LambdaExpr value) {
        Application newAp = (Application)copy();
        
        LambdaExpr t = newAp.getOperand1().substitute(var, value);
        if(t != null) newAp.setOperand1(t);
        
        t = newAp.getOperand2().substitute(var, value);
        if(t != null) newAp.setOperand2(t);
        
        return newAp;
    }

    @Override
    public ExprKind type() {
        return ExprKind.APPLICATION;
    }

    public LambdaExpr getOperand1() {
        return operand1;
    }

    public void setOperand1(LambdaExpr operand1) {
        this.operand1 = operand1;
    }

    public LambdaExpr getOperand2() {
        return operand2;
    }

    public void setOperand2(LambdaExpr operand2) {
        this.operand2 = operand2;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.operand1);
        hash = 61 * hash + Objects.hashCode(this.operand2);
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
        final Application other = (Application) obj;
        if (!Objects.equals(this.operand1, other.operand1)) {
            return false;
        }
        if (!Objects.equals(this.operand2, other.operand2)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Application{" + "operand1=" + operand1 + ", operand2=" + operand2 + '}';
    }
    
    @Override
    public String prettyPrint(){
        return String.format("%s %s", operand1.prettyPrint(), operand2.prettyPrint());
    }
}
