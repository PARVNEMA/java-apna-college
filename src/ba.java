import java.util.*;
public class ba {
    static class point implements Comparable<point>{
        int x;
        int y;
        int distsq;

        public point(int x,int y,int z){
            this.x=x;
            this.y=y;
            this.distsq=z;}

            @Override 
            public int compareTo(point p2){
                return p2.distsq=this.distsq;
            
        }
    }
    public static void main(String[] args) {
        int pts[][]={{3,3},{5,-1},{-2,4}};
        int k=2;

        PriorityQueue<point>pq=new PriorityQueue<>();
        for(int i=0;i<pts.length;i++){
            int distsq=pts[i][0]*pts[i][0]+pts[i][1]*pts[i][1];

            pq.add(new point(pts[i][0],pts[i][1],distsq));
        }

        for(int i=0;i<k;i++){
            System.out.println(pq.remove().distsq);
        }
    }
}
