class Solution {
    public void reverse(char[] sArr)
    {
        int i=0;
        int j=sArr.length-1;

        while(i<j)
        {
            char temp=sArr[i];
            sArr[i]=sArr[j];
            sArr[j]=temp;
            i++;
            j--;
        }
        return ;
    }
    public int largestVariance(String s) {
        
        HashSet<Character> set=new HashSet<>();

        for(char ch:s.toCharArray())
        {
            set.add(ch);
        }

        int ans=0; 

        for(char ch1:set)
        {
            for(char ch2:set)
            {
                if(ch1==ch2) continue;

                int times=2;

                char[] sArr=s.toCharArray();
                while(times-->0)
                {
                    int countCh1=0;
                    int countCh2=0;
                    for(char ch:sArr)
                    {
                        if(ch==ch1)
                        {
                            countCh1++;
                        }
                        if(ch==ch2)
                        {

                            countCh2++;
                        }
                        
                        if(countCh2>countCh1)
                        {
                            countCh1=0;
                            countCh2=0;

                        }
                        if(countCh1>0  && countCh2>0)
                        {
                            ans=Math.max(ans,countCh1-countCh2);
                        }
                    }
                     reverse(sArr);

                }
            }
        }

        return ans;
    }
}
