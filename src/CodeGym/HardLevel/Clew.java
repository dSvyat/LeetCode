package CodeGym.HardLevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
1. Create 5 different threads of your own (descendants of the Thread class):
1.1. Thread 1 should run infinitely;
1.2 Thread 2 should output "InterruptedException" when an InterruptedException occurs;
1.3 Thread 3 must output "Hurrah" every half second;
1.4 Thread 4 must implement the Message interface, when calling the showWarning method, the thread must stop;
1.5. Thread 5 should read from the console the numbers until the word "N" is entered, and then output to the console the sum of the numbers entered.
2. In a static block, add your threads to List<Thread> threads in the order listed.
3. threads should not start automatically.

Hint:
Thread 4 can be checked with the isAlive() method

Requirements:
- The Solution class static block must create and add 5 threads to the threads list.
- Threads in the threads list must not start automatically.
- Thread 1 in the threads list must run indefinitely.
- Thread 2 of the threads list must print "InterruptedException" if an InterruptedException occurs.
- Thread 3 of the threads list must output "Hurrah" every half-second.
- Thread 4 of the threads list must implement the Message interface, the thread must stop when the showWarning method is called.
- Thread 5 of the threads list must read the numbers from the console until the word "N" is entered, and then output the sum of the entered numbers to the console.
 */
public class Clew {
    public static List<Thread> threads = new ArrayList<>(5);
    static {
        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());
    }

    public static void main(String[] args) {
    }

    public static class Thread1 extends Thread {
        public void run() {
            while (true) {
            }
        }
    }

    public static class Thread2 extends Thread {
        public void run() {
            try {
                throw new InterruptedException();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    public static class Thread3 extends Thread {
        public void run() {
            while (true) {
                System.out.println("Ура");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class Thread4 extends Thread implements Message {
        public void run() {
            while (!isInterrupted()) {
            }
        }

        public void showWarning() {
            this.interrupt();
        }
    }

    public static class Thread5 extends Thread {
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int sum = 0;
            while (true) {
                try {
                    String str = reader.readLine();
                    if (str.equals("N"))
                        break;
                    sum += Integer.parseInt(str);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.print(sum);
        }
    }
}

interface Message {
    void showWarning();
}