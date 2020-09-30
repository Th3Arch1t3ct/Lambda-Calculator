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
public class Abstraction implements LambdaExpr {
    
    private Variable boundVar;
    private LambdaExpr body;

    @Override
    public LambdaExpr copy() {
        Abstraction ab = new Abstraction();
        
        ab.setBoundVar((Variable)boundVar.copy());
        ab.setBody(body.copy());
        
        return ab;
    }

    @Override
    public LambdaExpr substitute(Variable var, LambdaExpr value) {
        Abstraction newAb = (Abstraction)copy();
        
        LambdaExpr t = boundVar.substitute(var, value);
        if(t!= null) newAb.setBoundVar((Variable)t);
        
        newAb.setBody(body.substitute(var, value));
        
        return newAb;
    }

    @Override
    public ExprKind type() {
        return ExprKind.ABSTRACTION;
    }

    public Variable getBoundVar() {
        return boundVar;
    }

    public void setBoundVar(Variable boundVar) {
        this.boundVar = boundVar;
    }

    public LambdaExpr getBody() {
        return body;
    }

    public void setBody(LambdaExpr body) {
        this.body = body;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.boundVar);
        hash = 97 * hash + Objects.hashCode(this.body);
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
        final Abstraction other = (Abstraction) obj;
        if (!Objects.equals(this.boundVar, other.boundVar)) {
            return false;
        }
        if (!Objects.equals(this.body, other.body)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Abstraction{" + "boundVar=" + boundVar + ", body=" + body + '}';
    }
    
}
