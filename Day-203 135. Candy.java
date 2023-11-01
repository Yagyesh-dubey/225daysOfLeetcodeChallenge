class Solution {
    public int candy(int[] ratings) {
        int sz = ratings.length;
        int maxRat = 2 * 10000 + 1;
        int cand[] = new int[sz];
        Arrays.fill(cand, 1);
        int minCand = 0;
        for(int indx = 0; indx < sz; indx++){
           int leftNeigh = (indx - 1) > -1 ? ratings[indx-1] : maxRat;
           int self = ratings[indx];
           if(self > leftNeigh){
              cand[indx] = cand[indx-1] + 1;
           }
        }
        for(int indx = sz-1; indx > -1; indx--){
           int rightNeigh =(indx + 1) < sz ? ratings[indx + 1] : maxRat;
           int self = ratings[indx];
           if(self > rightNeigh){
             if(cand[indx] <= cand[indx+1])
              cand[indx] = cand[indx+1] + 1;
           }
        }
        for(var c : cand){
          minCand += c;
        }
        return minCand; 
    }
}
