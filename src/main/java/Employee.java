import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


public class Employee {
    private int employeeId;
    private String name;
    private int sex;
    private LocalDateTime times;
    //Timestamp 是舊的 可以提供精確的毫秒 但是不包含時區 預設為 +0或根據JVM及資料庫設定 需要自己設定
    //LocalDateTime 是新的 可以可以提供精確的毫秒 不涉及時區純粹的本地時間(根據系統)
    //可以使用LocalDateTime 映射資料庫Timestamp 欄位
    //localDate Date
    //實務上用這個就好 不要使用帶參數的建構子 因為要考慮靈活度、配合
    public Employee() {
    }

//    public Employee(int employeeId, String name, int sex, Timestamp times) {
//        this.employeeId = employeeId;
//        this.name = name;
//        this.sex = sex;
//        this.times = times;
//    }
    public Employee( String name, int sex) {
        this.name = name;
        this.sex = sex;

    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public LocalDateTime getTimes() {
        return times;
    }
    // 新增接受 LocalDateTime 參數的方法 因為要配合查詢 查詢到的物件轉成
    public void setTimes(LocalDateTime times) {
        //truncatedTo(ChronoUnit.SECONDS) 截斷 截到秒數
        this.times = times.truncatedTo(ChronoUnit.SECONDS);
    }
    //設置當前時間
    public void setTimes() {
        this.times = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", times=" + times +
                '}';
    }
}
