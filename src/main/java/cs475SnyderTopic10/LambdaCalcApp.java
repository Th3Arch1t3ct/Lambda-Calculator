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
public class LambdaCalcApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Parser parser = new Parser();
        Simulator simulator = new Simulator();
        
        try{
            LambdaExpr t = parser.parse("x");
            LambdaExpr v = t.substitute((Variable)t, new Variable('y'));
            System.out.println(v.toString());
            
            LambdaExpr ex = parser.parse("(Ly. y y)");
            Abstraction e = (Abstraction)ex;
            System.out.println(e.toString());
            LambdaExpr result = e.substitute(e.getBoundVar(), t);
            System.out.println(result.toString());
            
            simulator.betaReduce(result);
            
//            LambdaExpr t = parser.parse("(((((x)))))");
//            System.out.printf("%s\n\n\n", t.toString());
//            
//            t =parser.parse("(Lx. (Ly. (Lz. z)))");
//            System.out.printf("%s\n\n\n", t.toString());
//            
//            t = parser.parse("(Lx. x x x)");
//            System.out.printf("%s\n\n\n", t.toString());
//            
//            t = parser.parse("(Lx. x x)(Lz. z y)");
//            System.out.printf("%s\n\n\n", t.toString());
//            parser.parse("(Lx. x)");
//            parser.parse("(Lx. x x x)");
//            parser.parse("(Lx. x y x)");
//            parser.parse("(Lx. x)(y)");
        } catch(ParseException | DivergentException ex) {
            ex.printStackTrace();
        }
    }
}
