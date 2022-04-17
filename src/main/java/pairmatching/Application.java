package pairmatching;

import pairmatching.controller.PairMatchingController;
import pairmatching.service.PairService;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
        PairMatchingController controller = new PairMatchingController();
        controller.run();
    }
}
