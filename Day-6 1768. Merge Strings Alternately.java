class Solution {
    public String mergeAlternately(String word1, String word2) {
        
        String s="";
        int a=Math.min(word1.length(),word2.length());

        for(int i=0;i<a;i++)
        {
            s=s+word1.charAt(i);
            s=s+word2.charAt(i);
        }
        if(word1.length()>word2.length()) return s+word1.substring(a);
        else return s+word2.substring(a);

    }
}
