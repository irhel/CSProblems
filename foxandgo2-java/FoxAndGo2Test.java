import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FoxAndGo2Test {

    protected FoxAndGo2 solution;

    @Before
    public void setUp() {
        solution = new FoxAndGo2();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] board = new String[]{"...", ".o.", "..."};

        int expected = 1;
        int actual = solution.maxKill(board);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] board = new String[]{"o.", "oo"};

        int expected = 3;
        int actual = solution.maxKill(board);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] board = new String[]{".o.o.", "o.o.o", ".o.o.", "o.o.o", ".o.o."};

        int expected = 0;
        int actual = solution.maxKill(board);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] board = new String[]{".o.o.", "o.o.o", ".o.o.", "o.o.o", "....."};

        int expected = 10;
        int actual = solution.maxKill(board);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String[] board = new String[]{".o.o.o.o.o.", "o.ooo.ooo.o", ".o.......o.", "oo.......oo", ".o...o...o.", "o...o.o...o", ".o...o...o.", "oo.......oo", ".o.......o.", "o.ooo.ooo.o", ".o.o.o.o.o."};

        int expected = 4;
        int actual = solution.maxKill(board);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase5() {
        String[] board = new String[]{"...ooo.....", "...o.o.....", ".ooo.ooo...", ".o.....o...", ".ooo.ooo...", "...o.o.....", "...ooo.....", "....o......", "....o...ooo", "....ooooo.o", "........ooo"};

        int expected = 38;
        int actual = solution.maxKill(board);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase6() {
        String[] board = new String[]{"ooooooooooo", "o.........o", "o...ooo...o", "o...o.o...o", "o...ooo...o", "o....o....o", "o....oooooo", "o..........", "o.......ooo", "o.......o.o", "ooooooooooo"};

        int expected = 0;
        int actual = solution.maxKill(board);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase7() {
        String[] board = new String[]{"oo.o.ooo.o..o..", "...ooo.o..oo.oo", "o..o.o.ooo.o..o", "oo.......oo.ooo", "..oo.o.o.o.ooo.", "..oo..oo..o.ooo", "oo.o.oo..o.oooo", ".oo.o..ooo.o.oo", "o..o.o.o.o.oo..", ".oo.oo...o....o", "o.o.oo....oo..o", ".o.o..o.oo..ooo", "o.o.o..o..o....", "ooo.oooooooo..o", "o..oo.o..o.ooo."};

        int expected = 60;
        int actual = solution.maxKill(board);

        Assert.assertEquals(expected, actual);
    }

}
