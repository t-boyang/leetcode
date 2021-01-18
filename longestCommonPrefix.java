public class longestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        return recur(strs, 0, strs.length - 1);
    }

    private String recur(String[] strs, int left, int right) {
        if (left >= right) {
            return strs[left];
        }
        int mid = (right - left) / 2;
        String leftStr = recur(strs, left, mid - 1);
        String rightStr = recur(strs, left, mid - 1);
        return merge(leftStr, rightStr);
    }

    private String merge(String left, String right) {
        int min=Math.min(left.length(), right.length());
        StringBuilder builder=new StringBuilder();
        for(int i=0;i<min;i++){
            if(left.charAt(i)!=right.charAt(i)){
                return builder.toString();
            }
            builder.append(left.charAt(i));
        }
        return builder.toString();
    }
}
