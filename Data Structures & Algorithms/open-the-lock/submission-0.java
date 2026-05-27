class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        // 0000 is the default and first position of the 4 wheels together
        if (visited.contains("0000")) {
            return -1;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        visited.add("0000");

        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String lock = queue.poll();
                if (lock.equals(target)) {
                    return count;
                }

                for (String next : children(lock)) {
                    if (!visited.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }

                }

            }
            count++;
        }
        return -1;
    }

    /* This method is to generate the possible next lock values ny increasing and decreasing 1 at each index of the lock and adding it to list */
    private List<String> children(String lock) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            char[] arr = lock.toCharArray();
            arr[i] = (char) ((arr[i] - '0' + 1) % 10 + '0');
            result.add(new String(arr));

            arr = lock.toCharArray();
            arr[i] = (char) ((arr[i] - '0' - 1 + 10) % 10 + '0');

            result.add(new String(arr));
        }

        return result;
    }
}