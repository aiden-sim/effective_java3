package chapter6.item34;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public enum ErrorCodes {
    BUSINESS_ERROR(100),
    SERVER_ERROR(500);

    private int errorCode;
    private static Map<Integer, ErrorCodes> errorCodeByErrorNumber = new HashMap<Integer, ErrorCodes>();

    static {
        for (ErrorCodes errorCode : ErrorCodes.values()) {
            errorCodeByErrorNumber.put(errorCode.getErrorCode(), errorCode);
        }
    }

    private final static int 상수 = 0;

    ErrorCodes(int errorCode) {
        this.errorCode = errorCode;
        System.out.println(상수); // 접근 가능
        // NullPointerException
        // Map<String, ErrorCodes> stringToEnum =  Stream.of(values()).collect(
        //         toMap(Object::toString, e -> e));
    }

    public int getErrorCode() {
        return errorCode;
    }

    private static final Map<String, ErrorCodes> stringToEnum =
            Stream.of(values()).collect(
                    toMap(Object::toString, e -> e));

    @Override
    public String toString() {
        return String.valueOf(errorCode);
    }

    public static Optional<ErrorCodes> fromString(String symbol) {
        return Optional.ofNullable(stringToEnum.get(symbol));
    }

    public static void main(String[] args) {
        System.out.println(ErrorCodes.fromString("100"));
    }
}
