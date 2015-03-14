package hashtek.ameythist;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.List;

import hashtek.ameythist.model.App;


public class Utilities {

    public static ArrayList<App> getInstalledApps(Context context, boolean getSysPackages) {

        final PackageManager pkgManager = context.getPackageManager();

        ArrayList<App> appList = new ArrayList<>();
        List<PackageInfo> packages = context.getPackageManager().getInstalledPackages(PackageManager.COMPONENT_ENABLED_STATE_ENABLED);

        for ( PackageInfo pkg : packages ) {

            if ((!getSysPackages) && (pkg.versionName == null))
                continue ;

            String appname = pkg.applicationInfo.loadLabel(pkgManager).toString();
            String pkgname = pkg.packageName;
            Drawable icon = pkg.applicationInfo.loadIcon(pkgManager);

            App item = new App(appname, pkgname, icon);
            appList.add(item);
        }
        return appList;
    }
}