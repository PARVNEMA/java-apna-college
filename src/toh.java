public class toh {
    public static void towerofhanoi(int n,char src,char dest,char help){
        if(n==1){
            System.out.println("move disk"+n+"from"+src+"to"+help);
            return;
        }
        towerofhanoi(n-1, src, help, dest);
    
    System.out.println("move disk"+n+"from"+src+"to"+help);

    towerofhanoi(n-1, help, dest, src);
}
public static void main(String[] args) {
    int n=3;
    towerofhanoi(n, 'a', 'c', 'b');
}
}
