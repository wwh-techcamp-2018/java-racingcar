package car.view;

import car.domain.CarDTO;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

public class ResultUITest {
    List<CarDTO> multiWinners, singleWinner;

    @Before
    public void setUp() {
        multiWinners = Arrays.asList(
                new CarDTO("pobi", 5),
                new CarDTO("pobi2", 5),
                new CarDTO("pobi3", 5),
                new CarDTO("crong", 4),
                new CarDTO("honux", 3)
        );
        singleWinner = Arrays.asList(
                new CarDTO("pobi", 5),
                new CarDTO("crong", 4),
                new CarDTO("honux", 3)
        );
    }

    @Test
    public void 출력을위한변환검사() {
        assertEquals("----", new ResultUI().convertToPrint(4));
    }

    @Test
    public void convertToPrint() {
        String result = ResultUI.convertToPrint(new CarDTO("pobi", 8));
        assertEquals("pobi : --------", result);
    }

    @Test
    public void printBySingleDTO() {
        List<CarDTO> DTOList = singleWinner;
        ResultUI.printByDTO(DTOList);
    }

    @Test
    public void printByMultiDTOs() {
        List<CarDTO> DTOList = multiWinners;
        ResultUI.printByDTO(DTOList);
    }

    @Test
    public void getWinners() {
        List<CarDTO> DTOList = multiWinners;
        assertEquals(5, ResultUI.getMaxPosition(DTOList));
        List<CarDTO> winners = ResultUI.getWinners(DTOList);
        for (CarDTO carDTO : winners) {
            assertEquals(ResultUI.getMaxPosition(DTOList), carDTO.getPosition());
        }
    }
}