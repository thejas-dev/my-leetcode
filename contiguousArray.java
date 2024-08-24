class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int maxSum = 0;

        for(int i = 0; i < nums.length; i++){
            sum += nums[i] == 1 ? 1 : -1;

            if(map.containsKey(sum)){
                maxSum = Math.max(maxSum,i - map.get(sum));
            }else{
                map.put(sum,i);
            }
            if(sum == 0){
                maxSum = Math.max(maxSum,i+1);
            }
        }

        return maxSum;

        // Failed some test cases
        // Map<Integer,Integer> map = new HashMap<>();

        // for(int i = 0; i < nums.length; i++){
        //     if(nums[i] == 0){
        //         map.put(0,map.getOrDefault(0,0)+1);
        //     }else{
        //         map.put(1,map.getOrDefault(1,0)+1);
        //     }
        // }

        // int res = 0;

        // if(map.get(0) != null && map.get(1) != null){
        //     if(map.get(0) > map.get(1)){
        //         res = map.get(1) * 2;
        //     }else{
        //         res = map.get(0) * 2;
        //     }
        // }

        // System.out.println(res);

        // return res;

    }
}