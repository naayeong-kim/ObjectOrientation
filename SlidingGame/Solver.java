import java.util.*;

/**
 * @author Nayeong Kim (s1006313)
 */
public class Solver {

    PriorityQueue<Configuration> toExamine;

    public Solver(Configuration g) {
        toExamine = new PriorityQueue <>();
        toExamine.add(g);
    }

    public String solve() {        
        while (!toExamine.isEmpty()) {
            Configuration next = toExamine.remove();
            if (next.isSolution()) {
                next.pathFromRoot();
                System.out.println(next.toString());
                return "Success!";
            } else {
                for (Configuration succ : next.successors()) {
                        toExamine.add(succ);                       
                }
            }
        }
        return "Failure!";
    }

}
