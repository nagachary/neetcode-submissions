class Solution {
    public boolean isIsomorphic(String s, String t) {
    int[] m1 = new int[256];
    int[] m2 = new int[256];
    
    for (int i = 0; i < s.length(); i++) {
        // If the 'last seen' index of these two characters is different, return false
        if (m1[s.charAt(i)] != m2[t.charAt(i)]) {
            return false;
        }
        // Update both to the current index (+1 to distinguish from the default 0)
        m1[s.charAt(i)] = i + 1;
        m2[t.charAt(i)] = i + 1;
    }
    return true;
}
}