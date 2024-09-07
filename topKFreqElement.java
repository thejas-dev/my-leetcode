class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer,Integer> map = new HashMap<>();
        List<Integer>[] freq = new List[nums.length+1];

        int[] res = new int[k];
        int idx = 0;

        for(int i = 0; i < freq.length; i++){
            freq[i] = new ArrayList<>();
        }

        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            freq[entry.getValue()].add(entry.getKey());
        }

        for(int i = freq.length-1; i >= 1 && idx < k; i--){
            if(freq[i].size() > 0){
                for(int j = 0; j < freq[i].size(); j++){
                    res[idx++] = freq[i].get(j);
                    if(idx >= k) return res;
                }
            }
        }

        return res;
    }
}