package com.wuss.leetCode;

public class Main6 {

    public String convert(String s, int numRows) {
        int strLen = s.length();
        if(numRows == 1 || strLen <= 1){
            return s;
        }
        int len = (numRows -1)*2;
        StringBuilder sb = new StringBuilder();
        for (int i =0;i<numRows;i++){
            int start = i,end = len - i;
            for (int j=0;j*len < strLen;j++){
                if( i == 0 || i == numRows -1){
                    if(start + j*len < strLen){
                        sb.append(s.charAt(start+j*len));
                    }

                }else {
                    if(start + j *len < strLen){
                        sb.append(s.charAt(start+j*len));
                    }

                    if(end + j *len < strLen){
                        sb.append(s.charAt(end+j*len));
                    }


                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Main6 main6 = new Main6();
        String s = "LEETCODEISHIRING";
        int numRows = 4;
        System.out.println(main6.convert(s,numRows));
    }
}
