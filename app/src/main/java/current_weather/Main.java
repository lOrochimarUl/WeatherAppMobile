package current_weather;

import com.google.gson.annotations.SerializedName;

public class Main {

    private double temp;
    private double feels_like;
    private double temp_min;
    private double temp_max;
    private int pressure;
    private int humidity;
    private int sea_level;
    @SerializedName("grnd_level")
    private int ground_lvl;

    public Main(double temp, double feels_like, double temp_min, double temp_max, int pressure, int humidity, int sea_level, int ground_lvl){

        this.temp = temp;
        this.feels_like = feels_like;
        this.temp_min = temp_min;
        this.temp_max = temp_max;
        this.pressure = pressure;
        this.humidity = humidity;
        this.sea_level = sea_level;
        this.ground_lvl = ground_lvl;

    }

}
