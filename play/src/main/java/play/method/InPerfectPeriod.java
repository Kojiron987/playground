package play.method;

import java.util.Date;

public final class InPerfectPeriod {
    private final Date start;
    private final Date end;

    /**
     * コンストラクタ
     * @param start 期間の開始
     * @param end 期間の終わりで、開始より後であってはならない
     * @throws IllegalArgumentException startがendの後の場合
     * @throws NullPointerException startがendかnullの場合
     */
    public InPerfectPeriod(Date start, Date end) {
        if (start.compareTo(end) > 0) {
            throw new IllegalArgumentException(start + " after " + end);
        }
        // Dateはimmutableなので、外から変更がされてしまう。
        this.start = start;
        this.end = end;
    }

    public Date start() {
        return start;
    }

    public Date end() {
        return end;
    }
}
