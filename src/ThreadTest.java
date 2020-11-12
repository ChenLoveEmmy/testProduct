import tickets.ThreadTickets;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Alan.chen
 * @ClassName ThreadTest
 * @Description  Thread开放进程
 * @date 2020-06-22 13:27
 */
public class ThreadTest {

    public static void main(String[] args) {

        System.out.println("主进程==》" + Thread.currentThread().getName());
        TextThread tt = new TextThread(10);
        for (int i = 0; i < 3; i++) {
            Thread t1 = new Thread(tt, "thread-"+ i);
            t1.start();
        }

        ThreadTickets threadTickets = new ThreadTickets(10);
        new Thread(threadTickets, "窗口A").start();
        new Thread(threadTickets, "窗口B").start();

    }


    static class TextThread extends Thread {

        private int i = 3;

        public TextThread(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            DateFormat df = new SimpleDateFormat("HH:mm:ss SSS");
            if (!(i > 0)) {
                System.out.println(df.format(new Date()) + " => " + "finish");
                return;
            }
            while (i != 0) {
                gotos();
            }
        }

        private synchronized void gotos() {
            DateFormat df = new SimpleDateFormat("HH:mm:ss SSS");
            if (!(i > 0)) {
                System.out.println(df.format(new Date()) + " => " + "finish");
                return;
            }
            System.out.println(df.format(new Date()) + " => " + Thread.currentThread().getName() + "==> i: " + i--);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
