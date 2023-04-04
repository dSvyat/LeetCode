package LeetCode.EasyLevel;

/*
Given an integer x, return true if x is a
palindrome, and false otherwise.
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x<0 || (x!=0 && x%10==0)) return false;
        int a = 0;
        while (x>a){
            a = a*10 + x%10;
            x = x/10;
        }
        return (x==a || x==a/10);
    }
}

