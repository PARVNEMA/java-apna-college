public class rec2{
    public static void pbs(int n,int lastplace,String str){
        //base
        if(n==0){
            System.err.println(str);
            return;
        }
        pbs(n-1, 0, str+"0");
        if(n==0){
            pbs(n-1, 1, str+"1");

        }
    }
    public static void main(String args[])
{pbs(4, 0, " ");
}
}