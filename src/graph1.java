import java.util.*;
import java.util.Queue;
public class graph1 {
    static class edge{
int src;
int dest;
int wt;

public edge(int s,int d,int wt){
    this.src=s;
    this.dest=d;
    this.wt=wt;
}
    }
    public static void creategraph(ArrayList<edge> graph[]){
        for(int i=0;i<7;i++){
            graph[i]=new ArrayList<>();
        }
        
        //vertex0
        graph[0].add(new edge(0,1,5));
        graph[0].add(new edge(0,2,5));
        
        //vertex 1
        graph[1].add(new edge(1,0,5));
     //   graph[1].add(new edge(1,2,1));
        graph[1].add(new edge(1,3,3));
        
        //vertex2
        graph[2].add(new edge(2,1,1));
     //   graph[2].add(new edge(2,3,1));
        graph[2].add(new edge(2,4,4));
        
        graph[3].add(new edge(3,5,3));
        graph[3].add(new edge(3,1,5));
      //  graph[3].add(new edge(3,2,1));
        
        graph[4].add(new edge(4,5,1));
        graph[4].add(new edge(4,2,5));
        graph[5].add(new edge(5,6,5));
        graph[5].add(new edge(5,3,5));
        graph[5].add(new edge(5,4,5));
        graph[6].add(new edge(6,5,5));
        
        //2s neighbour
        for(int i=0;i<graph[2].size();i++){
            edge e=graph[2].get(i);
            System.out.println(e.dest);
        }

    }
public static void bfs(ArrayList<edge>graph[]){
    boolean vis[] =new boolean[graph.length];

    for(int i=0;i<graph.length;i++){
        if(!vis[i]){
           bfsutil(graph, vis);
        }
    }
}
    public static void bfsutil(ArrayList<edge> graph[],boolean vis[]){
        Queue<Integer>q=new LinkedList<>();


        q.add(0);
while(!q.isEmpty())
;{
    int curr=q.remove();
    
    if(!vis[curr]){
        System.out.print(curr+" ");
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            edge e=graph[curr].get(i);
            q.add(e.dest);
          }
    }
}  
} 
public static void dfs(ArrayList<edge>graph[],int curr,boolean vis[]){
    //visit
    System.out.print(curr);
    vis[curr]=true;

    for(int i=0;i<graph[curr].size();i++){
        edge e=graph[curr].get(i);
        if(!vis[e.dest]){
            dfs(graph,e.dest, vis);
        }
    }
}
    public static void main(String[]args){
int v=5;
ArrayList<edge> graph[] = new ArrayList[v];
creategraph(graph);
bfs(graph);
//dfs(graph,0,new boolean[v]);
    
    }
} 
