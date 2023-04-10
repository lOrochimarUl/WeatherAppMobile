package current_weather;

import java.util.List;

public class Root {

    private Coord coord;
    private List<Weather> weather;
    private String base;
    private Main main;
    private int visibility;
    private Wind wind;
    private Clouds clouds;
    private String dt;
    private Sys sys;
    private int timezone;
    private int id;
    private String name;
    private int cod;

    public Root(Coord coord ,List<Weather> weather, String base, Main main, int visibility, Wind wind, Clouds clouds, String dt, Sys sys,
                int timezone, int id, String name, int cod){

        this.coord = coord;
        this.weather = weather;
        this.base = base;
        this.main = main;
        this.visibility = visibility;
        this.wind = wind;
        this.clouds = clouds;
        this.dt = dt;
        this.sys = sys;
        this.timezone = timezone;
        this.id = id;
        this.name = name;
        this.cod = cod;

    }




}
