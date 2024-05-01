public class csk{
    static String digits[] = {"zero", "one", "two", "three", "four", "five", "six",
"seven", "eight", "nine"};
public static void printDigits(int number) {
if(number == 0) {
return;
}
int lastDigit = number%10;
printDigits(number/10);
System.out.print(digits[lastDigit]);

}
public static int length(String s,int i){
    if(s.length()==0){
        return 0;
    }
    int count=0;
    length(s, i+1);
    count++;
  
  return count;
}
public static void contiguoussubs(String str,int i){
   //base case
   int count=0;
   if(i==str.length()-1){
    return ;
   }

  String s=str.substring(i);
  if(s.charAt(0)==s.charAt(s.length()-1)){
    count++;
  }
  contiguoussubs(str, i+1);
  
  System.out.println(count);
}
public static void main(String[] args) {
    String s="abcab";
    contiguoussubs(s, 0);
}
}