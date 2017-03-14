package com.stock.app;

import com.stock.service.DividentYieldCalcutionService;
import com.stock.service.GeometricMeanCalculationService;
import com.stock.service.PECalculationService;
import com.stock.service.TradeService;
import com.stock.common.AbstractSteps;
import com.stock.common.AppStory;
import com.stock.domain.Stock;
import com.stock.persistence.StockDao;
import junit.framework.Assert;
import org.jbehave.core.annotations.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Created by khush on 14/03/2017.
 */
@Component
@Profile("test")
public class ElevatorSteps extends AbstractSteps {

    private final Logger log = LoggerFactory.getLogger(getClass());


}
