import java.awt.Point;
import java.util.*;
import java.util.HashMap;
import java.util.Map;

public class state
{
    private final int MAX=Integer.MAX_VALUE;
    private final int MIN=Integer.MIN_VALUE;
    private int maxDepth;
    Runtime r ;

    public state(int maxDepth)
    {
        this.maxDepth=maxDepth;
          r = Runtime.getRuntime();
          r.gc();
    }

    public Move alpha_beta(othelo o)
    {
        
        Move m=max_Value(new othelo(o),MIN,MAX,0);
        r.gc();
        return m;
        
    }
    private Move max_Value(othelo o,int a,int b,int depth)
    {
        if((o.isTerminal())||(depth==maxDepth))
        {
            Move lastMove=new Move(o.getLastMove().getX(),o.getLastMove().getY(),o.evaluate());
            r.gc();
            return lastMove;
        }
        ArrayList<othelo> children =o.getChildren('W');
        Move maxMove=new Move(MIN);
        for(othelo child : children)
        {
            Move move=min_Value(child,a,b,depth+1);
            if(move.getValue()>=maxMove.getValue())
            {
                if(move.getValue()>=b){return move;} 
                maxMove.setX(child.getLastMove().getX());
                maxMove.setY(child.getLastMove().getY());
                maxMove.setValue(move.getValue());
                child=null;
                r.gc();
            }
            a=Math.max(a,move.getValue());
        }
        return maxMove;
    
    }
    private Move min_Value(othelo o,int a,int b,int depth)
    {
        if((o.isTerminal())||(depth==maxDepth))
        {
            Move lastMove=new Move(o.getLastMove().getX(),o.getLastMove().getY(),o.evaluate());
            r.gc();
            return lastMove;
        }
        ArrayList<othelo> children =o.getChildren('B');
        Move minMove=new Move(MAX);
        for(othelo child : children)
        {
            Move move=max_Value(child,a,b,depth+1);
            if(move.getValue()<=minMove.getValue())
            {
                if(move.getValue()<=a) {return move;} 
                minMove.setX(child.getLastMove().getX());
                minMove.setY(child.getLastMove().getY());
                minMove.setValue(move.getValue());
                child=null;
                r.gc();
            }
            b=Math.min(b,move.getValue());
        }
        return minMove;

    }
}
