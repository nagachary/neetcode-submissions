class Solution {
    public int longestConsecutive(int[] nums) {
         if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        List<Integer> numsList = new ArrayList<>();
        for (int num : nums) {
            numsList.add(num);
        }

        int numsListSize = numsList.size();
        List<Integer> seqIdxList = new ArrayList<>();
        List<Integer> preSeqIdxList = new ArrayList<>();
        for (int i = 0; i < numsListSize; i++) {
            int ele = numsList.get(i) - 1;


            if (!preSeqIdxList.contains(ele) && !numsList.contains(ele)) {
                preSeqIdxList.add(ele);
                seqIdxList.add(i);
            }
        }

        if (seqIdxList.size() == 1) {
            return new HashSet<>(numsList).size();
        }

        if (seqIdxList.get(seqIdxList.size() - 1) != numsListSize - 1) {
            seqIdxList.add(numsListSize);
        }

        if (seqIdxList.get(seqIdxList.size() - 1) != (numsListSize - 1)) {
            System.out.println("seqIdxList doesn't contain last index");
        }
        int firstEle = 0;
        int nextEele = firstEle + 1;
        List<Integer> seqLengthList = new ArrayList<>();
        while (nextEele < seqIdxList.size()) {
            int firstIdx = seqIdxList.get(firstEle);
            int secondIdx = seqIdxList.get(nextEele);
            List<Integer> subList = numsList.subList(firstIdx, secondIdx);
            Set<Integer> set = new HashSet<>(subList);
            seqLengthList.add(set.size());
            firstEle = nextEele;
            nextEele++;
        }
        if (seqIdxList.contains(numsList.size() - 1)) {
            seqLengthList.add(1);
        }
        Collections.sort(seqLengthList);

        return seqLengthList.get(seqLengthList.size() - 1);
    
    }
}
