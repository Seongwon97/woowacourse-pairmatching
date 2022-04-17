package pairmatching.controller;

import pairmatching.domain.mission.Course;
import pairmatching.domain.mission.Level;
import pairmatching.domain.mission.Mission;
import pairmatching.domain.pair.Pair;
import pairmatching.service.CrewService;
import pairmatching.service.PairService;
import pairmatching.service.exception.DuplicatePairException;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.util.List;

public class PairMatchingController {

    private static final CrewService crewService = new CrewService(CrewInfoReader.readCrewsInfo());
    private static final PairService pairService = new PairService();

    public void run() {
        while (true) {
            try {
                Command command = Command.of(InputView.inputOption());
                if(command == Command.FINISH) {
                    break;
                }
                executeCommand(command);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void executeCommand(Command command) {
        OutputView.printPairMatchCommandGuide();
        String[] input = InputView.inputMatchInfo();

        Course course = Course.of(input[0]);
        Level level = Level.of(input[1]);
        Mission mission = Mission.of(input[2], level);

        if (command == Command.MATCHING) {
            matching(course, mission);
        }
        if (command == Command.INQUIRE) {
            inquire(course, mission);
        }
        if (command == Command.RESET) {
            reset(course, mission);
        }
    }

    private void matching(Course course, Mission mission) {
        if (checkExistMatch(course, mission)) return;

        matchNewPairs(1, course, mission);
        OutputView.printPairMatchResult(pairService.inquirePairs(mission, course));
    }

    private boolean checkExistMatch(Course course, Mission mission) {
        if (!pairService.inquirePairs(mission, course).isEmpty()) {
            RematchResponse response = RematchResponse.of(InputView.inputRematchResponse());
            if (response == RematchResponse.NO) {
                return true;
            }
            pairService.deletePairs(mission, course);
        }
        return false;
    }

    private void matchNewPairs(int repeat, Course course, Mission mission) {
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

    private void inquire(Course course, Mission mission) {
        List<Pair> pairs = pairService.inquirePairs(mission, course);
        if (checkNotExistMatch(pairs)) return;
        OutputView.printPairMatchResult(pairs);
    }

    private boolean checkNotExistMatch(List<Pair> pairs) {
        if (pairs.isEmpty()) {
            OutputView.printNotExistMatchMessage();
            return true;
        }
        return false;
    }

    private void reset(Course course, Mission mission) {
        List<Pair> pairs = pairService.inquirePairs(mission, course);
        if (checkNotExistMatch(pairs)) return;
        pairService.deletePairs(mission, course);
        OutputView.printDeleteSuccessMessage();
    }
}
