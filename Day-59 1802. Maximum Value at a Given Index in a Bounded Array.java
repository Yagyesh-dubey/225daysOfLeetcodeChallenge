 // This method will give you answer of the setup where our peak element is ans at index idx and we have n elements
// So we have two part of array one is the left part (1, 1... 2, 3 ... max - 1) and then (max, max - 1, max - 2, 1 ... 1)
// so you can think of it as we have few extraOnes on both left and right parts and then an AP array which goes upto max
        
// Left part I have taken till max - 1 and right part I have taken from max.
// calcPart takes (first value of AP, number of elements)
        
class Solution {
    public int maxValue(int n, int index, int maxSum) {
        long lt=index;
        long rt=n-index-1;
        long st=1;
        long end=maxSum;
        while(st<=end) {
            long mid=st+(end-st)/2;
            long m=mid-1;
            long ls=0;
            long rs=0;
            if(m>=lt) {
                long notInRange=m-lt;
                ls=m*(m+1)/2-(notInRange)*(notInRange+1)/2;
            }
            else {
                ls=m*(m+1)/2+1*(lt-m);
            }
            if(m>=rt) {
                long notInRange=m-rt;
                rs=m*(m+1)/2-(notInRange)*(notInRange+1)/2;
            }
            else {
                rs=m*(m+1)/2+1*(rt-m);
            }
            long sum=rs+ls+mid;
            if(sum>maxSum) {
                end=mid-1;
            }
            else {
                st=mid+1;
            }
        }
        return (int)end;
    }
}
