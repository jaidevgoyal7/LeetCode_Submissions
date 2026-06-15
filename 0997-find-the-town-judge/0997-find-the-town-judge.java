class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] incoming = new int[n + 1];
        int[] outgoing = new int[n + 1];

        for (int[] t : trust) {
            int a = t[0];
            int b = t[1];

            outgoing[a]++;
            incoming[b]++;
        }

        for (int person = 1; person <= n; person++) {

            if (incoming[person] == n - 1 &&
                    outgoing[person] == 0) {
                return person;
            }
        }

        return -1;
    }
}