package ru.cadmy.optimaizegmbh;

import java.math.BigDecimal;

/**
 * Created by Cadmy on 17.03.2020.
 */
public interface Thing {
    BigDecimal getSmallest();
    BigDecimal getGreatest();
    BigDecimal getAverage();
}
