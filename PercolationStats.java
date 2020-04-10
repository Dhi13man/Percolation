/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */


import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdRandom;


public class PercolationStats {
    private final double[] opennumber;
    private final int number;
    private final double con;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        con = 1.96;
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException();
        }
        opennumber = new double[trials];
        number = trials;
        Percolation per;
        for (int i = 0; i < trials; i++) {
            per = new Percolation(n);
            while (!per.percolates()) {
                int r  = 1 + StdRandom.uniform(n);
                int c  = 1 + StdRandom.uniform(n);
                if (per.isOpen(r, c))
                    continue;
                per.open(r, c);
            }
            opennumber[i] = (double) per.numberOfOpenSites() / (n * n);
        }
    }

    private double squareRoot(int num) {
        double temp;

        double sr = (double) num / 2;

        do {
            temp = sr;
            sr = (temp + (num / temp)) / 2;
        } while ((temp - sr) != 0);

        return sr;
    }

    // sample mean of percolation threshold
    public double mean() {
        return (StdStats.mean(opennumber));
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return (StdStats.stddev(opennumber));
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return (mean() - (con * stddev()) / (squareRoot(number)));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return (mean() + (con * stddev()) / (squareRoot(number)));
    }

    // test client (see below)
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);
        PercolationStats p = new PercolationStats(n, t);
        // PercolationStats p = new PercolationStats(-2, 50);
        System.out.print("mean                    = ");
        System.out.println(p.mean());
        System.out.print("stddev                  = ");
        System.out.println(p.stddev());
        System.out.print("95% confidence interval = [");
        System.out.print(p.confidenceHi());
        System.out.print(", ");
        System.out.print(p.confidenceLo());
        System.out.println("]");
    }

}
