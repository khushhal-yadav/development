package com.stock.component;

import com.stock.domain.StockType;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

/**
 * Created by khush on 06/11/2016.
 */
public class CommonStockDividendYieldCalculatorTest extends AbstractDividendYieldCalculatorTestSupport {

    private CommonStockDividendYieldCalculator commonStockDividendYieldCalculator;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        commonStockDividendYieldCalculator = new CommonStockDividendYieldCalculator(tickerPriceService);
    }

    @Test
    public void testCalculateDividendYield() throws Exception {
        Mockito.when(stock.getLastDividend()).thenReturn(new BigDecimal("0.08"));
        Mockito.when(tickerPriceService.getTickerPrice(stock, localDate)).thenReturn(new BigDecimal("0.02"));
        BigDecimal dividendYield = commonStockDividendYieldCalculator.calculateDividendYield(stock, localDate);
        Assert.assertEquals(new BigDecimal("4.000000"), dividendYield);

    }

    @Test
    public void testCalculateDividendYieldWithZeroDividend() throws Exception {
        Mockito.when(stock.getLastDividend()).thenReturn(new BigDecimal("0.00"));
        Mockito.when(tickerPriceService.getTickerPrice(stock, localDate)).thenReturn(new BigDecimal("0.02"));
        BigDecimal dividendYield = commonStockDividendYieldCalculator.calculateDividendYield(stock, localDate);
        Assert.assertEquals(new BigDecimal("0.000000"), dividendYield);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateDividendYieldWithPriceAbsent() throws Exception {
        Mockito.when(stock.getLastDividend()).thenReturn(new BigDecimal("0.08"));
        Mockito.when(tickerPriceService.getTickerPrice(stock, localDate)).thenReturn(null);
        commonStockDividendYieldCalculator.calculateDividendYield(stock, localDate);
    }

    @Test
    public void testGetStockType() throws Exception {
        Assert.assertEquals(StockType.COMMON, commonStockDividendYieldCalculator.getStockType());
    }
}