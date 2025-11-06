package 프로그래머스;

public class Array {
    public static String fn(String str, int idx, boolean [] seen){
        if(idx <0) return "";
        char c = str.charAt(idx);
        String result = fn(str, idx-1, seen);
        if(!seen[c]){
            seen[c] = true;
            return c+result;
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "abacabcd";
        int len = str.length();
        boolean [] seen = new boolean[256];
        System.out.println(fn(str, len-1, seen));
    }
}
