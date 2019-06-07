package io.github.confuser2188.launcherpac.misc;

import java.text.DecimalFormat;

public class SystemInfo {

    public static String getMaxRAM(){
        com.sun.management.OperatingSystemMXBean bean =
                (com.sun.management.OperatingSystemMXBean)
                        java.lang.management.ManagementFactory.getOperatingSystemMXBean();
        return new DecimalFormat("##.#").format((double)bean.getTotalPhysicalMemorySize() / 1073741824);
    }
}
