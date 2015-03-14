package hashtek.ameythist.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import hashtek.ameythist.R;
import hashtek.ameythist.Utilities;
import hashtek.ameythist.model.App;

public class HomeActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final ListView listApps = (ListView) findViewById(R.id.listApps);
        final ArrayAdapter<App> listAdapter = new ArrayAdapter<App>(this, android.R.layout.simple_list_item_1);
        final ProgressDialog loader = ProgressDialog.show(this, "Loading", "Building list of apps", true, false);
        loader.show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ArrayList<App> list = Utilities.getInstalledApps(getApplicationContext(), false);
                for ( App item: list)
                    listAdapter.add(item);

                listApps.setAdapter(listAdapter);
                loader.dismiss();
            }
        }, 100);

        listApps.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                App selected = (App)parent.getItemAtPosition(position);
                String pkg = selected.getPackageName();
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage(pkg);
                startActivity(launchIntent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings)
            return true;
        return super.onOptionsItemSelected(item);
    }
}
