public class Student {
    // 对应students表的字段
    private Integer id;          // 学生ID
    private String name;         // 姓名
    private String gender;       // 性别
    private String className;    // 班级（避免与Java关键字class重名，命名为className）
    private Double mathScore;    // 高数成绩
    private Double javaScore;    // Java成绩


    // 在Student类中补充setId方法
    public void setId(Integer id) {
        this.id = id;
    }
    // id的get方法（通常ID由数据库自增，可不提供set方法）
    public Integer getId() {
        return id;
    }

    // name的set和get方法
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    // gender的set和get方法
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getGender() {
        return gender;
    }

    // className的set和get方法
    public void setClassName(String className) {
        this.className = className;
    }
    public String getClassName() {
        return className;
    }

    // mathScore的set和get方法
    public void setMathScore(Double mathScore) {
        this.mathScore = mathScore;
    }
    public Double getMathScore() {
        return mathScore;
    }

    // javaScore的set和get方法
    public void setJavaScore(Double javaScore) {
        this.javaScore = javaScore;
    }
    public Double getJavaScore() {
        return javaScore;
    }
}