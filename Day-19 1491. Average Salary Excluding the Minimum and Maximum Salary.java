class Solution {
    public double average(int[] salary) {
        Arrays.sort(salary);
        int elemet=0,sum=0;
        for(int i:salary) 
        {
            sum+=i;
            elemet++;
        }
        return (sum-salary[0]-salary[elemet-1])*1.0/(elemet-2);
    }
}
