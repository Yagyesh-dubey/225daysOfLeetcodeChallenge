class Solution {
    public boolean isSubsequence(String s, String t) {
        int n = t.length(), m = s.length(), i = 0, j = 0;
        char [] ss = s.toCharArray(), tt = t.toCharArray();

        if(m < 1) return true;

        while(i < n) {
            if(tt[i] == ss[j]) j++;
            i++;
            if(j == m) return true;
        }
        return false;
    }
}















// class Solution {
//     public boolean isSubsequence(String s, String t) {
        
//         int c=0;

//         for(int i=0;i<s.length();i++)
//         {
//             for(int j=i;j<t.length();j++)
//             {
//                 if(s.charAt(i)==(t.charAt(j)))c++;
//             }
//         }
//         if(c==s.length()) return true;
//         else return false;
//     }
// }
