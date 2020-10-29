import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

public class FileReaderAndFlieWriter {

    public ArrayList<school> sch = new ArrayList<>();

    public void ReadInVal() {
        /*
        Reads in the data from the csv file into the school array
         */
        BufferedReader buff;
        try{
            buff = new BufferedReader(new FileReader("Soweto.csv"));
            String info ;
            while((info =buff.readLine())!=null){
                String[] arr = info.split(";");
                if(!arr[1].equalsIgnoreCase("lat")) {
                    double lat = Double.parseDouble(arr[1].replace(',','.'));
                    double ing = Double.parseDouble(arr[2].replace(',','.'));
                    double rate = Double.parseDouble(arr[3]);
                    school s = new school(arr[0], lat, ing, rate);
                    sch.add(s);
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void createFile(ArrayList<school>sch){
        /*
        Creates and writes, txt file, named Output
         */

        shortestPath path = new shortestPath(sch.size(),sch);
        path.findLink();
        path.graphDist();
        double arr[] = path.Dijkstra(0);
        ArrayList<school> schools = path.sch;

        FileWriter write = null;
        try {
            write = new FileWriter("Output.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter print = new PrintWriter(write);

        print.println("From '" + schools.get(0).schoolName + "' to '" + schools.get(129).schoolName + "' is " + arr[129] + "km");
        print.println("From '" + schools.get(0).schoolName + "' to '" + schools.get(32).schoolName + "' is " + arr[32] + "km");
        print.println("From '" + schools.get(131).schoolName + "' to '" + schools.get(32).schoolName + "' is " + arr[32] + "km");
        print.println("From '" + schools.get(131).schoolName + "' to '" + schools.get(35).schoolName + "' is " + arr[35] + "km");
        print.println("From '" + schools.get(25).schoolName + "' to '" + schools.get(95).schoolName + "' is " + arr[95] + "km");
        print.println("From '" + schools.get(29).schoolName + "' to '" + schools.get(132).schoolName + "' is " + arr[132] + "km");


        

        print.close();
    }

}
