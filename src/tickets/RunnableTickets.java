package tickets;

import com.sun.deploy.util.StringUtils;

/**
 * @author Alan.chen
 * @ClassName RunableTickets
 * @Description
 * @date 2020-07-27 13:26
 */
public class RunnableTickets implements Runnable {

    private int total;  //总票数

    private int sold = 0; //已卖出票

    public RunnableTickets(int total) {
        this.total = total;
    }

    public RunnableTickets() {

    }

    @Override
    public void run() {

        while (true) {
            if (sold >= total) {
                System.out.println(Thread.currentThread().getName() + "==> 车票已售罄!");
                return;
            }
            sendTicket(total);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized int sendTicket(int total) {
        if (sold < total) {
//            total -= 1;
            sold += 1;
            System.out.println(Thread.currentThread().getName() + "==> 已卖出: NO. " + String.format("%5d", sold).replace(" ", "0"));
            return total;
        } else {
            System.out.println(Thread.currentThread().getName() + "==> 余票不足");
            return total;
        }

    }
}
