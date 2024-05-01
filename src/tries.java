import java.util.*;
public class tries{
    static class node{
   node children[]=new node[26];
   boolean eow=false;
int freq;

public node(){
    for(int i=0;i<26;i++){
        children[i]=null;
    }
    freq=1;
}
    }
    public static node root=new node();
    public static void insert(String word){
        node curr=root;

        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';

            if(curr.children[idx]==null){
                curr.children[idx]=new node();
            }
            else{
                curr.children[idx].freq++;
                    }
                    curr=curr.children[idx];
        }
        curr.eow=true;
    }
public static void findprefix(node root,String ans){
    if(root==null){
        return;
    }
    if(root.freq==1){
        System.out.println(ans);
return;
    }

    for(int i=0;i<root.children.length;i++){
        if(root.children[i]!=null){
            findprefix(root.children[i], ans+(char)(i+'a'));
        }
    }
}
public static int countnode(node root){
    if(root==null){
        return 0;
    }
int count=0;
    for(int i=0;i<26;i++){
        if(root.children[i]!=null){
            count+=countnode(root.children[i]);
        }
    }
    return count+1;
}
public static String finalans=" ";
public static void longestword(node root,StringBuilder temp){
    if(root==null){
        return ;
    }
    for(int i=0;i<26;i++){
        if(root.children[i]!=null&&root.children[i].eow==true){
            char ch=(char)(i+'a');
            temp.append(ch);

            if(temp.length()>finalans.length()){
                finalans=temp.toString();
            }
            longestword(root.children[i], temp);
            temp.deleteCharAt(temp.length()-1);
        }
    }
}
    public static void main(String[] args) {
       String word[]={"a","apple","app","appl","banana","apply"};

       for(int i=0;i<word.length;i++){
        insert(word[i]);
       }
       longestword(root, new StringBuilder(" "));
       System.out.println(finalans);
    }
   
}