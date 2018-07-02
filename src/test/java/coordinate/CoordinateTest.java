package coordinate;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CoordinateTest {

    private Coordinate coor;

    @Before
    public void setUp() throws Exception {
        List list = new ArrayList<>();
        coor = new Coordinate();
    }

    @Test
    public void parse() {
        String s = "(1,10)";
        int[] ans = coor.parse(s);
        assertEquals(1, ans[0]);
        assertEquals(10,ans[1]);
    }
}