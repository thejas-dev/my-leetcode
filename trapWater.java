class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int left_max = 0;
        int right_max = 0;

        int res = 0;

        while(left < right){
            if(height[left] <= height[right]){
                if(height[left] > left_max){
                    left_max = height[left];
                }else{
                    res += (left_max - height[left]);
                }

                left++;
            }else{
                if(height[right] > right_max){
                    right_max = height[right];
                }else{
                    res += (right_max - height[right]);
                }

                right--;
            }
        }
        
        return res;
        
        // int[] prefix_max = new int[height.length];
        // int[] suffix_max = new int[height.length];
        // int trap = 0;

        // int maxPre = 0;
        // int maxSuff = 0;

        // for(int i = 0; i < height.length; i++){
        //     if(height[i] > maxPre){
        //         maxPre = height[i];
        //     }
        //     prefix_max[i] = maxPre; 
        // }

        // for(int i = height.length - 1; i > -1; i--){
        //     if(height[i] > maxSuff){
        //         maxSuff = height[i];
        //     }
        //     suffix_max[i] = maxSuff; 
        // }

        // for(int i = 0; i < height.length; i++){
        //     int res = Math.min(prefix_max[i],suffix_max[i]) - height[i];
        //     trap += res;
        // }

        // return trap;

    }
}