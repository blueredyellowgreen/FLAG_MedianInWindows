import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {
    @Test
    public void testMedianSlidingWindow() {
        int[][] inputsArray = {
                {3},
                {4, 6},
                {4, 6},
                {1, 3, -1, -3, 5, 3, 6, 7},
                {1, 3, -1, -3, 5, 3, 6, 7},
                {1, 3, -1, -3, 5, 3, 6, 7},
                {1, 3, -1, -3, 5, 3, 6, 7},
                {1, 3, -1, -3, 5, 3, 6, 7},
        };

        int[] windows = {1, 1, 2, 1, 2, 3, 4, 5, 2};

        double[][] expects = {
                {3},
                {4, 6},
                {5},
                {1, 3, -1, -3, 5, 3, 6, 7},
                {2, 1, -2, 1, 4, 4.5, 6.5},
                {1, -1, -1, 3, 5, 6},
                {0, 1, 1, 4, 5.5},
                {1, 3, 3, 5},
        };

        for (int i = 0; i < inputsArray.length; i++) {
            System.out.printf("case %d\n", i);
            assertArrayEquals(expects[i], Solution.medianSlidingWindow(inputsArray[i], windows[i]), 1e-7);
        }
    }
}
