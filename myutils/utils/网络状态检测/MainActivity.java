package hitinga.com.netlistener;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private NetListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.text);
        registerNetLienster();
        textView.setText(NetSpeedUtils.getInstence().getNetSpeed()+"Kb/s");
    }

    private void registerNetLienster() {

        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        listener = new NetListener();
        registerReceiver(listener, filter);
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(listener);
    }

}
