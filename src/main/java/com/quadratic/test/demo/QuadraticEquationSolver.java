package com.quadratic.test.demo;


import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@Component
@RestController
public class QuadraticEquationSolver {

    /**
     * Solves a quadratic equation of the form ax^2 + bx + c = 0 and returns the roots as a list of strings.
     * If the equation has no real roots, the list will be empty.
     */
    public List<String> solve(double a, double b, double c) {
        double discriminant = b * b - 4 * a * c;
        if (discriminant < 0) {
            return Arrays.asList();
        } else if (discriminant == 0) {
            Double root = -b / (2 * a);
            if(root.isNaN())
                return Arrays.asList();
            else
                return Arrays.asList(Double.toString(root));
        } else {
            Double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            Double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);

            return Arrays.asList(Double.toString(root1), Double.toString(root2));
        }
    }

    /**
     * REST endpoint that accepts a JSON-encoded request body of the form:
     * {
     *   "a": 1.0,
     *   "b": 2.0,
     *   "c": -3.0
     * }
     *
     * and returns a JSON-encoded response body of the form:
     * {
     *   "roots": [
     *     "1.0",
     *     "-3.0"
     *   ]
     * }
     */
    @PostMapping("/quadratic-equation")
    public QuadraticEquationResponse solveQuadraticEquation(@RequestBody QuadraticEquationRequest request) {
        List<String> roots = solve(request.a, request.b, request.c);
        return new QuadraticEquationResponse(roots);
    }

    /**
     * Request object that maps to the JSON-encoded request body in the REST endpoint.
     */
    private static class QuadraticEquationRequest {
        public double a;
        public double b;
        public double c;
    }

    /**
     * Response object that maps to the JSON-encoded response body in the REST endpoint.
     */
    private static class QuadraticEquationResponse {
        public List<String> roots;

        public QuadraticEquationResponse(List<String> roots) {
            this.roots = roots;
        }
    }
}
