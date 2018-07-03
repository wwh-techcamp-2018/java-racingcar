package car;

import car.domain.CarDTO;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertEquals;

public class ClientTest {

    @Test
    public void carClient() {
        CarClient client = new CarClient(3);
        client.run(8);
    }

    @Test
    public void namedCarClient() {
        String[] names = new String[]{
                "pobi",
                "crong",
                "honux"
        };
        List<String> nameList = Arrays.asList(names);
        NamedCarClient.runGame(nameList, 5);
    }

    @Test
    public void filterTest() {
        List<CarDTO> carDTOs = Arrays.asList(
                new CarDTO("pobi", 5),
                new CarDTO("pobi", 5),
                new CarDTO("pobi", 5),
                new CarDTO("crong", 4),
                new CarDTO("honux", 3)
        );
        int max = 5;
        List<CarDTO> winners = carDTOs.stream().filter(x -> max == x.getPosition()).collect(Collectors.toList());
        assertEquals(winners.size(), 3);
    }
}
