package chapter6.item34;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class ErrorCodes2 {
    private static final ErrorCodes2 BUSINESS_ERROR = new ErrorCodes2(100);
    private static final ErrorCodes2 SERVER_ERROR = new ErrorCodes2(500);

    private static ErrorCodes2[] values() {
        return new ErrorCodes2[]{BUSINESS_ERROR, SERVER_ERROR};
    }

    private int errorCode;
    private static Map<Integer, ErrorCodes2> errorCodeByErrorNumber = new HashMap<Integer, ErrorCodes2>();

    static {
        for (ErrorCodes2 errorCode : ErrorCodes2.values()) {
            errorCodeByErrorNumber.put(errorCode.getErrorCode(), errorCode);
        }
    }

    ErrorCodes2(int errorCode) {
        this.errorCode = errorCode;
        //NullPointerException (이때 errorCodeByErrorNumber는 ErrorCode2 상수가 아직 초기화 되지 않았다.)
        //errorCodeByErrorNumber.put(errorCode, this);
    }

    public int getErrorCode() {
        return errorCode;
    }

    private static final Map<String, ErrorCodes2> stringToEnum =
            Stream.of(values()).collect(
                    toMap(Object::toString, e -> e));

    @Override
    public String toString() {
        return String.valueOf(errorCode);
    }

    public static Optional<ErrorCodes2> fromString(String symbol) {
        return Optional.ofNullable(stringToEnum.get(symbol));
    }

    public static void main(String[] args) {
        System.out.println(ErrorCodes2.fromString("100"));
    }
}
