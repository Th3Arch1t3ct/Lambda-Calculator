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
public class Parser {
    public LambdaExpr parse(String term) throws ParseException {
        System.out.printf("Parsing: %s\n", term);
        
        char c = term.charAt(0);
        switch(c){
            case '(':
                if(1 + findBalancedRightParenPos(term) != term.length()) 
                    return parseApplication(term);
                return parse(term.substring(1, findBalancedRightParenPos(term)));
            case 'L':
                return parseAbstraction(term);
            default:
                if(term.length() != 1) return parseApplication(term);
                return new Variable(c);
        }
    }
    
    private Abstraction parseAbstraction(String term) throws ParseException {
        System.out.printf("Parsing abstraction: %s\n", term);
        Abstraction ab = new Abstraction();
        Variable v = new Variable(term.charAt(1));
        System.out.printf("\tNew Variable: %c\n", v.getName());
        ab.setBoundVar(v);
        
        ab.setBody(parse(term.substring(4)));
        
        return ab;
    }
    
    private Application parseApplication(String term) throws ParseException {
        System.out.printf("Parsing Application: %s\n", term);
        // This might be the toughest one ? we need to iterate over whole thing
        // Parsing terms between the ()'s
        // If there is not ()'s, we need to left associate and only take the first two terms. 
        // The trick here is the associativity....
        
        int i = 0;
        String term2;
        term = term.trim();
        if(term.charAt(term.length() - 1) == ')'){
            // find balanced left paren
            int depth = 0;
            for(i = term.length() - 1; i > 0; i--){
                if(term.charAt(i) == ')'){
                    depth++;
                }
                if(term.charAt(i) == '('){
                    depth--;
                    if(depth == 0) break;
                }
            }
            
            term2 = term.substring(i, term.length());
        } else {
            i = term.length() - 2;
            term2 = term.substring(term.length()-1);
        }
        
        System.out.printf("First term: %s\n", term.substring(0, i));
        System.out.printf("Second term: %s\n", term2);
        
        Application ap = new Application();
        ap.setOperand1(parse(term.substring(0, i)));
        ap.setOperand2(parse(term2));
        
        
        return ap;
    }
    
    private int findBalancedRightParenPos(String term) throws ParseException {
        // First char will be the starting '('
        int depth = 1;
        for(int i = 1; i < term.length(); i++){
            if(term.charAt(i) == '('){
                depth++;
            }
            if(term.charAt(i) == ')'){
                depth--;
                if(depth == 0)
                    return i;
            }
        }
        
        throw new ParseException("No Matching parentheses.");
    }
}
