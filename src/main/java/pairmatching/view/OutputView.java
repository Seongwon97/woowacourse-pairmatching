package pairmatching.view;

import pairmatching.domain.crew.Crew;
import pairmatching.domain.pair.Pair;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static void printPairMatchCommandGuide() {
        System.out.println("#############################################" + System.lineSeparator() +
                "과정: 백엔드 | 프론트엔드" + System.lineSeparator() +
                "미션:" + System.lineSeparator() +
                "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임" + System.lineSeparator() +
                "  - 레벨2: 장바구니 | 결제 | 지하철노선도" + System.lineSeparator() +
                "  - 레벨3: " + System.lineSeparator() +
                "  - 레벨4: 성능개선 | 배포" + System.lineSeparator() +
                "  - 레벨5: " + System.lineSeparator() +
                "############################################" + System.lineSeparator() +
                "과정, 레벨, 미션을 선택하세요." + System.lineSeparator() +
                "ex) 백엔드, 레벨1, 자동차경주");
    }

    public static void printPairMatchResult(List<Pair> pairs) {
        System.out.println(System.lineSeparator() + "페어 매칭 결과입니다.");
        for (Pair pair : pairs) {
            List<String> pairNames = pair.getCrews().stream()
                    .map(Crew::getName)
                    .collect(Collectors.toList());
            System.out.println(String.join(" : ", pairNames));
        }
        System.out.println();
    }
}
