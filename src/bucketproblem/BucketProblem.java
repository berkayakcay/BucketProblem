package bucketproblem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.Timer;

/**
 *
 * @author berkay
 */
public class BucketProblem {

    public static ArrayList<String> sequence = new ArrayList<>();

    public static void main(String[] args) {

        int target;
        int bucket1;
        int bucket2;
        String welcome = "Problem Solver. \nPlease input your liters ";
        boolean result = false;

        System.out.println(welcome);
        Scanner in = new Scanner(System.in);
        System.out.println("Please input the target liter : ");
        target = in.nextInt();
        System.out.println("Plase input the first bucket (smaller) : ");
        bucket1 = in.nextInt();
        System.out.println("Please input the second bucket (larger) : ");
        bucket2 = in.nextInt();

        String impossible = "Your target can't be reached. Either change your target or your bucket sizes!";
        String errCapacity = "One of your buckets has to have enough room for how much water you want!";
        String success = "You have " + target + "L of water!";

        System.out.println("You want " + target + "L of water from a " + bucket1 + "L bucket and a " + bucket2 + "L bucket?");

        if (target > bucket1 && target > bucket2) { // target is larget than buckets

            result = false;
            System.out.println(errCapacity);

        } else {

            if (target % gcd(bucket1, bucket2) != 0) {

                result = false;
                System.out.println(impossible);

            } else {

                // Create bucket object
                bucket lgBucket = new bucket();
                bucket smBucket = new bucket();

                if (bucket1 > bucket2) // bucket 1 is larger
                {
                    lgBucket.setName("first bucket");
                    lgBucket.setSize(bucket1);
                    lgBucket.setVol(0);

                    smBucket.setName("second bucket");
                    smBucket.setSize(bucket2);
                    smBucket.setVol(0);
                } else { // bucket 2 is larger
                    lgBucket.setName("second bucket");
                    lgBucket.setSize(bucket2);
                    lgBucket.setVol(0);

                    smBucket.setName("first bucket");
                    smBucket.setSize(bucket1);
                    smBucket.setVol(0);
                }

                lgBucket.dump();
                smBucket.dump();

                while (lgBucket.getVol() != lgBucket.getSize()) {
                    smBucket.fill();
                    sequence.add(lgBucket.getVol() + ":" + smBucket.getVol());
                    System.out.println(lgBucket.getVol() + ":" + smBucket.getVol());
                    if (lgBucket.getVol() == target || smBucket.getVol() == target) {
                        break;
                    }
                    smBucket.pour(lgBucket);
                    sequence.add(lgBucket.getVol() + ":" + smBucket.getVol());
                    System.out.println(lgBucket.getVol() + ":" + smBucket.getVol());
                    if (lgBucket.getVol() == target || smBucket.getVol() == target) {
                        break;
                    }
                    if (lgBucket.getVol() == lgBucket.getSize()) {
                        lgBucket.dump();
                        sequence.add(lgBucket.getVol() + ":" + smBucket.getVol());
                        System.out.println(lgBucket.getVol() + ":" + smBucket.getVol());
                        smBucket.pour(lgBucket);
                        sequence.add(lgBucket.getVol() + ":" + smBucket.getVol());
                        System.out.println(lgBucket.getVol() + ":" + smBucket.getVol());
                    }
                }
                if (smBucket.getVol() == target) {
                    lgBucket.setVol(smBucket.getVol());
                    smBucket.dump();

                    sequence.add(lgBucket.getVol() + ":" + smBucket.getVol());
                    System.out.println(lgBucket.getVol() + ":" + smBucket.getVol());

                    System.out.println("######  TEST  ########");
                    for (int i = 0; i < sequence.size(); i++) {
                        System.out.print(i + ". Steps of sequence is " + sequence.get(i));
                        System.out.println();
                    }

                }

            }

        }
        

    }

    public static int gcd(int a, int b) {
        if (a < 0) {
            a = -a;
        }
        if (b < 0) {
            b = -b;
        }
        if (b > a) {
            int temp = a;
            a = b;
            b = temp;
        }
        while (true) {
            if (b == 0) {
                return a;
            }
            a %= b;
            if (a == 0) {
                return b;
            }
            b %= a;
        }
    }
}
