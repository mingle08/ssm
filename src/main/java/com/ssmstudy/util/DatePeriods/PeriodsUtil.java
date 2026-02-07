package com.ssmstudy.util.DatePeriods;

import com.ssmstudy.util.Coupon.BusinessService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Utility class for generating date periods based on different business rules.
 */
public class PeriodsUtil {

    private static final String OPTION_MONTH_DAY_ALLOW_CROSS = "1";
    private static final String OPTION_PREVIOUS_END_DAY = "2";
    private static final String OPTION_END_OF_MONTH = "3";
    private static final String OPTION_MONTH_DAY_NO_CROSS = "4";

    private final BusinessService businessService;

    public PeriodsUtil(BusinessService businessService) {
        this.businessService = Objects.requireNonNull(businessService, "BusinessService cannot be null");
    }

    /**
     * Generates a list of date periods based on the specified option.
     *
     * Options:
     * 1 - Use input date's day of month, allow cross-month
     * 2 - Use previous end date's day of month
     * 3 - Use end of month
     * 4 - Use input date's day of month, do not allow cross-month
     *
     * @param inputDate Starting date for period calculation
     * @param count Number of periods to generate
     * @param option Calculation option (1-4)
     * @return List of DatePeriod objects
     * @throws IllegalArgumentException if parameters are invalid
     */
    public List<DatePeriod> generateDatePeriods(LocalDate inputDate, int count, String option) {
        Objects.requireNonNull(inputDate, "Input date cannot be null");
        if (count <= 0) {
            throw new IllegalArgumentException("Count must be positive: " + count);
        }
        Objects.requireNonNull(option, "Option cannot be null");

        List<DatePeriod> periods = new ArrayList<>(count);
        LocalDate currentStart = inputDate;
        LocalDate currentCalc = inputDate;
        int inputDayOfMonth = inputDate.getDayOfMonth();
        List<LocalDate> holidays = businessService.getHolidayList();

        for (int i = 0; i < count; i++) {
            LocalDate calculatedEnd = calculateEndDate(currentCalc, currentStart, inputDayOfMonth, option);
            LocalDate businessDate = getBusinessDate(calculatedEnd, option, holidays);
            LocalDate finalEnd = businessDate != null ? businessDate : calculatedEnd;

            DatePeriod period = new DatePeriod(currentStart, finalEnd);
            periods.add(period);

            currentStart = finalEnd;
            currentCalc = finalEnd; // Update calc date for next iteration
        }

        return periods;
    }

    private LocalDate calculateEndDate(LocalDate calcDate, LocalDate startDate, int inputDayOfMonth, String option) {
        LocalDate endDate = startDate; // Default to startDate

        switch (option) {
            case OPTION_MONTH_DAY_ALLOW_CROSS:
            case OPTION_MONTH_DAY_NO_CROSS:
                endDate = calcDate.plusMonths(1);
                if (endDate.getDayOfMonth() < inputDayOfMonth && endDate.lengthOfMonth() > inputDayOfMonth) {
                    endDate = endDate.withDayOfMonth(inputDayOfMonth);
                }
                break;
            case OPTION_PREVIOUS_END_DAY:
                endDate = startDate.plusMonths(1);
                break;
            case OPTION_END_OF_MONTH:
                endDate = startDate.plusMonths(1);
                endDate = endDate.withDayOfMonth(endDate.lengthOfMonth());
                break;
            default:
                // For unknown options, use option 4 logic as fallback
                endDate = calcDate.plusMonths(1);
                if (endDate.getDayOfMonth() < inputDayOfMonth && endDate.lengthOfMonth() > inputDayOfMonth) {
                    endDate = endDate.withDayOfMonth(inputDayOfMonth);
                }
                break;
        }

        // Special handling for option 1 - check if last day is less than 30th
        if (OPTION_MONTH_DAY_ALLOW_CROSS.equals(option)) {
            if (endDate.lengthOfMonth() < inputDayOfMonth) {
                endDate = endDate.plusDays(1); // Use the last day of the month
            }
        }

        return endDate;
    }

    private LocalDate getBusinessDate(LocalDate endDate, String option, List<LocalDate> holidays) {
        // Extract the numeric option value for business service
        int optionNumber = getOptionNumber(option);
        return businessService.getNextForwardBusinessDate(endDate, optionNumber, holidays);
    }

    private int getOptionNumber(String option) {
        switch (option) {
            case OPTION_MONTH_DAY_ALLOW_CROSS: return 1;
            case OPTION_PREVIOUS_END_DAY: return 2;
            case OPTION_END_OF_MONTH: return 3;
            case OPTION_MONTH_DAY_NO_CROSS: return 4;
            default: return 4; // Default to option 4
        }
    }
}
