package com.prinkipia.examples.stanford;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class JobSchedule {
    static class Job {
        int weight;
        int length;
        int diff;

        public Job(final int weight, final int length) {
            this.weight = weight;
            this.length = length;
            this.diff = weight - length;
        }
    }

    static class RatioJob {
        int weight;
        int length;
        float ratio;

        public RatioJob(final int weight, final int length) {
            this.weight = weight;
            this.length = length;
            this.ratio = weight/length;
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
        Arrays.sort(jobs, (o1, o2) -> {
            if (o1.diff == o2.diff) {
                return Integer.compare(o2.weight, o1.weight);
            }
            return Integer.compare(o1.diff, o2.diff);
        });
        long sum = 0;
        for (int i=0; i < numJobs; i++) {
            int completionTime = 0;
            for (int j=0; j < i; j++) {
                completionTime += jobs[j].length;
            }
            sum += completionTime;
        }
        System.out.println(sum);
    }
}
