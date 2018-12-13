package com.mydao.datacollection.utils;

import java.net.InetAddress;

public class NetUtils {

    public static boolean isReachable(String remoteInetAddr) {
        boolean reachable = false;
        try {
            InetAddress address = InetAddress.getByName(remoteInetAddr);
            reachable = address.isReachable(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        return reachable;
    }

}
