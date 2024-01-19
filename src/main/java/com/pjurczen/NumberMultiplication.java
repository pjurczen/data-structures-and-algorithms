package com.pjurczen;

import java.math.BigDecimal;
import java.math.BigInteger;

public class NumberMultiplication {

    public BigInteger multiply(BigInteger x, BigInteger y) {
        if (x.intValue() < 10 && y.intValue() < 10) {
            return x.multiply(y);
        }
        final var n1length = numLength(x);
        final var n2length = numLength(y);

        final var maxLength = Math.max(n1length, n2length);
        final var halfMaxLength = (maxLength / 2) + (maxLength % 2);

        final var maxNumLengthTen = BigInteger.TEN.pow(halfMaxLength);

        final var a = x.divide(maxNumLengthTen);
        final var b = x.mod(maxNumLengthTen);

        final var c = y.divide(maxNumLengthTen);
        final var d = y.mod(maxNumLengthTen);

        final var firstTerm = multiply(a, c);
        final var secondTerm = multiply(b, d);
        final var thirdTerm = multiply(a.add(b), c.add(d));

        final var ad_minus_bc = thirdTerm.subtract(firstTerm).subtract(secondTerm);

        return BigInteger.TEN.pow(halfMaxLength * 2).multiply(firstTerm)
                .add(BigInteger.TEN.pow(halfMaxLength).multiply(ad_minus_bc))
                .add(secondTerm);
    }

    public int numLength(BigInteger n) {
        return n.toString().length();
    }
}
