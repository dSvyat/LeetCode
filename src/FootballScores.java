import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FootballScores {
    public static void main(String[] args) {
        //list A = 1, 4, 2, 4
        //list b = 3, 5
        List<Integer> listA = Arrays.asList(1,4,2,4);
        List<Integer> listB = new ArrayList<>();
        System.out.println(counts(listA, listB));
    }
    public static List<Integer> counts(List<Integer> teamA, List<Integer> teamB) {
        // Write your code here
        Collections.sort(teamA);

        ArrayList<Integer> res = new ArrayList<>();

        for (Integer integer : teamB) {
            int startIndex = 0;
            int endIndex = teamA.size() - 1;
            while (startIndex <= endIndex) {
                int mid = (startIndex + endIndex) / 2;
                if (teamA.get(mid) > integer) {
                    endIndex = mid - 1;
                } else {
                    startIndex = mid + 1;
                }
            }
            res.add(startIndex);
        }
        return res;
        /*
        List<Integer> list = new ArrayList<>();
        int count = 0;
        for (Integer elemB : teamB){
            for (Integer elemA : teamA) {
                if (elemA <= elemB) count++;
            }
            list.add(count);
            count = 0;
        }
        return list;

         */
    }
}
