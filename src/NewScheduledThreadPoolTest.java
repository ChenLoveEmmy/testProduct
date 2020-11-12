import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Alan.chen
 * @ClassName NewScheduledThreadPoolTest
 * @Description  延迟定时执行线程
 * @date 2020-07-27 14:31
 */
public class NewScheduledThreadPoolTest {

    public static void main(String[] args) {
        DateFormat df = new SimpleDateFormat("HH:mm:ss SSS");
        //创建一个定长线程池，支持定时及周期性任务执行——延迟执行
        // Executors.newScheduledThreadPool(int n)：创建一个定长线程池，支持定时及周期性任务执行
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        System.out.println("开始时间：" + df.format(new Date()) );
        //延迟1秒执行
        scheduledThreadPool.schedule(new Runnable() {
            public void run() {
                System.out.println(df.format(new Date())+ Thread.currentThread().getName() + "延迟1秒执行");
            }
        }, 1, TimeUnit.SECONDS);


        //延迟1秒后每3秒执行一次
        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            public void run() {
                System.out.println(df.format(new Date())+Thread.currentThread().getName() + "延迟1秒后每3秒执行一次");
            }
        }, 1, 2, TimeUnit.SECONDS);

    }
}
