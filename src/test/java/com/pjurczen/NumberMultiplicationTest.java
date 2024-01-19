package com.pjurczen;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;

class NumberMultiplicationTest {

    private final NumberMultiplication testee = new NumberMultiplication();

    @Test
    void multiplySmallNumbers() {
        // given
        final var a = BigInteger.valueOf(12);
        final var b = BigInteger.valueOf(34);
        // when
        final var result = testee.multiply(a,  b);
        // then
        assertThat(result).isEqualTo(408);
    }

    @Test
    void multiplyUnevenNumbers() {
        // given
        final var a = BigInteger.valueOf(3);
        final var b = BigInteger.valueOf(11);
        // when
        final var result = testee.multiply(a,  b);
        // then
        assertThat(result).isEqualTo(33);
    }

    @Test
    void multiplyBiggerUnevenNumbers() {
        // given
        final var a = BigInteger.valueOf(33);
        final var b = BigInteger.valueOf(111);
        // when
        final var result = testee.multiply(a,  b);
        // then
        assertThat(result).isEqualTo(3663);
    }

    @Test
    void multiplyBigNumbers() {
        // given
        final var a = new BigInteger("3141592653589793238462643383279502884197169399375105820974944592");
        final var b = new BigInteger("2718281828459045235360287471352662497757247093699959574966967627");

        final var expected = new BigInteger("8539734222673567065463550869546574495034888535765114961879601127067743044893204848617875072216249073013374895871952806582723184");
        // when
        final var result = testee.multiply(a,  b);
        // then
        assertThat(result).isEqualTo(expected);
    }
}