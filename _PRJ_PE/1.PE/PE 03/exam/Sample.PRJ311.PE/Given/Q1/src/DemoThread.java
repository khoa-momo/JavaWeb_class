
import java.util.logging.Level;
import java.util.logging.Logger;

public class DemoThread extends Thread {

    //Các công việc cần thực thi thì ném vào Run
    String name;

    public DemoThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(name);
            try {
                //nghỉ để cho CPU thực hiện việc khác
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(DemoThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public static void main(String[] args) {
        //Tạo ra đối tượng có khă năng chạy song song

        DemoThread t1 = new DemoThread("t1");
        DemoThread t2 = new DemoThread("t2");

        //Cách chạy một thread bình thường : start
        t1.start();
        t2.start();

        //Cách dừng một thread
    }

}
