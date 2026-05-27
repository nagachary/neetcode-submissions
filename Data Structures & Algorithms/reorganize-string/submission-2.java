class Solution {
    private record Pair(Character character, Integer count) {}

    public String reorganizeString(String s) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> charFreq = new HashMap<>();

        for (char c : s.toCharArray()) {
            charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Pair> freq =
                new PriorityQueue<>((a, b) -> b.count - a.count);

        for (var entry : charFreq.entrySet()) {
            freq.add(new Pair(entry.getKey(), entry.getValue()));
        }

        Pair prev = null;
        while (!freq.isEmpty()) {
            Pair curr = freq.poll();

            sb.append(curr.character);
            if (prev != null && prev.count > 0) {
                freq.offer(prev);
            }
            prev = new Pair(curr.character, curr.count - 1);

        }

        if (prev != null && prev.count > 0) {
            return "";
        }
        return sb.toString();
    }
}