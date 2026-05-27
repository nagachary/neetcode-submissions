class Solution {
     public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] incoming_edge_table = new int[numCourses];
        for (int[] pre_requisite : prerequisites) {
            int current_course = pre_requisite[0];
            incoming_edge_table[current_course]++;
        }

        Set<Integer> hash_set = new HashSet<>();
        for (int i = 0; i < incoming_edge_table.length; i++) {
            if (incoming_edge_table[i] == 0) {
                hash_set.add(i);
            }
        }

        //Return false when there are no nodes with incoming edges count is zero.
        // which means it is a cyclic graph
        if (hash_set.isEmpty()) {
            return new int[]{};
        }

        int[] result = new int[numCourses];
        int idx = 0;
        while (!hash_set.isEmpty()) {
            Iterator<Integer> iterator = hash_set.iterator();
            Integer node_element = iterator.next();// this is the node which has zero incoming edges.

            // Remove the edges (connection) the node with zero incoming edges has.
            for (int course = 0; course < prerequisites.length; course++) {
                //Find the pre_requisite course from the prerequisites
                int pre_requisite = prerequisites[course][1];
                // Find the connection
                if (pre_requisite == node_element) {
                    int current_course = prerequisites[course][0];
                    // remove the incoming edges of the current course.
                    incoming_edge_table[current_course]--;
                    if (incoming_edge_table[current_course] == 0) {
                        hash_set.add(current_course);
                    }
                }

            }
            result[idx++] = node_element;
            hash_set.remove(node_element);
        }
        // check if there is a cycle
        for (int course : incoming_edge_table) {
            if (course > 0) {
                return new int[]{};
            }
        }
        return result;
    }
}
