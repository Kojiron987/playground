package play.anoenum;

public enum PayrollDay {
    MONDAY(PayType.WEEKDAY), TUESDAY(PayType.WEEKDAY), WEDNESDAY(PayType.WEEKDAY), THURSDAY(PayType.WEEKDAY),
    FRIDAY(PayType.WEEKDAY), SATURDAY(PayType.WEEKEND), SUNDAY(PayType.WEEKEND);

    private final PayType payType;

    private PayrollDay(PayType payType) {
        this.payType = payType;
    }

    int pay(int minutesWorkded, int payRate) {
        return payType.pay(minutesWorkded, payRate);
    }

    private enum PayType {
        WEEKDAY {
            int overtimePay(int minutesWorkded, int payRate) {
                return minutesWorkded <= MINS_PER_SHIFT ? 0 : (minutesWorkded - MINS_PER_SHIFT) * payRate / 2;
            }
        },
        WEEKEND {
            int overtimePay(int minutesWorkded, int payRate) {
                return minutesWorkded * payRate / 2;
            }
        };

        abstract int overtimePay(int mins, int payRate);

        private static final int MINS_PER_SHIFT = 8 * 60;

        int pay(int minsWorked, int payRate) {
            int basePay = minsWorked * payRate;
            return basePay + overtimePay(minsWorked, payRate);
        }
    }
}
