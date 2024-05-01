
import java.util.*;
import java.util.Queue;
public class graph3 {
    static class edge{
        int src;
        int dest;
        int wt;
        public edge(int s,int d,int w){
this.src=s;
this.dest=d;
this.wt=w;
        }
    }
     static void creategrraph(ArrayList<edge>graph[]){
        
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new edge(0,1,10));
        graph[0].add(new edge(0,2,15));
        graph[0].add(new edge(0,3,30));
        graph[1].add(new edge(1,3,40));
        graph[2].add(new edge(2,3,50));
       // graph[4].add(new edge(4,1,-1));
       // graph[3].add(new edge(3,4,4));
       // graph[4].add(new edge(4,3,2));

    }
    public static void indegcreate(ArrayList<edge>graph[],int indeg[]){
        for(int i=0;i<graph.length;i++){
            int v=i;
            for(int j=0;j<graph[v].size();j++){
                edge e=graph[v].get(j);

                indeg[e.dest]++;
            }
        }
    }
    public static void topsortbfs(ArrayList<edge>graph[]){
        int indeg[]=new int[graph.length];
        Queue<Integer>q=new LinkedList<>();
        indegcreate(graph, indeg);
        for(int i=0;i<indeg.length;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int curr=q.remove();
            System.out.print(curr+" ");
        for(int i=0;i<graph[curr].size();i++){
            edge e=graph[curr].get(i);
         indeg[e.dest]--;
         if(e.dest==0){
            q.add(e.dest);
         }
            
        }
        }
        System.out.println();
    }
    public static void printallpath(ArrayList<edge>graph[],int src,int dest,String path){
        if(src==dest){
            System.out.println(path+dest);
            return;
        }
        for(int i=0;i<graph[src].size();i++){
            edge e=graph[src].get(i);

            printallpath(graph, e.dest, dest, path+src);
        }
    }
    static class pair implements Comparable<pair>{
        int n;
        int path;

        public pair(int n,int path){
            this.n=n;
            this.path=path;
        }

        @Override
        public int compareTo(pair n2) {

            return this.path-n2.path;
            // TODO Auto-generated method stub
          //  throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
        }   }
        public static void dijkstra(ArrayList<edge>graph[],int src){
            int dist[]=new int [graph.length];

            for(int i=0;i<graph.length;i++){
                if(i!=src){
                    dist[i]=Integer.MAX_VALUE;
                }
            }
            boolean vis[]=new boolean[graph.length];

            PriorityQueue<pair>pq=new PriorityQueue<>();

            pq.add(new pair(src,0));

            while(!pq.isEmpty()){
                pair curr=pq.remove();
                if(!vis[curr.n]){
                    vis[curr.n]=true;

                    for(int i=0;i<graph[curr.n].size();i++){
                        edge e=graph[curr.n].get(i);

                        int u=e.src;
                        int v=e.dest;
                        int wt=e.wt;

                        if(dist[u]+wt <dist[v]){
                            dist[v]=dist[u]+wt;
                          pq.add(new pair(v,dist[v]));
                        }
                    }
                }
            }
        
        for(int i=0;i<dist.length;i++){
            System.out.print(dist[i]+" ");
            }  
    }
    public static void bellmanford (ArrayList<edge>graph[],int src){
        int dist[]=new int[graph.length];

        for(int i=0;i<dist.length;i++){
            if(i!=src){
                dist[i]=Integer.MAX_VALUE;
            }
        }
        int V=graph.length;
        for(int i=0;i<V-1;i++){
            for(int j=0;j<graph.length;j++){
                for(int k=0;k<graph[j].size();k++){
                    edge e=graph[j].get(k);
                    int u=e.src;
                    int v=e.dest;
                    int wt=e.wt;

                    //relaxation
                    if(dist[u]+wt<dist[v]&&dist[u]!=Integer.MAX_VALUE){
                        dist[v]=dist[u]+wt;
                    }
                }
            }
        }
        //print
        for(int i=0;i<dist.length;i++){
            System.out.print(dist[i]+" ");
        }System.out.println();
    
    }
    static class pairs implements Comparable<pairs>{
int v;
int cost;

public pairs(int v,int c){
    this.v=v;
    this.cost=c;
}
@Override
public int compareTo(pairs p2){
    return this.cost-p2.cost;
}
    }

    public static void prims(ArrayList<edge>graph[]){
        boolean vis[]=new boolean[graph.length];
        PriorityQueue<pairs>pq=new PriorityQueue<>();

        pq.add(new pairs(0,0));
        int finalcost=0;

        while(!pq.isEmpty()){
           pairs curr=pq.remove();
  if(!vis[curr.v]){
    vis[curr.v]=true;
    finalcost+=curr.cost;
    for(int i=0;i<graph[curr.v].size();i++){
        edge e=graph[curr.v].get(i);
        pq.add(new pairs(e.dest,e.wt));
    }
  }
        }
        System.out.println("finalmst is"+finalcost);
    }
    public static void main(String[] args) {
        int V=6;
        ArrayList<edge>graph[]=new ArrayList[5];
        creategrraph(graph);
       // topsortbfs(graph);
       int src=0;
     //  int dest=1;
    //dijkstra(graph,src);
     //  printallpath(graph,src,dest," ");
     //bellmanford(graph, src);
     prims(graph);
    }   
    } 

