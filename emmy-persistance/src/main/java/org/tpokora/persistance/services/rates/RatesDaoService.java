package org.tpokora.persistance.services.rates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.tpokora.persistance.entity.rates.RateEntity;
import org.tpokora.persistance.repositories.rates.RatesRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class RatesDaoService {

    private final Logger LOGGER = LoggerFactory.getLogger(RatesDaoService.class);

    private final RatesRepository ratesRepository;

    public RatesDaoService(RatesRepository ratesRepository) {
        this.ratesRepository = ratesRepository;
    }

    public RateEntity saveRate(RateEntity rateEntity) {
        Objects.requireNonNull(rateEntity, "RateEntity can't be null!");
        LOGGER.info(">>> Saving Forecast to DB");
        return ratesRepository.save(rateEntity);
    }

    public List<RateEntity> getRatesDaysBeforeToday(String from, String to, int minusDays) {
        Objects.requireNonNull(from, "'from' can't be null!");
        Objects.requireNonNull(to, "'to' can't be null!");
        LOGGER.info(String.format(">>> Get rates %s before today", minusDays));
        return ratesRepository.findAllByFromContainsIgnoreCaseAndToContainsIgnoreCaseAndTimestampBetween(from, to, LocalDateTime.now().minusDays(minusDays), LocalDateTime.now());
    }
}