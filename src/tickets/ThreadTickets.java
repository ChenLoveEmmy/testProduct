package tickets;

/**
 * @author Alan.chen
 * @ClassName ThradTickets
 * @Description
 * @date 2020-07-27 14:41
 */
public class ThreadTickets extends Thread {

    public ThreadTickets(int total) {
        this.total = total;
    }

    public ThreadTickets() {

    }

    private int total; //总票数

    private int sold = 0; //卖出数

    public void run() {

        while (sold < total) {
            sendTicket(total);
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "==> 车票已售罄！");

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
