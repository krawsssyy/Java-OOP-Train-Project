package finalJavaProj;

import java.time.Month;
import java.util.Calendar;
import javax.swing.JLabel;

public class Clock {
    Clock(JLabel a){
        Thread1(a);
    }
    public void Thread1(JLabel a) {
        Thread t1 = new Thread() {
            public void run() {
                try {
                    for(;;) {
                        Calendar cal = Calendar.getInstance();
                        int hourVal = cal.get(Calendar.HOUR_OF_DAY);
                        String hour = String.valueOf(hourVal);
                        int minuteVal = cal.get(Calendar.MINUTE);
                        String minute = String.valueOf(minuteVal);
                        int secondVal = cal.get(Calendar.SECOND);
                        String second = String.valueOf(secondVal);
                        int day = cal.get(Calendar.DAY_OF_MONTH);
                        int month = cal.get(Calendar.MONTH);
                        int year = cal.get(Calendar.YEAR);
                        if(hourVal < 10) { 
                        	hour = '0' + hour;
                        }
                        if(minuteVal < 10) { 
                        	minute = '0' + minute;
                        }
                        if(secondVal < 10) { 
                        	second = '0' + second;
                        }
                        a.setText(hour + ":" + minute + ":" + second + "    " + day + " " + Month.of(month+1).name() + " " + year);
                        sleep(1000);
                    }
                } catch (InterruptedException e) {
                    System.out.println("Exception occured while getting the time");
                } 
            }
        };t1.start();
    }
}