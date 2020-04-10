/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean[][] grid;
    private final int rc;
    private int count;
    private final WeightedQuickUnionUF uni;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0)
            this.isValidRc(n, n);
        grid = new boolean[n][n];
        count = 0;
        rc = n;
        uni = new WeightedQuickUnionUF(n * n + 2);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                grid[i][j] = false;
        }

        for (int i = 0; i < n; i++) {
            uni.union(n * n, map(0, i));
        }
        for (int i = 0; i < n; i++) {
            uni.union(n * n + 1, map(n-1, i));
        }
    }

    private int map(int r, int c) {
        return (r*rc + c);
    }

    // checks if valid indices
    private void isValidRc(int row, int col) {
        if (row <= 0 || col <= 0)
            throw new IllegalArgumentException();
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        this.isValidRc(row, col);
        int r = row - 1, c = col - 1;
        grid[r][c] = true;
        count++;
        if ((row - 1) >= 1) {
            if (isOpen((row - 1), col)) {
                uni.union(map(r - 1, c), map(r, c));
            }
        }
        if ((row + 1) <= rc) {
            if (isOpen((row + 1), col)) {
                uni.union(map(r + 1, c), map(r, c));
            }
        }
        if ((col - 1) >= 1) {
            if (isOpen(row, (col - 1))) {
                uni.union(map(r, c - 1), map(r, c));
            }
        }
        if ((col + 1) <= rc) {
            if (isOpen(row, (col + 1))) {
                uni.union(map(r, c + 1), map(r, c));
            }
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        this.isValidRc(row, col);
        return (grid[row - 1][col - 1]);
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        this.isValidRc(row, col);
        if (isOpen(row, col))
            return (uni.connected(map(row - 1, col - 1), rc*rc));
        return false;
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return count;
    }

    // does the system percolate?
    public boolean percolates() {
        return (uni.connected(rc*rc, rc*rc + 1));
    }

    // test client (optional)

}