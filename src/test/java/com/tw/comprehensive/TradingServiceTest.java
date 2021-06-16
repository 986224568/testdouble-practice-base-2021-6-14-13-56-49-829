package com.tw.comprehensive;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class TradingServiceTest {
    @Mock
    TradeRepository tradeRepository;

    @Mock
    AuditService auditService;

    // task 1
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

    // task 2
    @Test
    void should_return_same_value_both_findTrade_and_findById_when_call_findTrade_and_findById() {
        MockitoAnnotations.initMocks(this);
        // given
        TradingService tradingService = new TradingService(tradeRepository, auditService);
        Trade trade = new Trade("", "");
        Long id = 1L;
        when(tradeRepository.findById(id)).thenReturn(trade);
        // when
        Trade tradeFromService = tradingService.findTrade(id);
        Trade tradeFromRepository = tradeRepository.findById(id);
        // then
        assertEquals(tradeFromRepository.getDescription(), tradeFromService.getDescription());
        assertEquals(tradeFromRepository.getReference(), tradeFromService.getReference());
    }

    // task 3
    @Test
    void should_return_same_trade_id_from_repository_and_service_when_create_trade() {
        MockitoAnnotations.initMocks(this);
        // given
        TradingService tradingService = new TradingService(tradeRepository, auditService);
        Trade trade = new Trade("", "");
        // when
        Long idFromService = tradingService.createTrade(trade);
        Long idFromRepository = tradeRepository.createTrade(trade);
        // then
        assertEquals(idFromService, idFromRepository);
    }

    @Test
    void should_call_createTrade_in_repository_createTrade_in_service() {
        MockitoAnnotations.initMocks(this);
        // given

        // when

        // then
    }

}