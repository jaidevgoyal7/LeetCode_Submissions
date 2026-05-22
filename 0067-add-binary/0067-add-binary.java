class Solution {
    public String addBinary(String a, String b) {

        int n = a.length();
        int m = b.length();

        if (n < m) {
            return addBinary(b, a);
        }

        int j = m - 1;
        int carry = 0;
        StringBuilder result = new StringBuilder();

        for (int i = n - 1; i >= 0; i--) {

            int bit1 = a.charAt(i) - '0';
            int sum = bit1 + carry;

            if (j >= 0) {
                int bit2 = b.charAt(j) - '0';
                sum += bit2;
                j--;
            }
            int bit = sum % 2;
            carry = sum / 2;
            result.append((char)(bit + '0'));
        }
        if (carry > 0)
            result.append('1');

        return result.reverse().toString();
        
    }
}