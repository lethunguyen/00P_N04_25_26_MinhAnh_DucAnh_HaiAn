package schoolWork.src;

public class Time {
    private int hour;
    private int minute;
    private int second;

    // Constructor mặc định
    public Time() {
        setTime(0, 0, 0);
    }

    // Constructor 1 tham số
    public Time(int h) {
        setTime(h, 0, 0);
    }

    // Constructor 2 tham số
    public Time(int h, int m) {
        setTime(h, m, 0);
    }

    // Constructor 3 tham số
    public Time(int h, int m, int s) {
        setTime(h, m, s);
    }

    // Method để set thời gian
    public void setTime(int h, int m, int s) {
        this.hour = h;
        this.minute = m;
        this.second = s;
    }

    public void checkTime(int h, int m, int s) {
        if(h < 0 || h >24) {
            h = 0;
        }
        else if(m<0 || m>60) {
            m = 0;
        }
        else if(s<0 || s>60) {
            s = 0;
        }

        this.hour = h;
        this.minute = m;
        this.second = s;
    }

    // Method hiển thị giờ
    public void displayTime() {
        System.out.printf("%02d:%02d:%02d\n", hour, minute, second);
    }
}
