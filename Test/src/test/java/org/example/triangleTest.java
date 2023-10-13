package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class triangleTest {
    triangle t = new triangle();

    @org.junit.jupiter.api.Test
    void test() throws Exception {
        System.out.println("    This is triangle test ...");
        int r = t.checkTriangle(2,2,3);
        // "正三角形" 0 "等腰直角三角形" 1 "等腰三角形" 2 "直角三角形" 3 "一般三角形" 4
        assertEquals(2,r,() -> "Triangle type wrong ");
    }
}