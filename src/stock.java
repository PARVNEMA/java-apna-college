public class stock {
    public static int stockselling(int prices[]){
        int buy=Integer.MAX_VALUE;
        int maxprofit=Integer.MIN_VALUE;
        for(int i=0;i<prices.length;i++){
            for(int j=i+1;j<prices.length;j++){
                buy=Math.min(buy,prices[i]);

                int profit=prices[j]-buy;

                maxprofit=Math.max(profit,maxprofit);
            }
        }
        return maxprofit;
    }
    public static void main(String[] args) {
    int prices[] = {7, 1, 5, 3, 6, 4};
    System.out.println(stockselling(prices));

    }
}
