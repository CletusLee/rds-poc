package home.cletus.rds.entity;

import io.github.benas.randombeans.EnhancedRandomBuilder;
import io.github.benas.randombeans.api.EnhancedRandom;
import io.github.benas.randombeans.randomizers.range.LongRangeRandomizer;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import static io.github.benas.randombeans.api.EnhancedRandom.random;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class CustomerTest {

    @Test
    public void testRandomGenerator() {
        Customer customer = random(Customer.class);

        assertThat(customer.getMoney()).isNotNull();
    }

    @Test
    public void testRandomGeneratorWithMoneyLessThan10() {
        EnhancedRandom customizedRandom = EnhancedRandomBuilder.aNewEnhancedRandomBuilder().randomize(Long.class, new LongRangeRandomizer(0L, 10L)).build();
        Customer customer = customizedRandom.nextObject(Customer.class);

        assertThat(customer.getMoney()).isBetween(0L, 10L);
    }
}