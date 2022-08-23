package Integrate;

import service.StudentDeleteService;
import service.StudentInsertService;
import service.StudentSelectService;
import service.StudentUpdateService;

import java.sql.SQLException;
import java.util.Scanner;

public class Run {
    static Scanner scanner = new Scanner(System.in);

    public static void insert() {
        System.out.println("依次输入学生的：姓名，年龄，性别（表示0/1）。每项输入完成按回车结束 ");
        StudentInsertService.insertInto(scanner.next(), scanner.nextByte(), scanner.nextByte());

    }

    public static void deleteByPkId() {
        System.out.println("输入要删除的主键ID");
        StudentDeleteService.deleteByPkId(scanner.nextLong());

    }

    public static void deleteAll() {
        System.out.println("注意！这是一件不可逆的操作，确定清空，输入：110,输入其他数字返回上层");
        int cod = scanner.nextInt();
        switch (cod) {
            case 110:
                StudentDeleteService.deleteAll();
                break;
            default:
                break;
        }
    }

    public static void UpdateById() {
        System.out.println("依次输入要修改条目的：名字->年龄->性别->主键ID");
        System.out.println("主键ID必须输入\nA全部修改\nB可单独修改姓名\nC可单独修改年龄+性别\nD可单独修改性别");
        System.out.println("Z返回菜单");
        switch (scanner.next()) {
            case "A":
                StudentUpdateService.updateByPkId(scanner.next(), scanner.nextByte(), scanner.nextByte(), scanner.nextLong());
                break;

            case "B":
                StudentUpdateService.updateByPkId(scanner.next(), scanner.nextLong());
                break;

            case "C":
                StudentUpdateService.updateByPkId(scanner.nextByte(), scanner.nextByte(), scanner.nextLong());
                break;

            case "D":
                StudentUpdateService.updateByPkId(scanner.nextByte(), scanner.nextLong());
                break;
            case "Z":
                break;
        }
    }

    public static void select() throws SQLException {
        StudentSelectService.selectAllStudent();
    }

    public static int runApplication() {
        System.out.println("请输入编号选功能\n听话好好输入编号否则直接退出");
        int i = 0;
        try {
            i = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("你就不听话是吧!BYE~BYE");
            System.exit(0);
        }
        return i;
    }


}
