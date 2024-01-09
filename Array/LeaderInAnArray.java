package Array;

public class LeaderInAnArray {
    public int[] getLeaders(int[] A) {
        int n = A.length;
        int max = A[n-1];
        int count=1;
        for(int i=n-2;i>=0;i--)
        {
            if(A[i]>max)
            {
                max = A[i];
                count++;
            }
        }
        int [] ans = new int[count];
        ans[0]=A[n-1];
        int maxi=A[n-1];
        int cnt=1;
        for(int i=n-2;i>=0;i--)
        {
            if(A[i]>maxi)
            {
                maxi=A[i];
                ans[cnt]=maxi;
                cnt++;
            }
        }
        return ans;
    }
}
