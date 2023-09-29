class Solution:
    def isMonotonic(self, nums: List[int]) -> bool:
        n = len(nums)
        if n == 1: return True
        
        # check if this is increasing        
        for i in range(1, n):
            if nums[i] < nums[i-1]:
                break
            
            if i == n - 1:
                return True

        # check if this is decreasing
        for i in range(1, n):
            if nums[i] > nums[i-1]:
                break
            
            if i == n - 1:
                return True

        return False
