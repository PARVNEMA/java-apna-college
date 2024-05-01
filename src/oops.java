public class oops{
    public static int opower(int x,int n){
       if(n==0){
        return 1;
       }
       int halfpower= opower(x, n/2);
       int halfsquare =halfpower *halfpower;
       //odd;
       if(n%2 !=0){
      return halfsquare=x*halfsquare;
       }
       return halfsquare;
    }
    public static void main(String args[]){
System.out.println(opower(2,5));

    }
}