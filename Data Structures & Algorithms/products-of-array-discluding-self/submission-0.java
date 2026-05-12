class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod1 = 1;
        int prod2 = 1;
        int count = 0;

        for(int x : nums){
            prod1 *= x;
            if(x == 0){
                count++;
            } else{
                prod2 *= x;
            }
        }
        for(int i=0; i<nums.length; i++){
            if(count > 1){
                nums[i] = 0;
            }
            else if(count == 1 && nums[i]==0 ){
                nums[i] = prod2;
            }
            else{
                nums[i] = prod1 / nums[i];
            }
        }
        return nums;
    }
}  
