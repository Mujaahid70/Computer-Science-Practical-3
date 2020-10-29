/*
Created by Mujaahid Abrahams, Student number 3950547,
Class that constructs a graph. It contains 2 constructor classes, vertex and Edge.
As well as the public data-structure - HashSet of type school to store the values of the vertex and Edge.
It also contains the following methods:
void Graph()
boolean addEgde(vertex v1, vertex v2)
boolean addVert(vertex v)
 */
import java.util.*;

public class shortestPath{
    /*
    Class for calculating the distances between schools.
    Using Dijkstra's Algorithm
     */

    private int size;
    public double graph[][];
    ArrayList<school> sch;

    public shortestPath(int size,ArrayList<school> arr){
        //constructor that initializes variables
        this.size = size;
        this.sch = arr;
        graph = new double[size][size];
        for(int i=0;i<size;i++){
            for(int k=0;k<size;k++){
                graph[i][k] = 0;
            }
        }
    }

    public void findLink(){
        //determines the link between the longitude and latitude of every school
        for(int i=0;i<size;i++){
            for(int k=0;k<size;k++){
                if(Math.floor(sch.get(k).schoolName.length()%6) == Math.floor(sch.get(k).schoolRating)  && Math.floor(Math.sqrt(Math.pow(sch.get(i).schoolat,2)*(Math.pow(sch.get(i).schoolIng,2)))%6) == Math.floor(sch.get(k).schoolName.length()%6)){
                    graph[i][k] = -1;
                }
            }
        }
    }

    public double Haversine (school sorc, school dest){
        //calculates the distance bewteen each school (in kilometers)
        //uses the haversine therom.
        double lat,lat2,ing,ing2,sub,sub2,a,b,c;
        lat = Math.toRadians(sorc.schoolat);
        lat2= Math.toRadians(dest.schoolat);
        ing = Math.toRadians(sorc.schoolIng);
        ing2 = Math.toRadians(dest.schoolIng);
        sub = Math.toRadians(lat2-lat);
        sub2 = Math.toRadians(ing2-ing);

        a = Math.pow(Math.sin((sub/2)),2) + Math.cos(lat)*Math.cos(lat2)*Math.pow(Math.sin(sub2/2),2);
        c = 2*Math.atan2(Math.sqrt(a),Math.sqrt(1-a));
        b = 6371e3*c;
        return b/1000;
    }
    public void graphDist(){
        //places distances in graph
        for(int i=0;i<sch.size();i++){
            for(int k=0;k<sch.size();k++){
                if(graph[i][k]==-1){
                    graph[i][k] = Haversine(sch.get(i),sch.get(k));
                }
            }
        }
    }

    public double[] Dijkstra(int sorc) {
        //destermines the shortest path between schools starting from sorc till end.
        double dist[] = new double[size];
        Boolean spt[] = new Boolean[size];
        for (int i = 0; i < size; i++) {
            dist[i] = Double.MAX_VALUE;
            spt[i] = false;
        }

        dist[sorc] = 0;
        for (int i = 0; i < size - 1; i++) {
            int des = (int) minDist(dist, spt);
            spt[des] = true;
            for (int k = 0; k < size; k++)
                if (!spt[k] && graph[des][k] != 0 && dist[des] != Double.MAX_VALUE && dist[des] + graph[des][k] < dist[k]) {
                    dist[k] = dist[des] + graph[des][k];
                }
        }

        System.out.println("vertex \t\t Distance from source");
        for (int i = 0; i < size; i++) {
            System.out.println(i + "\t\t " + dist[i]);
        }
        return dist;

    }

    public double minDist(double arr[], Boolean spt[]){
        double min = Double.MAX_VALUE;
        double minIndex = -1;
        for(int i=0;i<size;i++){
            if(!spt[i] && arr[i]<=min){
                min = arr[i];
                minIndex = i;
            }
        }
        return  minIndex;
    }





}
