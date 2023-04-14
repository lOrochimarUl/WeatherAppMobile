package five_day_forecast;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Root {
    private String cod;
    private int message;
    @SerializedName("cnt")
    private int count;
    private List<Weather_List> list;
    private City city;
    public void Set(String cod, int message, int count, List<Weather_List> list, City city){
        this.cod = cod;
        this.message = message;
        this.count = count;
        this.list = list;
        this.city = city;
    }
}
