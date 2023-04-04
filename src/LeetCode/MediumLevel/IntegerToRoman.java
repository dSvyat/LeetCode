package LeetCode.MediumLevel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given an integer, convert it to a roman numeral.
 */
public class IntegerToRoman {


    public static String intToRoman(int num) {
        String ans = "";

        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};


        for(int i=0;i<values.length;i++) {
            while(num >= values[i]) {
                num -= values[i];
                ans +=strs[i];
            }
        }
        return ans;
    }
        /*
        String ans = "";
        Map<Integer, String> map = new HashMap<>();
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 200, 300, 400, 500, 600, 700, 800, 900, 1000, 2000, 3000};
        String[] romans = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM", "M", "MM", "MMM"};
        for (int i = 0; i < ints.length; i++) {
            map.put(ints[i], romans[i]);
        }
        int ones = num % 10;
        int tens = num % 100 - ones;
        int hundreds = num % 1000 - tens - ones;
        int thousands = num % 10000 - hundreds - tens - ones;
        if (tens == 0) return map.get(ones);
        if (hundreds == 0) return map.get(tens) + map.get(ones);
        if (thousands == 0) return map.get(hundreds) + map.get(tens)+map.get(ones);
        return map.get(thousands) + map.get(hundreds) + map.get(tens) + map.get(ones);

         */
    }
