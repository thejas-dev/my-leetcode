class Solution {
    TreeSet<Integer> minHeap, maxHeap;

    public void balanceHeap(){
        if(maxHeap.size() > minHeap.size()) minHeap.add(maxHeap.pollFirst());
    }

    public Double calculateMedian(int[] nums, int k){
        if(k % 2 == 0) return ((double) nums[minHeap.first()] + nums[maxHeap.first()]) / 2;
        
        return (double) nums[minHeap.first()];
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        Comparator<Integer> comparator = (a, b) -> nums[a] != nums[b] ? Integer.compare(nums[a],nums[b]) : a-b;

        minHeap = new TreeSet<>(comparator);
        maxHeap = new TreeSet<>(comparator.reversed());

        double[] res = new double[nums.length - k + 1];
        int idx = 0;

        for(int i = 0; i < nums.length; i++){
            if(i >= k){
                minHeap.remove(i - k);
                maxHeap.remove(i - k);
            }
            
            minHeap.add(i);
            maxHeap.add(minHeap.pollFirst());

            balanceHeap();

            if(i >= k - 1){
                
                res[idx++] = calculateMedian(nums,k);
            }

        }

        return res;
    }
}