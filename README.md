# Percolation
IntelliJ IDEA IDE and JDK 13 is used in the build.
--

This is a project created as an assignment for the Princeton University course, Algorithms 1. 

The Percolation Class is the software modelling of the scientific concept of Percolation, as an implementation of the path compressed Union-Find algorithm. It creates an n by n blocked grid, and can then open up sites, check if a site is open, check if a site is full(connected to the top) and also check if the system ultimately Percolates.

The Percolation Statistics Class calculates the Percolation Threshold(59% approx), which is the mean value of number of randomly opened sites, out of the total number of sites, at which the system Percolates(gets connected through open sites in any path from top edge to bottom edge). It also calculates the Standard Deviation and 95% Percolation confidence interval.

Possible applications
--
In the fields of Chemistry, Physics and Material Sciences, a Percolation model can be created to find if a certain material is porous, conductive etc. 

It can also be used to predict flow paths and in Social Media Analysis to see if different groups of people on other edges of the Social spectrum will eventually connect, through mutual contacts.

---

Note: The Interactive Percolation Visualizer, the Java libraries used are provided as materials by the course, courtesy of Princeton, and not my own creation. 

The code behind the Percolation class and the Percolation statistics calculating class and methods, is my own.
