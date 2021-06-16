package com.tw.comprehensive;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class TradingServiceTest {
    @Mock
    TradeRepository tradeRepository;

    @Mock
    AuditService auditService;

    @Test
    void should_return_logNewTrade_time_when_execute_createTrade() {
        MockitoAnnotations.initMocks(this);
        // given
        TradingService tradingService = new TradingService(tradeRepository, auditService);
        Trade trade = new Trade("", "");
        // when
        tradingService.createTrade(trade);
        // then
        Mockito.verify(auditService, Mockito.times(1)).logNewTrade(trade);
    }

}