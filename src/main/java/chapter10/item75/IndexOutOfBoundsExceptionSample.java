package chapter10.item75;

public class IndexOutOfBoundsExceptionSample extends RuntimeException {

    private int lowerBound;
    private int upperBound;
    private int index;

    public IndexOutOfBoundsExceptionSample(int lowerBound, int upperBound, int index) {
        // 실패를 포착하는 상세 메시지를 생성
        super(String.format("최솟값: %d, 최댓값: %d, 인덱스: %d", lowerBound, upperBound, index));

        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.index = index;
    }
}
