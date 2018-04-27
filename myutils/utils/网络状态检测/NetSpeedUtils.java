package hitinga.com.netlistener;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ChenHui on 2017/1/16.
 * 网速实时检测
 */

public class NetSpeedUtils {
    private ExecutorService service;
    private NetSpeedUtils() {
        service= Executors.newCachedThreadPool();
    }

    private static class Instence {
        private static NetSpeedUtils mInstance=new NetSpeedUtils();
    }

    public static NetSpeedUtils getInstence(){
        return Instence.mInstance;
    }

    /**
     * 返回kb/s（3s平均网速）
     * @return
     */
    public int getNetSpeed() {
        final int[] speed = {0};
        service.submit(new Runnable() {
            @Override
            public void run() {
                int frist = getNetSpeedBytes();
                try {
                    Thread.sleep(3000);
                    speed[0] = (getNetSpeedBytes() - frist)/1024/3;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        return speed[0];
    }

    private int getNetSpeedBytes() {
        String line;
        String[] segs;
        int received = 0;
        int i;
        int tmp = 0;
        boolean isNum;
        try {
            FileReader fr = new FileReader("/proc/net/dev");
            BufferedReader in = new BufferedReader(fr, 500);
            while ((line = in.readLine()) != null) {
                line = line.trim();
                if (line.startsWith("rmnet") || line.startsWith("eth") || line.startsWith("wlan")) {
                    segs = line.split(":")[1].split(" ");
                    for (i = 0; i < segs.length; i++) {
                        isNum = true;
                        try {
                            tmp = Integer.parseInt(segs[i]);
                        } catch (Exception e) {
                            isNum = false;
                        }
                        if (isNum == true) {
                            received = received + tmp;
                            break;
                        }
                    }
                }
            }
            in.close();
        } catch (IOException e) {
            return -1;
        }
        return received;
    }
}
