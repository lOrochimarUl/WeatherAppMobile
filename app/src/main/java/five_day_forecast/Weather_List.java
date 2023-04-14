package five_day_forecast;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Weather_List {

    private Integer dt;
    @SerializedName("main")
    private Main_Info mainInfo;
    private List<Weather_Info> weather;
    private Clouds clouds;
    private Wind_Info wind;
    private int visibility;
    private Double pop;
    private Rain_Info rain;
    private String snow;
    private Sys sys;
    private String dt_txt;

    public void add(Integer dt, String  dt_txt){
        this.dt = dt;
        this.dt_txt = dt_txt;
    }
    public Weather_List(Integer dt, Main_Info mainInfo, List<Weather_Info> weatherInfo, Clouds clouds, Wind_Info wind, int visibility,
                        Double pop, Sys sys, String dt_txt){
        this.dt = dt;
        this.mainInfo = mainInfo;
        this.weather = weatherInfo;
        this.clouds = clouds;
        this.wind = wind;
        this.visibility = visibility;
        this.pop = pop;
        this.sys = sys;
        this.dt_txt = dt_txt;
    }


}
