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

    @Test
    void should_return_same_value_both_findTrade_and_findById_when_call_findTrade_and_findById() {
        MockitoAnnotations.initMocks(this);
        // given
        TradeRepository tradeRepository1 = new TradeRepository();
        TradingService tradingService = new TradingService(tradeRepository1, auditService);
        Long id = 1L;
        // when
        Trade tradeFromService = tradingService.findTrade(id);
        Trade tradeFromRepository = tradeRepository1.findById(id);
        // then
        assertEquals(tradeFromRepository.getDescription(), tradeFromService.getDescription());
        assertEquals(tradeFromRepository.getReference(), tradeFromService.getReference());
    }

}