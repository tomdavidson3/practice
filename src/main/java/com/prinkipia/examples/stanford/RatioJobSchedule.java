package com.prinkipia.examples.stanford;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class RatioJobSchedule {
    static class Job {
        int weight;
        int length;
        float ratio;

        public Job(final int weight, final int length) {
            this.weight = weight;
            this.length = length;
            this.ratio = weight / (float) length;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream(args[0]));
        int numJobs = scanner.nextInt();
        Job[] jobs = new Job[numJobs];
        for (int i = 0; i < numJobs; i++) {
            int weight = scanner.nextInt();
            int length = scanner.nextInt();
            jobs[i] = new Job(weight, length);
        }
        Arrays.sort(jobs, (o1, o2) -> Float.compare(o2.ratio, o1.ratio));
        long sum = 0;
        for (int i = 0; i < numJobs; i++) {
            int completionTime = 0;
            for (int j = 0; j < i; j++) {
                completionTime += jobs[j].length;
            }
            sum += completionTime;
        }
        System.out.println(sum);
    }
}
