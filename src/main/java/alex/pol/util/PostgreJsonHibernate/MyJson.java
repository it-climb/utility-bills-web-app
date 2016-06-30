package alex.pol.util.PostgreJsonHibernate;

import com.google.gson.Gson;
import net.sf.json.JSONObject;

import java.io.Serializable;

public class MyJson implements Serializable {

    private JSONObject jsonObject;

    public JSONObject getJsonObject() {
        return jsonObject;
    }

    public void setJsonObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }
    //Gson gson;


    /*private String stringProp;

    private Long longProp;

    public String getStringProp() {
        return stringProp;
    }

    public void setStringProp(String stringProp) {
        this.stringProp = stringProp;
    }

    public Long getLongProp() {
        return longProp;
    }

    public void setLongProp(Long longProp) {
        this.longProp = longProp;
    }*/
}