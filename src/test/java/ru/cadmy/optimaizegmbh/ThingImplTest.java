package ru.cadmy.optimaizegmbh;

import org.junit.Assert;
import org.junit.Test;
import ru.cadmy.optimaizegmbh.exception.UnsupportedTypeException;
import ru.cadmy.optimaizegmbh.exception.ValidationException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cadmy on 17.03.2020.
 */
public class ThingImplTest {

    @Test
    public void shouldReturnSmallest() throws ValidationException, UnsupportedTypeException {
        Thing thing = new ThingImpl(List.of(-100, 2, 3));
        Assert.assertEquals("The calculation of smallest is incorrect.", BigDecimal.valueOf(-100), thing.getSmallest());
    }

    @Test
    public void shouldReturnGreatest() throws ValidationException, UnsupportedTypeException {
        Thing thing = new ThingImpl(List.of(-100, 2, 3));
        Assert.assertEquals("The calculation of greatest is incorrect.", BigDecimal.valueOf(3), thing.getGreatest());
    }

    @Test
    public void shouldReturnSmallestDouble() throws ValidationException, UnsupportedTypeException {
        Thing thing = new ThingImpl(List.of(3.7, 42, 17.5));
        Assert.assertEquals("The calculation of smallest is incorrect.", BigDecimal.valueOf(3.7), thing.getSmallest());
    }

    @Test
    public void shouldReturnGreatestDouble() throws ValidationException, UnsupportedTypeException {
        Thing thing = new ThingImpl(List.of(100.6, 2.3, 3.3));
        Assert.assertEquals("The calculation of greatest is incorrect.", BigDecimal.valueOf(100.6), thing.getGreatest());
    }

    @Test(expected = ValidationException.class)
    public void shouldFailSmallestIfListIsNull() throws ValidationException, UnsupportedTypeException {
        List<Integer> numbers = null;
        Thing thing = new ThingImpl(numbers);
        thing.getSmallest();
    }

    @Test
    public void shouldReturnGreatestWithNull() throws ValidationException, UnsupportedTypeException {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3));
        numbers.add(null);
        Thing thing = new ThingImpl(numbers);
        Assert.assertEquals("Null values should be filtered.", BigDecimal.valueOf(3), thing.getGreatest());
    }

    @Test
    public void shouldReturnAverage() throws ValidationException, UnsupportedTypeException {
        Thing thing = new ThingImpl(List.of(1, 2, 3));
        Assert.assertEquals("The calculation of average is incorrect.", BigDecimal.valueOf(2), thing.getAverage());
    }

    @Test(expected = ValidationException.class)
    public void shouldFailAverageWithNull() throws ValidationException, UnsupportedTypeException {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(null);
        Thing thing = new ThingImpl(numbers);
        thing.getAverage();
    }

    @Test(expected = ValidationException.class)
    public void shouldFailAverageIfListIsNull() throws ValidationException, UnsupportedTypeException {
        List<Integer> numbers = null;
        Thing thing = new ThingImpl(numbers);
        thing.getAverage();
    }

    @Test(expected = UnsupportedTypeException.class)
    public void shouldFailIfTypeIsNotSupported() throws ValidationException, UnsupportedTypeException {
        Thing thing = new ThingImpl(List.of(3.6f, 2.1f, 4.2f));
        thing.getAverage();
    }

    @Test
    public void shouldReturnAverageForDoubles() throws ValidationException, UnsupportedTypeException {
        Thing thing = new ThingImpl(List.of(3.6, 2.1, 4.2));
        Assert.assertEquals("The calculation of average for doubles is incorrect.", BigDecimal.valueOf(3.3), thing.getAverage());
    }

    @Test
    public void shouldReturnAverageWithNull() throws ValidationException, UnsupportedTypeException {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3));
        numbers.add(null);
        Thing thing = new ThingImpl(numbers);
        Assert.assertEquals("Null values should be filtered.", BigDecimal.valueOf(2), thing.getAverage());
    }

    @Test
    public void shouldReturnAverageWithRepeatedValues() throws ValidationException, UnsupportedTypeException {
        Thing thing = new ThingImpl(List.of(1, 2, 2, 3));
        Assert.assertEquals("The calculation of average with repeated values is incorrect.", BigDecimal.valueOf(2), thing.getAverage());
    }

    @Test
    public void shouldReturnNotIntegerAverage() throws ValidationException, UnsupportedTypeException {
        Thing thing = new ThingImpl(List.of(1, 2, 3, 5));
        Assert.assertEquals("The calculation of not integer average is incorrect.", BigDecimal.valueOf(2.75), thing.getAverage());
    }

    @Test
    public void shouldReturnAverageForNegative() throws ValidationException, UnsupportedTypeException {
        Thing thing = new ThingImpl(List.of(-2, 2, 3, 5));
        Assert.assertEquals("The calculation of not integer average is incorrect.", BigDecimal.valueOf(2), thing.getAverage());
    }
}