package com.quadratic.test.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class QuadraticEquationSolverTest {

    private QuadraticEquationSolver quadraticEquationSolver = new QuadraticEquationSolver();

    @Test
    public void testSolveQuadraticEquation() {
        // test case with real roots
        List<String> roots = quadraticEquationSolver.solve(1.0, 2.0, -3.0);
        Assertions.assertEquals(2, roots.size());
        Assertions.assertTrue(roots.contains("-3.0"));
        Assertions.assertTrue(roots.contains("1.0"));

        // test case with one real root
        roots = quadraticEquationSolver.solve(1.0, -4.0, 4.0);
        Assertions.assertEquals(1, roots.size());
        Assertions.assertTrue(roots.contains("2.0"));

        // test case with no real roots
        roots = quadraticEquationSolver.solve(1.0, 2.0, 3.0);
        Assertions.assertTrue(roots.isEmpty());
    }

    @Test
    public void testSolveQuadraticEquationWithZeroCoefficients() {
        // test case with a=0, b=0, c=0
        List<String> roots = quadraticEquationSolver.solve(0.0, 0.0, 0.0);
        roots.forEach(System.out::println);
        Assertions.assertTrue(roots.isEmpty());




    }

}

