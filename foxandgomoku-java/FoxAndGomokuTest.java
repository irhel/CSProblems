import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FoxAndGomokuTest {

    protected FoxAndGomoku solution;

    @Before
    public void setUp() {
        solution = new FoxAndGomoku();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] board = new String[]{"....o.", "...o..", "..o...", ".o....", "o.....", "......"};

        String expected = "found";
        String actual = solution.win(board);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] board = new String[]{"oooo.", ".oooo", "oooo.", ".oooo", "....."};

        String expected = "not found";
        String actual = solution.win(board);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] board = new String[]{"oooo.", ".oooo", "oooo.", ".oooo", "....o"};

        String expected = "found";
        String actual = solution.win(board);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] board = new String[]{"o.....", ".o....", "..o...", "...o..", "....o.", "......"};

        String expected = "found";
        String actual = solution.win(board);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String[] board = new String[]{"o....", "o.o..", "o.o.o", "o.o..", "o...."};

        String expected = "found";
        String actual = solution.win(board);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase5() {
        String[] board = new String[]{"..........", "..........", "..oooooo..", "..o.......", "..o.......", "..oooooo..", ".......o..", ".......o..", "..oooooo..", ".........."};

        String expected = "found";
        String actual = solution.win(board);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase6() {
        String[] board = new String[]{"..........", "..........", "..oooo.o..", "..o.......", "..o.......", "..o.oooo..", ".......o..", ".......o..", "..oooo.o..", ".........."};

        String expected = "not found";
        String actual = solution.win(board);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase7() {
        String[] board = new String[]{"ooooo", "ooooo", "ooooo", "ooooo", "ooooo"};

        String expected = "found";
        String actual = solution.win(board);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase8() {
        String[] board = new String[]{".....", ".....", ".....", ".....", "....."};

        String expected = "not found";
        String actual = solution.win(board);

        Assert.assertEquals(expected, actual);
    }

}
