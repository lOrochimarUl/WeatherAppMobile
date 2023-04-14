package five_day_forecast;

import com.google.gson.annotations.SerializedName;

public class Coord {

    @SerializedName("lat")
    private double latitude;
    @SerializedName("lon")
    private double longitude;

    public Coord(double lat, double lon){

        this.latitude = lat;
        this.longitude = lon;

    }


}
