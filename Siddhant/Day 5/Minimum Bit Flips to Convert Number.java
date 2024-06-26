Approach - 1
class Solution {
    public int minBitFlips(int start, int goal) {
        String val1=Integer.toBinaryString(start);
        String val2=Integer.toBinaryString(goal);
        int i=val1.length()-1,j=val2.length()-1;
        int count=0;
        while(i>=0 && j>=0)
        {
            char c=val1.charAt(i--);
            char d=val2.charAt(j--);
            if((c=='1' && d=='0') || (c=='0' && d=='1'))
            {
                count++;
            }
        }
        while(i>=0)
        {
            char c=val1.charAt(i--);
            if(c=='1')
            {
                count++;
            }
        }
        while(j>=0)
        {
            char d=val2.charAt(j--);
            if(d=='1')
            {
                count++;
            }
        }
        return count;
    }
}

-------------------------------------------------------------------------------------------
Approach - 2

class Solution {
    public int minBitFlips(int start, int goal) {
        int count=0;
        while(start!=0 && goal !=0)
        {
            if(((start&1)==1 && (goal&1)==0) || ((start&1)==0 && (goal&1)==1))
            {
                count++;
            }
            start>>=1;
            goal>>=1;
        }
        while(start!=0)
        {
            if((start&1)==1)
            {
                count++;
            }
            start>>=1;
        }
        while(goal!=0)
        {
            if((goal&1)==1)
            {
                count++;
            }
            goal>>=1;
        }
        return count;
    }
}