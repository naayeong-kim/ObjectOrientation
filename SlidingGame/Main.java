/**
 * @author Nayeong Kim (s1006313)
 */
public class Main
{
    public static void main(String[] args) {
        int [] game = { 1, 9, 3, 7, 2, 5, 8, 4, 6 };
        
        SlidingGame s = new SlidingGame (game);
        Solver solver = new Solver(s);
        System.out.println(solver.solve());
    }
}
