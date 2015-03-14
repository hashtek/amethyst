package hashtek.ameythist.model;

import android.graphics.drawable.Drawable;

import java.lang.String;

public class App {
    private String appname = "";
    private String pname = "";
    private Drawable icon;

    public App(String appname, String pname, Drawable icon) {
        this.appname = appname;
        this.pname = pname;
        this.icon = icon;
    }

    public String getAppName() {
        return appname;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }

    public String getPackageName() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return getAppName();
    }
}