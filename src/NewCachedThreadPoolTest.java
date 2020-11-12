import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Alan.chen
 * @ClassName NewCachedThreadPoolTest
 * @Description  可缓存线程池
 * @date 2020-07-27 14:09
 */
public class NewCachedThreadPoolTest {

    public static void main(String[] args) {
        // 创建一个可缓存线程池
        // ExecutorService是Java提供的用于管理线程池的类。该类的两个作用：控制线程数量和重用线程
        // Executors.newCacheThreadPool()：可缓存线程池，先查看池中有没有以前建立的线程，
        // 如果有，就直接使用。如果没有，就建一个新的线程加入池中，缓存型池子通常用于执行一些生存期很短的异步型任务
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 50; i++) {
            try {
                // sleep可明显看到使用的是线程池里面以前的线程，没有创建新的线程
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cachedThreadPool.execute(new Runnable() {
                public void run() {
                    // 打印正在执行的缓存线程信息
                    System.out.println(Thread.currentThread().getName()
                            + "正在被执行");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
