/*
Created by Mujaahid Abrahams, student Number 3954507.
Class that constructs object school, it contians variables:
String schoolName;
String schoolat;
String schoolIng;
String schoolRating;
And contains the following methods:
school(String name,String lat,String ing,String rating)
ToString()
 */
public class school {
    public String schoolName;
    public double schoolat;
    public double schoolIng;
    public double schoolRating;

    public school(String name,double lat,double ing,double rating){
            /*
            This method is a constructor that initializes the attributes of school
             */
        this.schoolName = name;
        this.schoolat = lat;
        this.schoolIng = ing;
        this.schoolRating = rating;
    }

    public String ToString(){
            /*
            this method allows at the variables to be displayed in the as one.
             */
        return schoolName+","+schoolat+","+schoolIng+","+schoolRating;
    }
}
