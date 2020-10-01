/**
 * @author: Evan Snyder
 * @assignment: CS475 Topic 10 Assignment
 * @created: Sep 17, 2020
 */
package cs475SnyderTopic10;

public class LambdaCalcApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Parser parser = new Parser();
        Simulator simulator = new Simulator();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LambdaCalculusUI(parser, simulator).setVisible(true);
            }
        });
    }
}
