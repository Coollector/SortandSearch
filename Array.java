import java.util.Arrays;

public class Array {
    public int[] arr;
    private final LZM lzm;
    public Ausgabe loopsAusgabe;
    public Ausgabe execTimeAusgabe;
    public Array(Ausgabe loopsAusgabe, Ausgabe execTimeAusgabe){
        this.lzm = new LZM();
        this.loopsAusgabe = loopsAusgabe;
        this.execTimeAusgabe = execTimeAusgabe;
    }

    public void generate(int len){
        this.arr = new int[len];
        for (int i = 0; i < len; i++) {
            this.arr[i] = (int) (Math.random() * 100000);
        }
    }

    public String toString(){
        String[] stringArray = new String[this.arr.length];
        for (int i = 0; i < this.arr.length; i++) {
            stringArray[i] = (i+1) + ".\t" + this.arr[i];
        }
        return String.join("\n", stringArray);
    }

    public void bubbleSort(){
        this.lzm.start();
        for (int i = 0; i < this.arr.length - 1; i++) {
            for (int j = 0; j < this.arr.length - i - 1; j++) {
                this.lzm.loops += 1;
                if (this.arr[j] > arr[j+1]){
                    int current = this.arr[j];
                    this.arr[j] = this.arr[j+1];
                    this.arr[j+1] = current;
                }
            }
        }
        this.lzm.stop();
        this.loopsAusgabe.setText(this.lzm.loops + "");
        this.execTimeAusgabe.setText(this.lzm.execTime + "");
    }

    public void insertionSort() {
        this.lzm.start();
        for (int i = 1; i < this.arr.length-1; i++) {
            int pos = i-1;
            int current = this.arr[i];
            while ((pos >= 0) && (this.arr[pos] > current)){
                this.lzm.loops += 1;
                this.arr[pos+1] = this.arr[pos];
                pos--;
            }
            this.arr[pos+1] = current;
        }
        this.lzm.stop();
        this.loopsAusgabe.setText(this.lzm.loops + "");
        this.execTimeAusgabe.setText(this.lzm.execTime + "");
    }

    public void shellSort() {
        this.lzm.start();
        for (int gap = this.arr.length/2; gap > 0; gap /= 2){
            for (int i = gap; i < this.arr.length; i++) {
                int current = this.arr[i];
                int pos;
                for (pos = i; pos >= gap && this.arr[pos-gap] > current; pos -= gap){
                    this.lzm.loops += 1;
                    this.arr[pos] = this.arr[pos-gap];
                }
                this.arr[pos] = current;
            }
        }
        this.lzm.stop();
        this.loopsAusgabe.setText(this.lzm.loops + "");
        this.execTimeAusgabe.setText(this.lzm.execTime + "");
    }

    private int binarySearch(int[] arr, int start, int input, int section) {
        this.lzm.loops += 1;
        if (section >= start) {
            int mid = start + (section - start) / 2;
            if (arr[mid] == input)
                return mid;
            if (arr[mid] > input)
                return binarySearch(arr, start, input, mid-1);
            return binarySearch(arr, mid+1, input, section);
        }
        return -1;
    }
    public String binarySearch(int input) {
        int[] temp = Arrays.copyOf(this.arr, this.arr.length);
        this.shellSort();
        int[] arr = Arrays.copyOf(this.arr, this.arr.length);
        this.arr = Arrays.copyOf(temp, this.arr.length);
        this.lzm.start();
        int result = this.binarySearch(arr, 0, input, arr.length-1);
        this.lzm.stop();
        this.loopsAusgabe.setText(this.lzm.loops + "");
        this.execTimeAusgabe.setText(this.lzm.execTime + "");
        if (result == -1)
            return "Not Found";
        for (int i = 0; i < this.arr.length; i++){
            if (this.arr[i] == arr[result])
                return String.valueOf(i+1);
        }
        return "error";
    }

    public String linearSearch(int input) {
        for (int i = 0; i < this.arr.length; i++){
            if (this.arr[i] == input)
                return String.valueOf(i+1);
        }
        return "Not Found";
    }
}
