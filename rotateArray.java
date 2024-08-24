class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;

        int rotateIdx = nums.length - k; // 4
        int[] res = new int[nums.length];

        // Beats 27.92% (Optimal - O(n))
        for(int i = 0; i < nums.length; i++){
            if(rotateIdx >= nums.length){
                rotateIdx = 0;
            }
            res[i] = nums[rotateIdx]; 
            rotateIdx++;
        }
        for(int i = 0; i < nums.length; i++){
            nums[i] = res[i];
        }

        // Brute Method O(n^2)
        // for(int i = 0; i < k; i++){
        //     int temp = nums[nums.length-1];
        //     int temp2 = nums[0];
        //     for(int j = 1; j < nums.length; j++){
        //         int temp3 = nums[j];
        //         System.out.println(temp + " " + temp2 + " " + temp3);
        //         nums[j] = temp2;
        //         temp2 = temp3;
        //     }
        //     nums[0] = temp;
        // }

    }
}