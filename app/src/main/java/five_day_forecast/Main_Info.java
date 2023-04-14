package five_day_forecast;

import com.google.gson.annotations.SerializedName;

public class Main_Info {

    @SerializedName("temp")
    private double temperature;
    private double feels_like;
    private double temp_min;
    private double temp_max;
    private int pressure;
    private int sea_level;
    @SerializedName("grnd_level")
    private int ground_level;
    private int humidity;
    private double temp_kf;
    public Main_Info(double temperature, double feels_like, double temp_min, double temp_max, int pressure, int sea_level, int ground_level,
                    int humidity){
        this.temperature = temperature;
        this.feels_like = feels_like;
        this.temp_min = temp_min;
        this.temp_max = temp_max;
        this.pressure = pressure;
        this.sea_level = sea_level;
        this.ground_level = ground_level;
        this.humidity = humidity;
    }


}
