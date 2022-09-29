import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class Storage {
    //仓库存储载体
    private LinkedBlockingQueue<Object> List = new LinkedBlockingQueue<>(10);
    public void producer() {
        try {
            List.put(new Object());
            System.out.println(
                    "The Producer Thread [" + Thread.currentThread().getName() + "] has added one successfully."
                            + "\tNow the Storage_Size : " + List.size()
            );
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }
    public void consumer() {
        try {
            List.take();
            System.out.println(
                    "The Consumer Thread [" + Thread.currentThread().getName() + "] has removed one successfully."
                            + "\tNow the Storage_Size : " + List.size()
            );
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }
}
