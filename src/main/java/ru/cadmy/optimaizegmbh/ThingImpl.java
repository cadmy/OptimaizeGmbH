package ru.cadmy.optimaizegmbh;

import ru.cadmy.optimaizegmbh.exception.UnsupportedTypeException;
import ru.cadmy.optimaizegmbh.exception.ValidationException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Cadmy on 17.03.2020.
 */
public class ThingImpl implements Thing {

    private TreeMap<BigDecimal, Integer> numbers = new TreeMap<>();

    public ThingImpl(List<? extends Number> numbers) throws ValidationException, UnsupportedTypeException {
        if (numbers != null && !numbers.isEmpty()) {
            List<BigDecimal> bigDecimals = new ArrayList<>();
            for (Number item : numbers) {
                if (item != null) {
                    if (item instanceof Integer) {
                        bigDecimals.add(BigDecimal.valueOf((Integer) item));
                    } else if (item instanceof Long) {
                        bigDecimals.add(BigDecimal.valueOf((Long) item));
                    } else if (item instanceof Double) {
                        bigDecimals.add(BigDecimal.valueOf((Double) item));
                    } else if (item instanceof BigDecimal) {
                        bigDecimals.add((BigDecimal) item);
                    } else {
                        throw new UnsupportedTypeException("This type of number is not supported");
                    }
                }
            }
            addToMap(bigDecimals);
        }  else {
            throw new ValidationException("The input is null or empty");
        }
    }

    private void addToMap(List<BigDecimal> numbers) throws ValidationException{
        if (numbers.size() > 0) {
            for (BigDecimal number : numbers) {
                if (this.numbers.containsKey(number)) {
                    this.numbers.put(number, this.numbers.get(number) + 1);
                } else {
                    this.numbers.put(number, 1);
                }
            }
        } else {
            throw new ValidationException("The input is null or empty");
        }
    }

    public BigDecimal getSmallest() {
        return numbers.firstKey();
    }

    public BigDecimal getGreatest() {
        return numbers.lastKey();
    }

    public BigDecimal getAverage() {
        BigDecimal sum = BigDecimal.ZERO;
        int size = 0;
        for (Map.Entry<BigDecimal, Integer> number : numbers.entrySet()) {
            sum = sum.add(number.getKey().multiply(BigDecimal.valueOf(number.getValue())));
            size = size + number.getValue();
        }
        return sum.divide(BigDecimal.valueOf(size));
    }

}
