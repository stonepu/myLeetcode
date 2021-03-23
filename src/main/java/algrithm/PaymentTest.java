package algrithm;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

//评测题目一：
// A公司的收费方案：
// 1、所有电话分为白天电话和晚上电话。
// 2、白天是从早晨7点到晚上7点，剩下的时间算晚上。
// 3、白天费用：第1分钟5毛，接下来每分钟1毛。
// 4、晚上费用：第1分钟3毛，接下来10分钟总共收1元，其余每分钟1毛。
// 要求：
// 1、完成该需求的设计和实现；
// 2、考虑一定的扩展性；
// 提示：非算法题目。
public class PaymentTest {


}

interface PaymentStrategy{
    int getPayment(long min);
}

class DayPayment implements PaymentStrategy{

    public void setFirstUnitPay(int firstUnitPay) {
        this.firstUnitPay = firstUnitPay;
    }

    public void setUnitPay(int unitPay) {
        this.unitPay = unitPay;
    }

    private int firstUnitPay = 5;

    private int unitPay = 1;

    @Override
    public int getPayment(long min) {
        if(min == 0) {
            return 0;
        }
        int cost = firstUnitPay;
        cost += (min - 1) * unitPay;
        return cost;
    }
}

class NightPayment implements PaymentStrategy {

    private int firstUnitPay = 3;

    private int nextPeriodTime = 10;

    private int nextPeriodCost = 10;

    private int unitPay = 1;


    public void setFirstUnitPay(int firstUnitPay) {
        this.firstUnitPay = firstUnitPay;
    }

    public void setNextPeriodTime(int nextPeriodTime) {
        this.nextPeriodTime = nextPeriodTime;
    }

    public void setNextPeriodCost(int nextPeriodCost) {
        this.nextPeriodCost = nextPeriodCost;
    }

    public void setUnitPay(int unitPay) {
        this.unitPay = unitPay;
    }


    @Override
    public int getPayment(long min) {
        if(min == 0) {
            return 0;
        }
        int cost = firstUnitPay;
        if(min > 1) {
            cost += nextPeriodCost;
        }

        if(min > nextPeriodTime + 1) {
            cost += (min - nextPeriodTime) * unitPay;
        }

        return cost;
    }
}

class MyPayment {


    private DayPayment dayPayment;

    private NightPayment nightPayment;

    public MyPayment() {

        dayPayment = new DayPayment();
        nightPayment = new NightPayment();
    }


    public int getPayment(LocalDateTime start, LocalDateTime end) {
        //拆分白天和晚上的时间
        LocalDateTime dayStart;
        long day = 0, night = 0;
        if(start.isBefore(LocalDateTime.of(start.getYear(), start.getMonth(), start.getDayOfMonth(), 7, 0, 0))){
            dayStart = LocalDateTime.of(start.getYear(), start.getMonth(), start.getDayOfMonth(), 7, 0, 0);
            night += start.until(dayStart, ChronoUnit.MINUTES);
        }else{
            dayStart = start;
        }


        if(end.isBefore(LocalDateTime.of(end.getYear(), end.getMonth(), end.getDayOfMonth(), 19, 0, 0))){
            day += dayStart.until(end, ChronoUnit.MINUTES);

        }else{
            day += dayStart.until(LocalDateTime.of(end.getYear(), end.getMonth(), end.getDayOfMonth(), 19, 0, 0), ChronoUnit.MINUTES);
            night += LocalDateTime.of(end.getYear(), end.getMonth(), end.getDayOfMonth(), 19, 0, 0).until(end, ChronoUnit.MINUTES);
        }

        return dayPayment.getPayment(day) + nightPayment.getPayment(night);
    }

    public static void main(String[] args) {

        LocalDateTime start = LocalDateTime.of(2021, 3, 18, 17, 0);
        LocalDateTime end = LocalDateTime.of(2021, 3, 18, 17, 30);

        MyPayment myPayment = new MyPayment();
        System.out.println(myPayment.getPayment(start, end));
    }
}


