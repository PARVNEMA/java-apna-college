import java.util.Stack;
public class decodestring {
   public static String decode(String str) {
Stack<Integer>integer=new Stack<>();
Stack<Character>charstack=new Stack<>();

String temp=" ",result=" ";

for(int i=0;i<str.length();i++){
    //if str[i]==digit
    int count=0;
    if(Character.isDigit(str.charAt(i))){
       
        while(Character.isDigit(str.charAt(i))){
count=count*10+str.charAt(i)-'0';
i++;
        }
        i--;
        integer.push(count);
    }
    else if(str.charAt(i)=='['){
if(Character.isDigit(str.charAt(i-1))){
    charstack.push(str.charAt(i));
}
else{
    charstack.push(str.charAt(i));
    integer.push(1);  
}
    }
    else if(str.charAt(i)==']'){
        temp=" ";
         count=0;
        if(!integer.isEmpty()){
  count=integer.peek();
  integer.pop();
        }
        while(!charstack.isEmpty()&&charstack.peek()!='['){
            temp=charstack.peek()+temp;
            charstack.pop();
        }
        if(!charstack.isEmpty()&&charstack.peek()!='['){
            charstack.pop();
        }
        for(int j=0;j<count;j++){
            result=result+temp;
        }
        for(int j=0;j<result.length();j++){
            charstack.push(result.charAt(j));
        }
        result=" ";
        
    }
    else{
        charstack.push(str.charAt(i));
    }
 
}
return result;
   }
   public static void main(String[] args) {
    String str = "3[b2[ca]]";
System.out.println(decode(str));

   }
}
