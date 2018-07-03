package car.view;

import car.view.ResultUI;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ResultUITest {
    @Test
    public void 출력을위한변환검사(){
        assertEquals("----", new ResultUI().convertToPrint(4));
    }

}
