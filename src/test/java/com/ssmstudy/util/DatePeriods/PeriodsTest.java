package com.ssmstudy.util.DatePeriods;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.ssmstudy.util.Coupon.BusinessService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PeriodsTest {

    @Mock
    private BusinessService bService;

    @InjectMocks
    private PeriodsUtil periodsUtil;

    @Test
    public void test() {

        when(bService.getNextForwardBusinessDate(any(LocalDate.class), anyInt(), any(List.class))).thenReturn(LocalDate.of(2024, 2, 29))
                .thenReturn(LocalDate.of(2024, 4, 30))
                .thenReturn(LocalDate.of(2024, 5, 30));

        List<DatePeriod> list = periodsUtil.generateDatePeriods(LocalDate.of(2024, 1, 30), 3, "1");

        verify(bService, times(3)).getNextForwardBusinessDate(any(LocalDate.class), anyInt(), any(List.class));
    }

}
