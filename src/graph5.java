import java.util.*;
import java.util.Stack;
public class graph5 {
   static class edge{
    int src;
    int dest;

    public edge(int s,int d){
        this.src=s;
        this.dest=d;
    }  }
    public static void creategraph(ArrayList<edge>graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<edge>();
        }
        
        graph[0].add(new edge(0,1));
        graph[1].add(new edge(1,0));
        graph[0].add(new edge(0,2));
        graph[2].add(new edge(2,0));
        graph[1].add(new edge(1,2));
        graph[2].add(new edge(2,1));
        graph[0].add(new edge(0,3));
        graph[3].add(new edge(3,0));

       // graph[3].add(new edge(3,5));
      //  graph[5].add(new edge(5,3));
        graph[3].add(new edge(3,4));
        graph[4].add(new edge(4,3));
       // graph[4].add(new edge(4,5));graph[5].add(new edge(5,4));
    }
    public static void tarjansbridge(ArrayList<edge>graph[],int v){
        boolean vis[]=new boolean[v];
        int dt[]=new int[v];
        int low[]=new int[v];
        int time=0;

        for(int i=0;i<v;i++){
           if(!vis[i]){
            dfs(graph,i,-1,dt,low,time,vis);
           }
        }
    }
    public static void dfs(ArrayList<edge>graph[],int curr,int par,int dt[],int low[],
    int time,boolean vis[]){
        vis[curr]=true;
        low[curr]=dt[curr]=++time;

        for(int i=0;i<graph[curr].size();i++){
            edge e=graph[curr].get(i);
            int neigh=e.dest;

            if(neigh==par){
                continue;
            }
          else if(!vis[neigh]){
                dfs(graph, neigh,curr, dt, low, time, vis);
                low[curr]=Math.min(low[curr],low[neigh]);

                if(dt[curr]<low[neigh]){
                    System.out.print("bridge"+curr+"----"+neigh);
                }
            }
            else{
                low[curr]=Math.min(low[curr],dt[neigh]);
            }
        }

    
    }
    
   
   public static void main(String[] args) {
    int v=5;
    ArrayList<edge>graph[]=new ArrayList[v];
    creategraph(graph);
    //kosaraju(graph, v);
    tarjansbridge(graph, v);
   }
}
