package chapter6.item37.before;

/**
 * 배열들의 배열의 인덱스에 ordinal()을 사용 - 따라 하지 말 것
 */
public enum Phase {
    // 상태 전이
    // 고체, 액체, 기체
    SOLID, LIQUID, GAS;

    public enum Transition {
        MELT, FREEZE, BOIL, CONDENSE, SUBLIME, DEPOSIT;

        // 행은 from의 ordinal을, 열은 to ordinal을 인덱스로 쓴다.
        private static final Transition[][] TRANSITIONS = {
                {null, MELT, SUBLIME},
                {FREEZE, null, BOIL},
                {DEPOSIT, CONDENSE, null}
        };

        // 액체(LIQUID) -> 고체(SOLID) : 응고(FREEZE)
        // 액체(LIQUID) -> 기체(GAS) : 기화(BOIL)
        public static Transition from(Phase from, Phase to) {
            return TRANSITIONS[from.ordinal()][to.ordinal()];
        }
    }
}
