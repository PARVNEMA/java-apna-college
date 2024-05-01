import java.util.*;
public class j{
public static int returnvowel(String s){
    int count=0;
    for(int i=0;i<s.length();i++){
        if(s.charAt(i)=='a'||s.charAt(i)=='e'||s.charAt(i)=='i'||s.charAt(i)=='o'||s.charAt(i)=='u'){
   count ++;
        }
    }
    return count;
}
public static void anagram(String str1,String str2){
    int count=str1.length();
    if(count !=str2.length()){
       System.out.println("not anagram");
    }
    for(int i=0;i<str1.length();i++){
        char ch=str1.charAt(i);
        for(int j=0;j<str2.length();j++){
    if(ch==str2.charAt(j)){
        count --;
    }
        }
    }
    if(count !=0){
        System.out.print("not anagram");
    }
    else{
        System.out.println("anagram");
    }
}
public static void main(String args[]){
   String s="earth";
   String r="heart";
 //  anagram(s, r);
 
// Convert uppercase character to lowercase
for (char ch = 'A'; ch <= 'Z'; ch++) {
    System.out.print((char)(ch |' '));
    // prints abcdefghijklmnopqrstuvwxyz
    }
    }
    
}
