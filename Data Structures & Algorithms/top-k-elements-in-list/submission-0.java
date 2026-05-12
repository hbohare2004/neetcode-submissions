class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((e1, e2) -> map.get(e1) - map.get(e2));

        for(int ele: map.keySet()){
            minHeap.add(ele);

            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        int[] res = new int[k];

        int i=0;
        while(!minHeap.isEmpty()){
            res[i] = minHeap.poll();
            i++;
        }

        return res;
    }
}
