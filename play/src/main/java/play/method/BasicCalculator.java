package play.method;

import java.math.BigInteger;

public class BasicCalculator {

    /**
     * 値が(this mod m)であるBigIntegerを返します。このメソッドは、
     * reminderメソッドとは異なり、常に負でないBigIntegerを返します。
     * @param m 正でなければならないモジュラス
     * @return thisに対するmod m
     * @throws ArithmeticException m <= 0の場合
     */
    public BigInteger mod(BigInteger m) {
        if (m.signum() <= 0) {
            throw new ArithmeticException("Modulus <= 0: " + m);
        }

        // do calculationMethod
        return null;
    }

    private static void sort(long a[], int offset, int length) {
        assert a != null;
        assert offset >= 0 && offset <= a.length;
        assert length >= 0 && length <= a.length - offset;
        // 計算を行う
    }
}
