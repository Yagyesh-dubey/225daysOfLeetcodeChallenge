public class Solution {
public List<String> summaryRanges(int[] nums) {
 List<String> list =new ArrayList<String>();
 if(nums.length==0)return list;
 int index=0;
 for(int i=0;i<nums.length-1;i++){
     
     if(nums[i+1]-nums[i]!=1){
         if(index!=i){list.add(nums[index]+"->"+nums[i]);}
         else list.add(Integer.toString(nums[index]));
         
         index=i+1;
     }
 }
 if(index==nums.length-1)list.add(Integer.toString(nums[index]));
 else {list.add(nums[index]+"->"+nums[nums.length-1]);}
 return list;
}
}
