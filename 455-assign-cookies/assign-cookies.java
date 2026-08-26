class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int ans=0;
        int str=0;
        int str2=0;
        while(str2 < s.length&& str<g.length){
           if(s[str2]>=g[str] ){
            ans++;
            str2++;
            str++;
           }else if(s[str2]<g[str]){
            str2++;
           }
        }
        return ans;
    }
}