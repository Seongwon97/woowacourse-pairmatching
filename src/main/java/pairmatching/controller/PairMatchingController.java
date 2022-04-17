package pairmatching.controller;

import pairmatching.domain.mission.Course;
import pairmatching.domain.mission.Level;
import pairmatching.domain.mission.Mission;
import pairmatching.service.CrewService;
import pairmatching.service.PairService;
import pairmatching.service.exception.DuplicatePairException;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {

    private static final CrewService crewService = new CrewService(CrewInfoReader.readCrewsInfo());
    private static final PairService pairService = new PairService();

    public void run() {
        boolean isContinue = true;
        while (isContinue) {
            try {
                Command command = Command.of(InputView.inputOption());
                command.execute();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static void matching() {
        OutputView.printPairMatchCommandGuide();
        String[] input = InputView.inputMatchInfo();

        Course course = Course.of(input[0]);
        Level level = Level.of(input[1]);
        Mission mission = Mission.of(input[2], level);

        if (checkExistMatch(course, mission)) return;

        matchNewPairs(1, course, mission);
        OutputView.printPairMatchResult(pairService.inquirePairs(mission, course));
    }

    private static boolean checkExistMatch(Course course, Mission mission) {
        if (!pairService.inquirePairs(mission, course).isEmpty()) {
            RematchResponse response = RematchResponse.of(InputView.inputRematchResponse());
            if (response == RematchResponse.NO) {
                return true;
            }
            pairService.deletePairs(mission, course);
        }
        return false;
    }

    private static void matchNewPairs(int repeat, Course course, Mission mission) {
        if (repeat > 3) {
            throw new IllegalStateException("[ERROR] 페어 매칭에 실패했습니다.");
        }
        try {
            pairService.createNewPairs(mission, crewService.getShuffledCrew(course));
        } catch (DuplicatePairException e) {
            OutputView.printRematchMessage();
            matchNewPairs(repeat + 1, course, mission);
        }
    }

    static void inquire() {
        OutputView.printPairMatchCommandGuide();
        String[] input = InputView.inputMatchInfo();

        Course course = Course.of(input[0]);
        Level level = Level.of(input[1]);
        Mission mission = Mission.of(input[2], level);

        OutputView.printPairMatchResult(pairService.inquirePairs(mission, course));
    }
}
