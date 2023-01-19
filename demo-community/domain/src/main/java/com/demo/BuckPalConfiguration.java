package com.demo;

import com.demo.application.service.MoneyTransferProperties;
import com.demo.domain.Money;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(BuckPalConfigurationProperties.class)
public class BuckPalConfiguration {

    @Bean
    public MoneyTransferProperties moneyTransferProperties(BuckPalConfigurationProperties buckPalConfigurationProperties) {
        Money money = Money.of(buckPalConfigurationProperties.getTransferThreshold());
        return new MoneyTransferProperties(money);
    }
}
