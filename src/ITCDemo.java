class Item {
    public int value;
    public boolean valset = false;

    public synchronized void setItem(int i) {
        try {
            if (valset) {
                wait(); // Wait if value is already set
            }
            value = i;
            System.out.println("Producer Thread produced -> " + value);
            valset = true;
            notify(); // Notify consumer
        } catch (Exception |InterruptedException  e) {
            e.printStackTrace();
        }
    }

    public synchronized void getItem() {
        try {
            if (!valset) {
                wait(); // Wait if value is not yet set
            }
            System.out.println("Consumer Thread consumed -> " + value);
            valset = false;
            notify(); // Notify producer
        } catch (Exception |InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Producer implements Runnable {
    private Item item;
    private int i = 0;

    public Producer(Item item) {
        this.item = item;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(1000);
                item.setItem(i++);
            }
        } catch (Exception |InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable {
    private Item item;

    public Consumer(Item item) {
        this.item = item;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(1000);
                item.getItem();
            }
        } catch (Exception |InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ITCDemo {
    public static void main(String[] args) {
        Item item = new Item();
        Thread prod = new Thread(new Producer(item));
        Thread con = new Thread(new Consumer(item));

        prod.start();
        con.start();
    }
}