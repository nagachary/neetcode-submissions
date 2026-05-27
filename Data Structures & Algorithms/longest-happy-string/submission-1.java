class Solution {
    private record CharPair(Character charcter, Integer count) {
    }

    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<CharPair> priorityQueue = new PriorityQueue<>((c1, c2) -> c2.count - c1.count);
        priorityQueue.add(new CharPair('a', a));
        priorityQueue.add(new CharPair('b', b));
        priorityQueue.add(new CharPair('c', c));
        System.out.println("priorityQueue : " + priorityQueue);
        CharPair issuePair = null;
        while (!priorityQueue.isEmpty()) {
            CharPair charPair = priorityQueue.poll();
            Character currentChar = charPair.charcter;
            int sbLength = sb.length();
            String subString = sb.length() >= 2 ? sb.substring(sbLength - 2, sbLength) : sb.toString();
            if (("aa".equals(subString) && Objects.equals('a', currentChar)) ||
                    ("bb".equals(subString) && Objects.equals('b', currentChar)) ||
                    ("cc".equals(subString) && Objects.equals('c', currentChar))) {
                issuePair = new CharPair(charPair.charcter, charPair.count);
                continue;

            } else {
                if (null != issuePair) {
                    priorityQueue.add(issuePair);
                    issuePair = null;
                }

                if (charPair.count > 0) {
                    sb.append(charPair.charcter);
                    priorityQueue.add(new CharPair(charPair.charcter, charPair.count - 1));
                }
            }
        }
        return sb.toString();
    }
}