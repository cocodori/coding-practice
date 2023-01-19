package com.demo.application.port.in;

public interface SendMoneyUseCase {
    boolean sendMoney(SendMoneyCommand command);
}
