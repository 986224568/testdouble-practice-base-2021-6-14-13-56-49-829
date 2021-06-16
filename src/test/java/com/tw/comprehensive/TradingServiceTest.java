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
        // given

        // when

        // then

    }

}