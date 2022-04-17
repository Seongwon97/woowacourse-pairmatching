package pairmatching.service.exception;

public class DuplicatePairException extends IllegalStateException {

    public DuplicatePairException() {
        super("[ERROR] 중복된 페어 매칭이 존재합니다.");
    }
}
