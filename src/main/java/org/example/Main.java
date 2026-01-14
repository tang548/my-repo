import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager();
        Scanner scanner = new Scanner(System.in);
        String command;

        // 显示操作菜单
        System.out.println("=== 学生管理系统 ===");
        System.out.println("支持的命令：");
        System.out.println("1. add：添加学生信息");
        System.out.println("2. query [id]：根据ID查询学生");
        System.out.println("3. list：显示所有学生信息");
        System.out.println("4. avg：计算各科平均分");
        System.out.println("5. exit：退出系统");
        System.out.println("====================");

        // 循环处理用户命令
        while (true) {
            System.out.print("\n请输入命令：");
            command = scanner.nextLine().trim();

            if (command.equals("exit")) {
                System.out.println("系统已退出");
                break;
            } else if (command.equals("add")) {
                // 处理添加学生
                Student student = new Student();
                System.out.print("请输入姓名：");
                student.setName(scanner.nextLine());
                System.out.print("请输入性别：");
                student.setGender(scanner.nextLine());
                System.out.print("请输入班级：");
                student.setClassName(scanner.nextLine());
                System.out.print("请输入高数成绩：");
                student.setMathScore(Double.parseDouble(scanner.nextLine()));
                System.out.print("请输入Java成绩：");
                student.setJavaScore(Double.parseDouble(scanner.nextLine()));

                if (studentManager.addStudent(student)) {
                    System.out.println("添加成功");
                } else {
                    System.out.println("添加失败");
                }
            } else if (command.startsWith("query ")) {
                // 处理ID查询（格式：query 1）
                try {
                    int id = Integer.parseInt(command.split(" ")[1]);
                    Student student = studentManager.queryStudentById(id);
                    if (student != null) {
                        System.out.println("查询结果：");
                        System.out.println("ID：" + student.getId() + "，姓名：" + student.getName() + "，性别：" + student.getGender() +
                                "，班级：" + student.getClassName() + "，高数：" + student.getMathScore() + "，Java：" + student.getJavaScore());
                    } else {
                        System.out.println("未找到该ID的学生");
                    }
                } catch (Exception e) {
                    System.out.println("命令格式错误，正确格式：query [学生ID]");
                }
            } else if (command.equals("list")) {
                // 处理显示所有学生
                List<Student> studentList = studentManager.queryAllStudents();
                if (studentList.isEmpty()) {
                    System.out.println("暂无学生信息");
                } else {
                    System.out.println("所有学生信息：");
                    for (Student s : studentList) {
                        System.out.println("ID：" + s.getId() + "，姓名：" + s.getName() + "，性别：" + s.getGender() +
                                "，班级：" + s.getClassName() + "，高数：" + s.getMathScore() + "，Java：" + s.getJavaScore());
                    }
                }
            } else if (command.equals("avg")) {
                // 处理计算平均分
                studentManager.calculateAverageScores();
            } else {
                System.out.println("未知命令，请重新输入");
            }
        }
        scanner.close();
    }
}