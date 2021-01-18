public class myAtoi {
    public int myAtoi(String str) {
        char[] data=str.trim().toCharArray();
        if(data.length==0){
            return 0;
        }
        boolean flag=true;
        int i=0;
        if(data[0]=='+'||data[0]=='-'){
            if(data[0]=='-'){
                flag=false;
            }
            i++;
        }
        int res=0;
        for(;i<data.length;i++){
            if(!Character.isDigit(data[i])){
                return res;
            }
            if(res/10>Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            if(res/10<Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
            if(res/10==Integer.MAX_VALUE&&(data[i]-'0')>7){
                return Integer.MAX_VALUE;
            }
            if(res/10==Integer.MIN_VALUE&&(data[i]-'0')<-(Integer.MIN_VALUE%10)){
                return Integer.MIN_VALUE;
            }
            res=res*10+(data[i]-'0');
        }
        return flag==true?res:res*-1;
    }
}
