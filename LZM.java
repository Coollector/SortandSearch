public class LZM {
    private long startTime;
    public long execTime;
    public int loops;

    public LZM(){
        this.startTime = 0;
        this.execTime = 0;
        this.loops = 0;
    }

    public void start(){
        this.startTime = System.nanoTime();
        this.loops = 0;
    }

    public void stop() {
        this.execTime = System.nanoTime() - startTime;
    }
}
