import tickets.RunnableTickets;

/**
 * @author Alan.chen
 * @ClassName RunableTest
 * @Description  Runnable开启进程
 * @date 2020-06-22 13:48
 */
public class RunnableTest {

    public static void main(String[] args) {
        System.out.println("主进程==》" + Thread.currentThread().getName());
        RunnableThead rt = new RunnableThead(10);
        for (int i =0; i< 5; i++) {
            new Thread(rt, "窗口"+ i).start();
        }

        RunnableTickets runnableTickets = new RunnableTickets(10);
        new Thread(runnableTickets, "窗口A").start();
        new Thread(runnableTickets, "窗口B").start();
        new Thread(runnableTickets, "窗口C").start();
        new Thread(runnableTickets, "窗口D").start();
    }

    static class RunnableThead implements Runnable {

        private int i = 3;

        public RunnableThead(int i) {
            this.i = i;
        }

        public RunnableThead() {

        }

        @Override
        public void run() {
            if (!(i > 0)) {
                System.out.println(Thread.currentThread().getName() + "==> finish");
                return;
            }

            while (i != 0) {
//                synchronized (String.valueOf(i)) {
                    if (!(i > 0)) {
                        System.out.println(Thread.currentThread().getName() + "finish");
                        return;
                    }
                    System.out.println(Thread.currentThread().getName() + "==> i: " + i--);
                    if (!(i > 0)) {
                        System.out.println(Thread.currentThread().getName() + "finish");
                        return;
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
//                }
            }

        }
    }
}
