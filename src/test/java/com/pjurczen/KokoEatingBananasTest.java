package com.pjurczen;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KokoEatingBananasTest {

    private final KokoEatingBananas testee = new KokoEatingBananas();

    @Test
    void minEatingSpeedBig() {
        // given
        var input = new int[]{332484035, 524908576, 855865114, 632922376, 222257295, 690155293, 112677673, 679580077, 337406589, 290818316, 877337160, 901728858, 679284947, 688210097, 692137887, 718203285, 629455728, 941802184};
        // when
        var result = testee.minEatingSpeed(input, 823855818);
        // then
        assertThat(result).isEqualTo(14);
    }

    @Test
    void minEatingSpeedWeird() {
        // given
        var input = new int[]{1, 1, 1, 999999999};
        // when
        var result = testee.minEatingSpeed(input, 10);
        // then
        assertThat(result).isEqualTo(142857143);
    }
}