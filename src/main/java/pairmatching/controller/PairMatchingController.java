package pairmatching.controller;

import pairmatching.domain.mission.Course;
import pairmatching.domain.mission.Level;
import pairmatching.domain.mission.Mission;
import pairmatching.service.CrewService;
import pairmatching.service.PairService;
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
                System.out.println(command.toString());
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

        pairService.createNewPairs(mission, crewService.getShuffledCrew(course));
        OutputView.printPairMatchResult(pairService.inquirePairs(mission, course));
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
