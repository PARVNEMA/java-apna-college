public class tries2 {
    static class node{
        node children[]=new node[26];
        boolean eow=false;

       public node(){
        for(int i=0;i<26;i++){
            children[i]=null;
        }
       }
        }
        public static node root=new node();

  public static boolean startsswith(String key){
            node curr=root;

            for(int i=0;i<key.length();i++){
                int idx=key.charAt(i)-'a';

                if(curr.children[idx]==null){
return false;   }
curr=curr.children[idx];

            }
            return false; 
            }
        }
    


