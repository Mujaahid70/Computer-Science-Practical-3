import java.util.*;

public class Main {


    public static void main(String[] args) {

        FileReaderAndFlieWriter school= new FileReaderAndFlieWriter();
        shortestPath graph;


        school.ReadInVal();
        school.createFile(school.sch);
        graph = new shortestPath(school.sch.size(), school.sch);
        graph.findLink();
        graph.graphDist();

    }
}
