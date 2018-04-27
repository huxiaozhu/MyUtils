package hitinga.com.netlistener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.widget.Toast;

/**
 * Created by ChenHui on 2017/1/14.
 */

public class NetListener extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager manger = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mobInfo = manger.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        NetworkInfo wifiInfo = manger.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (mobInfo.isConnected()) {
            getMobStatus(mobInfo,context);
        } else if (wifiInfo.isConnected()) {
            getWifiStatus(context);
        } else {
            Toast.makeText(context, "无网络连接，请检查网络！！！", Toast.LENGTH_SHORT).show();
        }
    }

    private void getWifiStatus(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        Toast.makeText(context, "wifi名字:"+wifiInfo.getBSSID()+
                "\tWiFi信号强度"+ WifiManager.calculateSignalLevel(wifiInfo.getRssi(),5)+
                "\twifi速度"+wifiInfo.getLinkSpeed()+
                "\twifi速度单位"+WifiInfo.LINK_SPEED_UNITS, Toast.LENGTH_LONG).show();
    }

    private void getMobStatus(NetworkInfo mobInfo, Context context) {
        switch (mobInfo.getSubtype()) {
            case TelephonyManager.NETWORK_TYPE_GPRS:
            case TelephonyManager.NETWORK_TYPE_EDGE:
            case TelephonyManager.NETWORK_TYPE_CDMA:
            case TelephonyManager.NETWORK_TYPE_1xRTT:
            case TelephonyManager.NETWORK_TYPE_IDEN:
                Toast.makeText(context, "您现在是2g网络", Toast.LENGTH_SHORT).show();
                break;
            case TelephonyManager.NETWORK_TYPE_UMTS:
            case TelephonyManager.NETWORK_TYPE_EVDO_0:
            case TelephonyManager.NETWORK_TYPE_EVDO_A:
            case TelephonyManager.NETWORK_TYPE_HSDPA:
            case TelephonyManager.NETWORK_TYPE_HSUPA:
            case TelephonyManager.NETWORK_TYPE_HSPA:
            case TelephonyManager.NETWORK_TYPE_EVDO_B:
            case TelephonyManager.NETWORK_TYPE_EHRPD:
            case TelephonyManager.NETWORK_TYPE_HSPAP:
                Toast.makeText(context, "您现在是3g网络", Toast.LENGTH_SHORT).show();
                break;
            case TelephonyManager.NETWORK_TYPE_LTE:
                Toast.makeText(context, "您现在是4g网络", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
