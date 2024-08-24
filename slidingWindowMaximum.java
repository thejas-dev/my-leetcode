class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();

        int[] res = new int[nums.length - k + 1];
		int idx = 0;		
		
		for(int i = 0; i < nums.length; i++){
            if(!deque.isEmpty() && deque.peekFirst() == i-k){
                deque.removeFirst();
            }

            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.removeLast();
            }
            deque.addLast(i);

			if(i + 1 >= k){
				res[idx++] = nums[deque.peekFirst()];
			}
		}	

        return res;
    }
}