// https://leetcode.com/problems/longest-uncommon-subsequence-ii/solution/

class Solution {
    public boolean isSubsequence(String x, String y) {
        int j = 0;
        for (int i = 0; i < y.length() && j < x.length(); i++)
            if (x.charAt(j) == y.charAt(i))
                j++;
        return j == x.length();
    }
    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, new Comparator < String > () {
            public int compare(String s1, String s2) {
                return s2.length() - s1.length();
            }
        });
        for (int i = 0, j; i < strs.length; i++) {
            boolean flag = true;
            for (j = 0; j < strs.length; j++) {
                if (i == j)
                    continue;
                if (isSubsequence(strs[i], strs[j])) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                return strs[i].length();
        }
        return -1;
    }
}