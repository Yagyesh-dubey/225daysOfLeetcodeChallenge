class Solution {
public:
    int bestClosingTime(string c) {
      int p =0; 
      for(int i=0;i<c.size();i++){
             if(c[i]=='Y')p++;
      }
      int no=0;
      int ans =p;
      int in =0;
      for(int i=0;i<c.size();i++){
          if(c[i]=='Y'){
           p--;
          }else{
            no++;
          }
          if(ans>no+p){
            in = i+1;
            ans =no+p;
          }
         
      }
       
      return in;


    }
};
