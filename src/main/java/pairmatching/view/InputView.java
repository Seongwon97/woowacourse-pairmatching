package pairmatching.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String inputOption() {
        System.out.println("기능을 선택하세요." + System.lineSeparator() +
                "1. 페어 매칭" + System.lineSeparator() +
                "2. 페어 조회" + System.lineSeparator() +
                "3. 페어 초기화" + System.lineSeparator() +
                "Q. 종료");
        return scanner.nextLine();
    }

    public static String[] inputMatchInfo() {
        String input = scanner.nextLine();
        return validateAndSplitMatchInfoSize(input);
    }

    private static String[] validateAndSplitMatchInfoSize(String input) {
        String[] infos = input.split(", |,");

        if (infos.length != 3) {
            throw new IllegalArgumentException("[ERROR] 다음과 같이 세가지 정보를 입력해줘야 합니다. ex) 백엔드, 레벨1, 자동차경주");
        }
        return infos;
    }
}
