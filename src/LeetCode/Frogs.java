package LeetCode;

/*
There are N blocks, numbered from 0 to N-1, arranged in a row.
A couple of frogs were sitting together on one block when they had a terrible quarrel.
Now they want to jump away from one another so that the distance between them will be as large as possible.
The distance between blocks numbered J and K, where J <= K, is computed as K - J+ 1.
The frogs can only jump up, meaning that they can move from one block to another only
if the two blocks are adjacent and the second block is of the same or greater height as the first.
What is the longest distance that they can possibly create between each
other, if they also chose to sit on the optimal starting block initially?
Write a function:
class Solution { public int solution(int [] blocks);}
that, given an array blocks consisting of N integers denoting the heights of the blocks,
returns the longest possible distance that two frogs can make between each other starting from one of the blocks
 */
public class Frogs {
    public static int solution(int[] blocks) {
        int maxDistance = 0;
        int a = blocks.length;
        int[] leftMaximum = new int[a];
        int[] rightMaximum = new int[a];
        rightMaximum[a - 1] = 0;

        for (int i = 1; i < blocks.length; i++) {
            leftMaximum[i] = (blocks[i - 1] >= blocks[i]) ? leftMaximum[i - 1] + 1 : 0;
        }

        for (int j = a - 2; j >= 0; j--) {
            rightMaximum[j] = blocks[j] <= blocks[j + 1] ? rightMaximum[j + 1] + 1 : 0;
        }

        for (int k = 0; k < a; k++) {
            maxDistance = Math.max(maxDistance, leftMaximum[k] + rightMaximum[k] + 1);
        }
        return maxDistance;
    }
}
