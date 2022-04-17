package pairmatching.controller;

import pairmatching.domain.crew.Crew;
import pairmatching.domain.mission.Course;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrewInfoReader {

    private static final String BACKEND_CREW_INFO = "src/main/resources/backend-crew.md";
    private static final String FRONTEND_CREW_INFO = "src/main/resources/frontend-crew.md";

    public static List<Crew> readCrewsInfo() {
        List<Crew> crews = new ArrayList<>();
        try {
            readBackend(crews);
            readFrontEnd(crews);
        } catch (IOException e) {
            throw new IllegalArgumentException("[ERROR] 파일을 읽는 중 오류가 발생했습니다. ");
        }
        return crews;
    }

    private static void readBackend(List<Crew> crews) throws IOException {
        BufferedReader reader = new BufferedReader(
                new FileReader(BACKEND_CREW_INFO)
        );
        String str;
        while ((str = reader.readLine()) != null) {
            crews.add(new Crew(Course.BACKEND, str));
        }
        reader.close();
    }

    private static void readFrontEnd(List<Crew> crews) throws IOException {
        BufferedReader reader = new BufferedReader(
                new FileReader(FRONTEND_CREW_INFO)
        );
        String str;
        while ((str = reader.readLine()) != null) {
            crews.add(new Crew(Course.FRONTEND, str));
        }
        reader.close();
    }
}
