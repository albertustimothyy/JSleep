package AlbertusTimothyGunawanJSleepKM;

public class ThreadingObject extends Thread{
    public ThreadingObject(String name) {
        this.setName(name);
        start();
    }

    @Override
    public void run(){
        System.out.println(this.getName() + " is running");
        System.out.println("Id Thread " + this.getId());
    }
}
