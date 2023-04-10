package current_weather;

import com.google.gson.annotations.SerializedName;

public class Clouds {

    @SerializedName("all")
    private int cloud;

    public Clouds(int cloud) {

        this.cloud = cloud;

    }

}
