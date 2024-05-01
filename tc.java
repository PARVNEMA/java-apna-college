public class tc {
    static int floorSqrt(int x)
{
if (x == 0 || x == 1)
return x;
int i = 1, result = 1;
while (result <= x) {
i++;
result = i * i;
}
return i ;
}
public static void main(String[] args)
{
int x = 4;
System.out.print(floorSqrt(x));

} }
