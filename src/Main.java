/**
 * BlockingQueue 是 JDK5.0 的新增内容，
 * 它是一个已经在内部实现了同步的队列，实现方式采用的是我们第 2 种 await() / signal() 方法。
 * 它可以在生成对象时指定容量大小，用于阻塞操作的是 put() 和 take() 方法。
 **/
public class Main {
    public static void main(String[] args) {
        Storage storage = new Storage();
        Thread producer01 = new Thread(new Producer(storage));
        Thread producer02 = new Thread(new Producer(storage));
        Thread producer03 = new Thread(new Producer(storage));

        Thread consumer01 = new Thread(new Consumer(storage));
        Thread consumer02 = new Thread(new Consumer(storage));
        Thread consumer03 = new Thread(new Consumer(storage));

        producer01.setName("producer01");
        producer02.setName("producer02");
        producer03.setName("producer03");
        consumer01.setName("consumer01");
        consumer02.setName("consumer02");
        consumer03.setName("consumer03");

        producer01.start();
        producer02.start();
        producer03.start();
        consumer01.start();
        consumer02.start();
        consumer03.start();
    }
}