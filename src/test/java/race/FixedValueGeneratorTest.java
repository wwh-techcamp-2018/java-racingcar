package race;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FixedValueGeneratorTest {
    @Test
    public void generate() {
        FixedValueGenerator generator = new FixedValueGenerator(5);
        assertThat(generator.generate()).isEqualTo(5);
    }
}
