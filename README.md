# Percolation

Java implementation of an *n*×*n* percolation grid using path-compressed union-find, written for Princeton Algorithms, Part I. Open sites, test whether a site is full (connected to the top), and test whether the system percolates from top to bottom.

`PercolationStats` estimates the percolation threshold by Monte Carlo (mean fraction of open sites at percolation is about 59% in this model) and reports standard deviation and a 95% confidence interval.

## Install

JDK 13 was used in the original IntelliJ build. Course libraries for the interactive visualizer are credited in `CREDITS` and are not original to this repo.

```sh
git clone https://github.com/Dhi13man/Percolation.git
cd Percolation
javac Percolation.java PercolationStats.java
```

## Use

- `Percolation` models the grid.
- `PercolationStats` runs trials and prints mean, stddev, and confidence bounds.
- `PercolationVisualizer` / `InteractivePercolationVisualizer` use Princeton course libraries.

Possible uses of the same model (porous materials, flow paths, connectivity of a graph) are the standard percolation interpretation; this code is the course assignment, not a materials simulator.

## Contributing

See [CONTRIBUTING.md](CONTRIBUTING.md).

## License

MIT. See [LICENSE](LICENSE).
