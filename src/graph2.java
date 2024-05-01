import java.util.*;
import java.util.Queue;
import java.util.Stack;
public class graph2 {
   static class edge{
    int src;
    int dest;
    public int est;


    public edge(int s,int d){
        this.src=s;
        this.dest=d;
        
    }
   } 
   public static void creategraph(ArrayList<edge>graph[]){

    for(int i=0;i<graph.length;i++){
        graph[i]=new ArrayList<>();
    }
  //  graph[0].add(new edge(0,1));
   // graph[0].add(new edge(0,2));

   // graph[1].add(new edge(1,0));
  //  graph[1].add(new edge(1,0));

    graph[3].add(new edge(3,1));
   // graph[3].add(new edge(3,4));

   graph[4].add(new edge(4,1));

    graph[4].add(new edge(4,0));

    graph[2].add(new edge(2,3));

    graph[5].add(new edge(5,0));
   graph[5].add(new edge(5,2));

   }
   public static boolean iscycle(ArrayList<edge>graph[]){
    boolean vis[]=new boolean[graph.length];
    boolean stack[]=new boolean[graph.length];

    for(int i=0;i<graph.length;i++){
        if(!vis[i]){
       if(iscycleutil(graph, i, vis, stack)){
        return true;
       }
        }
    }
    return false;
   }
   public static boolean iscycleutil(ArrayList<edge>graph[],int curr,boolean vis[],boolean stack[]){
    vis[curr]=true;
    stack[curr]=true;

    for(int i=0;i<graph[curr].size();i++){
        edge e=graph[curr].get(i);

        if(stack[e.dest]){
            return true;
        }
        if(!vis[e.dest]&&iscycleutil(graph, e.dest, vis, stack)){
            return true;
        }
    }
    stack[curr]=false;
    return false;

   }
   public static boolean isbipartite(ArrayList<edge>graph[]){
    int col[]=new int [graph.length];
    for(int i=0;i<col.length;i++){
        col[i]=-1;
        }

        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<graph.length;i++){
            if(col[i]==-1){
                q.add(i);
                col[i]=0;
                while(!q.isEmpty()){
                    int curr=q.remove();

                    for(int j=0;j<graph[curr].size();j++){
  edge e=graph[curr].get(j);

  if(e.dest==-1){
    int nextcol=col[curr]==0 ?1:0;
    e.dest=nextcol;

    q.add(e.dest);
  } else if(col[e.dest]==col[curr]){
    return false;
  }
  
                    }
                    
                }
            }
        }
        return true;
   }
   public static void dfs(ArrayList<edge>graph[],boolean vis[],int curr){

    //visit
    System.out.print(curr
    );
    vis[curr]=true;

    for(int i=0;i<graph[curr].size();i++){
        edge e=graph[curr].get(i);

        if(!vis[e.dest]){
            dfs(graph, vis, e.dest);
        }
    }
   }
   public static boolean detectcycle(ArrayList<edge> []graph){
    boolean vis[]=new boolean[graph.length];

    for(int i=0;i<graph.length;i++){
        if(!vis[i]){
          if(  detectutil(graph,vis,i,-1)){
            return true;
          }
        }
    }
    return false;
   } 
   public static boolean detectutil(ArrayList<edge>graph[],boolean vis[],int curr,int par){
    vis[curr]=true;

    for(int i=0;i<graph[curr].size();i++){
        edge e=graph[curr].get(i);
//case 3
        if(!vis[e.dest]){
            if(detectutil(graph, vis, e.dest, curr))
            return true;
        }

        //case 1;
        if(vis[e.dest]&&e.dest!=par)
{
    return true;
}    }
return false;
   }

   public static void topsort(ArrayList<edge>graph[]){
    boolean vis[]=new boolean[graph.length];
    Stack<Integer>s=new Stack<>();

    for(int i=0;i<graph.length;i++){
        if(!vis[i]){
            topsortutil(graph,i,vis,s);
        }
    }
    while(!s.isEmpty()){
        System.out.print(s.pop());
    }
   }
   public static void topsortutil(ArrayList<edge>graph[],int curr,boolean vis[],Stack<Integer>s){
    vis[curr]=true;

    for(int i=0;i<graph[curr].size();i++){
        edge e=graph[curr].get(i);
        if(!vis[e.dest]){
            topsortutil(graph,e.dest,vis,s);
        }
    }
    s.push(curr);
   }
   public static void main(String[] args) {
    int v=5;
    ArrayList<edge>graph[]=new ArrayList[v];
     creategraph(graph);
   // dfs(graph, new boolean[v] , 0 );
 //  System.out.println(detectcycle(graph));
// System.out.println(isbipartite(graph));
//System.out.println(iscycle(graph));
topsort(graph);
}
}
