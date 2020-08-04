package eg.interview;

// https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
public class SubString {
    private int maxSubString(String a) {
        if (a == null || a.length() == 0) return 0;
        int max = 1;
        int m=0,n=0;
        for (n = 0; n < a.length(); n++) {
            for (m = n; m < a.length(); m++) {
                if (contain(a, n, m, a.charAt(m)) && (m - n) > max) {
                    max = m - n;
                    break;
                } else if (contain(a, n, m, a.charAt(m)) && (m - n) <= max) {
                    break;
                } else if (m-n+1>max) {
                    max = m - n+1;
                }
            }
        }
        return max;
    }

    public int maxSubString2(String a) {
        int n = 0;
        int m = 0;
        int max = 0;
        while (m < a.length()) {
            int index = index(a, n, m, a.charAt(m));
            if (index!=-1 && m-n>max) {  // 包含
                max = m-n;
                n += index+1;
                m = n;
                continue;
            } else if (index!=-1)  { // 包含
                n += index+1;
                m = n;
                continue;
            }
            m++;
        }
        if (m - n > max) {
            max = m - n;
        }
        return max;
    }

    private boolean contain(String a, int start, int end, char m) {
        for (int i = start; i < end; i++) {
            char c = a.charAt(i);
            if (m == c)
                return true;
        }
        return false;
    }

    private int index(String a, int start, int end, char m) {
        for (int i = start; i < end; i++) {
            char c = a.charAt(i);
            if (m == c)
                return i-start;
        }
        return -1;
    }

    public static void main(String[] args) {
        SubString ss = new SubString();
        String a = "au";
//        String a = "abcabcbb";
//        String a = "pwwkew";
        int s = ss.maxSubString(a);
        System.out.println(s);
    }
}
