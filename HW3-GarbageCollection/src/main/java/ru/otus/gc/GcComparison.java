package ru.otus.gc;

import com.google.common.util.concurrent.AtomicDouble;
import com.sun.management.GarbageCollectionNotificationInfo;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;
import javax.management.MBeanServer;
import javax.management.NotificationEmitter;
import javax.management.NotificationListener;
import javax.management.ObjectName;
import javax.management.openmbean.CompositeData;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.*;

public class GcComparison {

    public static void main(String... args) throws Exception {

        System.out.println("Starting pid: " + ManagementFactory.getRuntimeMXBean().getName());
        switchOnMonitoring();
        long beginTime = System.currentTimeMillis();

        int size = 5 * 10000 * 10000;

        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();

        ObjectName name = new ObjectName("ru.otus:type=Benchmark");

        Benchmark mbean = new Benchmark();

        mbs.registerMBean(mbean, name);
        mbean.setSize(size);
        mbean.run();

        System.out.println("time:" + (System.currentTimeMillis() - beginTime) / 1000);

    }

    private static void switchOnMonitoring() {

        Logger logger = Logger.getLogger(GcComparison.class.getName());
        logger.setUseParentHandlers(false);
        try {
            FileHandler fh = new FileHandler("%tLogGcComparison");
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);

        } catch (SecurityException e) {
            logger.log(Level.SEVERE,
                    "Не удалось создать файл лога из-за политики безопасности.", e);
        } catch (IOException e) {
            logger.log(Level.SEVERE,
                    "Не удалось создать файл лога из-за ошибки ввода-вывода.", e);
        }
        List<GarbageCollectorMXBean> gcbeans = java.lang.management.ManagementFactory.getGarbageCollectorMXBeans();
        AtomicInteger oldCounter = new AtomicInteger(0);
        AtomicInteger youngCounter = new AtomicInteger(0);
        AtomicDouble oldTimeCounter = new AtomicDouble(0.0);
        AtomicDouble youngTimeCounter = new AtomicDouble(0.0);
        for (GarbageCollectorMXBean gcbean : gcbeans) {
            System.out.println("GC name:" + gcbean.getName());
            NotificationEmitter emitter = (NotificationEmitter) gcbean;
            NotificationListener listener = (notification, handback) -> {

                if (notification.getType().equals(GarbageCollectionNotificationInfo.GARBAGE_COLLECTION_NOTIFICATION)) {
                    GarbageCollectionNotificationInfo info = GarbageCollectionNotificationInfo.from((CompositeData) notification.getUserData());
                    String gcName = info.getGcName();
                    String gcAction = info.getGcAction();
                    String gcCause = info.getGcCause();

                    long startTime = info.getGcInfo().getStartTime();
                    long duration = info.getGcInfo().getDuration();
                    if (gcAction.equals("end of major GC")) {
                        oldCounter.incrementAndGet();
                        oldTimeCounter.addAndGet((double) duration/1000);
                    }
                    if (gcAction.equals("end of minor GC")) {
                        youngCounter.incrementAndGet();
                        youngTimeCounter.addAndGet((double) duration/1000);
                    }
                    System.out.println("start:" + startTime + " Name:" + gcName + ", action:" + gcAction + ", gcCause:" + gcCause + "(" + duration + " ms)");
                    logger.info("start:" + startTime + ", action:" + gcAction + ", gcCause:" + gcCause + "(" + duration + " ms)");
                    logger.info("Количество событий 'end of minor GC': "+ youngCounter+
                                    "   События 'minor Gc' выполнялись  "+youngTimeCounter+"  секунд;"+
                                    "    Количество событий 'end of major GC':  "+ oldCounter+
                                    "   События 'major Gc' выполнялись  "+oldTimeCounter+"  секунд");
                }
            };
            emitter.addNotificationListener(listener, null, null);
        }
    }
}