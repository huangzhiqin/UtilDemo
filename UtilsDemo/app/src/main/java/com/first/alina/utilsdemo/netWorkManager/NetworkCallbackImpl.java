package com.first.alina.utilsdemo.netWorkManager;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.util.Log;

/**
 * Created by alina on 2019/4/10.
 */

public class NetworkCallbackImpl extends ConnectivityManager.NetworkCallback{
    private final String TAG="NetworkCallbackImpl";
    @Override
    public void onAvailable(Network network) {
        super.onAvailable(network);
        Log.e(TAG,"网络连接成功  "+network.toString());
    }

    @Override
    public void onLost(Network network) {
        super.onLost(network);
        Log.e(TAG,"网络断开  "+network.toString());
    }

    @Override
    public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        super.onCapabilitiesChanged(network, networkCapabilities);

        if (networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)){
            if (networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)){
                Log.e(TAG,"========>>>>> 连接 wifi ");
            }else {
                Log.e(TAG, "网络发生变更，类型为其他");
            }
        }
    }
}
