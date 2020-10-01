package play.method;

import java.util.Collection;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;

public class Period {
    private final Date start;
    private final Date end;

    /**
     * コレクションの中の最大値を返す。
     * @param c コレクション
     * @param <E> Comparableを実装した要素
     * @return コレクションの中の最大値
     * @throws IllegalArgumentException 引数のコレクションが空の場合
     * @throws NullPointerException 引数のコレクションにnullが含まれる場合
     */
    public static <E extends Comparable<E>> Optional<E> max (Collection<E> c) {
        if (c.isEmpty()) {
            return Optional.empty();
        }
        E result = null;

        for (E e :
            c) {
            if (result == null || e.compareTo(result) > 0) {
                result = Objects.requireNonNull(e);
            }
            }
        return Optional.of(result);
    }

    /**
     * コンストラクタ
     *
     * @param start 期間の始まり
     * @param end   期間の終わりで期間の始まりより後でなければいけない
     * @throws IllegalArgumentException startがendより後の場合
     * @throws NullPointerException     startかendがnullの場合
     */
    public Period(Date start, Date end) {
        this.start = new Date(start.getTime());
        this.end = new Date((end.getTime()));

        if (this.start.compareTo(this.end) > 0) {
            throw new IllegalArgumentException(
                this.start + " after " + this.end);
        }
    }



    public Date start() {
        return new Date(start.getTime());
    }

    public Date end() {
        return new Date(end.getTime());
    }
}
