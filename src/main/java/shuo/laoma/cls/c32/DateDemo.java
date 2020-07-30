package shuo.laoma.cls.c32;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateDemo {
    private void timezone() {
        TimeZone tz = TimeZone.getDefault();
        System.out.println(tz.getID());
        System.out.println(System.getProperty("user.timezone"));
        TimeZone tz2 = TimeZone.getTimeZone("GMT+08:00");
        System.out.println(tz2.getID());
    }

    private void locale() {
        Locale locale = Locale.getDefault();
        System.out.println(locale.toString());
    }

    private void calendar() {
        Calendar calendar = Calendar.getInstance();
        System.out.println("year: " + calendar.get(Calendar.YEAR));
        System.out.println("month: " + calendar.get(Calendar.MONTH));
        System.out.println("day: " + calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("hour: " + calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println("minute: " + calendar.get(Calendar.MINUTE));
        System.out.println("second: " + calendar.get(Calendar.SECOND));
        System.out.println("millisecond: " + calendar.get(Calendar.MILLISECOND));
        System.out.println("day_of_week: " + calendar.get(Calendar.DAY_OF_WEEK));
    }

    private void dateformat() {
        // 默认是东八区的日历
        Calendar calendar = Calendar.getInstance();
        //2016-08-15 14:15:20
        calendar.set(2016, 07, 15, 14, 15, 20);
        System.out.println(DateFormat.getDateTimeInstance().getClass().getName());
        System.out.println(DateFormat.getDateInstance().getClass().getName());
        System.out.println(DateFormat.getTimeInstance().getClass().getName());
        System.out.println(DateFormat.getDateTimeInstance()
                .format(calendar.getTime()));
        System.out.println(DateFormat.getDateInstance()
                .format(calendar.getTime()));
        System.out.println(DateFormat.getTimeInstance()
                .format(calendar.getTime()));
        DateFormat df = DateFormat.getDateTimeInstance(
                DateFormat.LONG, DateFormat.SHORT, Locale.TAIWAN);
        df.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
        System.out.println(df.format(calendar.getTime()));
    }

    private void simpleDateFormat() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016, 07, 15, 14, 15, 20);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年'MM'月dd日 E HH时mm分ss秒");
        System.out.println(sdf.format(calendar.getTime()));
    }

    private void parse() {
        String str = "2016-08-15 14:15:20.456";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        try {
            Date date = sdf.parse(str);
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年M月d日 h:m:s.S a");
            System.out.println(sdf2.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        DateDemo dd = new DateDemo();
        dd.timezone();
        dd.locale();
        dd.calendar();
        dd.dateformat();
        dd.simpleDateFormat();
        dd.parse();
    }
}
