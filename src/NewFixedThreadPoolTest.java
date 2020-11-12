import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Alan.chen
 * @ClassName NewFixedThreadPoolTest
 * @Description  创建固定可重用线程池 结束不自己回收
 * @date 2020-07-27 14:17
 */
public class NewFixedThreadPoolTest {

    public static void main(String[] args) {
        // 创建一个可重用固定个数的线程池
        // Executors.newFixedThreadPool(int n)：创建一个可重用固定个数的线程池，以共享的无界队列方式来运行这些线程。
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        Random r = new Random(4);
        for (int i = 0; i < 20; i++) {
            fixedThreadPool.execute(new Runnable() {
                public void run() {
                    try {
                        // 打印正在执行的缓存线程信息
                        System.out.println(Thread.currentThread().getName()
                                + "正在被执行");
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
