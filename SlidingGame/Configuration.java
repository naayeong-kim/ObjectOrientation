/**
 * @author Nayeong Kim (s1006313)
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface Configuration extends Comparable<Configuration> {

    public abstract Configuration parent();
   
    public abstract Collection<Configuration> successors();

    public abstract boolean isSolution();
    
    public int getManhattanDistance();
    
    public abstract int[][] getBoard();
    
    @Override
    public int hashCode();
    
    public default List<Configuration> pathFromRoot(){
        List <Configuration> path = new ArrayList<>();
        Configuration parent = this.parent();
        
        if(parent == null){
            return path;
        }
        else{    
//            path.add(parent);   
            parent.pathFromRoot();
            path.add(parent);  
            System.out.println(parent);
            return path;
        }
    }    
}
