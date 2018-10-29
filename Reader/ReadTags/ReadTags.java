import com.impinj.octane.ImpinjReader;
import com.impinj.octane.OctaneSdkException;
import com.impinj.octane.Settings;

import java.awt.*;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadTags {
//    public static String path = "D:\\陈星宇\\GitHub\\Arrays\\随机共振弱信号检测\\Data\\0625\\";
    public static String path = "Data\\";
//    public static String path = ".\\twins\\Data0528\\";
    public static String TEXTNAME = "demo7";
    public static String hostname = "192.168.1.127";

    public static void main(String[] args) {
        try {
            File file = new File(path);
            if (!file.exists() && !file.isDirectory()) {
                file.mkdirs();
            }
            Thread.sleep(10000);
            Toolkit.getDefaultToolkit().beep();
            ImpinjReader reader = new ImpinjReader();
            reader.connect(hostname);
            reader.applySettings(Settings.load("ReadTags/"+hostname +".xml"));
            reader.setTagReportListener(new TagReportListenerImplementation(TEXTNAME));
            reader.start();
            Toolkit.getDefaultToolkit().beep();
//            Scanner s = new Scanner(System.in);
            
//            for (int k = 0;k<6;k++)
//            {
//                Thread.sleep(20000);
//                Toolkit.getDefaultToolkit().beep();
//            }
            Thread.sleep(10000);
            reader.stop();
            Toolkit.getDefaultToolkit().beep();
            reader.disconnect();
        } catch (OctaneSdkException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace(System.out);
        }
    }
//    public static double getEntropy(ArrayList<Double> phase_list) {
//        int value_len = (int) Math.round(2 * 3 * Math.PI+1);
//        double[] value_num = new double[value_len];
//        double inter=Math.PI*2/value_len;
//        for (int i = 0; i < phase_list.size(); i++) {
//
//            //int index = (int) Math.round(phase_list.get(i) * 10);
//            int index=(int)(phase_list.get(i)/inter);
//            value_num[index] += 1;
//        }
//
//        double sum = 0;
//        for (int i = 0; i < value_num.length; i++) {
//            if (value_num[i] != 0) {
//                value_num[i] /= phase_list.size();
//                sum += value_num[i] * Math.log(value_num[i]) / Math.log(2);
//            }
//        }
//        return -sum;
//    }
}
