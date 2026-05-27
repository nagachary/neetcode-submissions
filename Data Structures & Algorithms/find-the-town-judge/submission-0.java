class Solution {
    public int findJudge(int n, int[][] trust) {
        if (trust.length < n - 1) {
            return -1;
        }

        int[] incoming_relations = new int[n + 1];
        int[] outing_relations = new int[n + 1];   

        for (int[] t : trust) {
            outing_relations[t[0]]++;     // a trusts b
            incoming_relations[t[1]]++;   // b is trusted
        }

        for (int i = 1; i <= n; i++) {
            if (incoming_relations[i] == n - 1 && outing_relations[i] == 0) {
                return i;
            }
        }

        return -1;
    }
}