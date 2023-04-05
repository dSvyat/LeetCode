package CodeGym.HardLevel;

import java.util.ArrayList;
import java.util.List;

/*
Figure out what the program does.
Implement the calculateHorsesFinished method.
It should:
1. Count the number of finished horses and return it. Use the isFinished() method.
2. If the horse has not yet come to the finish (!isFinished()), then:
2.1 Output "Waiting for " + horse.getName() to the console.
2.2 Wait for her to finish the race. Think about which method to use for this.
2.3 Do not count such a horse as a finisher.

Requirements:
- The calculateHorsesFinished method must return the number of horses that have finished.
- The calculateHorsesFinished method must call the isFinished method on every horse in the passed list.
- If any of the horses passed in the list has not finished yet, the calculateHorsesFinished method should
output "Waiting for " + horse.getName(). An example message for the first horse is "Waiting for Horse_01".
- If any of the horses passed in the list has not finished yet,
the calculateHorsesFinished method should wait for it to finish. Use the correct method for waiting.
- When the program is finished, the console should contain information that all horses have finished.
An example message for the first horse: "Horse_01 has finished the race!
 */
public class HorseRacing {
    public static void main(String[] args) throws InterruptedException {
        List<Horse> horses = prepareHorsesAndStart(10);
        while (calculateHorsesFinished(horses) != horses.size()) {
        }
    }

    public static int calculateHorsesFinished(List<Horse> horses) throws InterruptedException {
        int finishedCount = 0;
        for (Horse horse : horses){
            if (horse.isFinished()) finishedCount++;
            else{
                System.out.println("Waiting for " + horse.getName());
                horse.join();
            }
        }
        return finishedCount;
    }

    public static List<Horse> prepareHorsesAndStart(int horseCount) {
        List<Horse> horses = new ArrayList<>(horseCount);
        String number;
        for (int i = 1; i < horseCount + 1; i++) {
            number = i < 10 ? ("0" + i) : "" + i;
            horses.add(new Horse("Horse_" + number));
        }

        System.out.println("All horses start the race!");
        for (int i = 0; i < horseCount; i++) {
            horses.get(i).start();
        }
        return horses;
    }
}

class Horse extends Thread {

    private boolean isFinished;

    public Horse(String name) {
        super(name);
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void run() {
        String s = "";
        for (int i = 0; i < 1001; i++) {   // Delay
            s += "" + i;
            if (i == 1000) {
                s = " has finished the race!";
                System.out.println(getName() + s);
                isFinished = true;
            }
        }
    }
}
