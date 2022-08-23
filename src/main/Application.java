package main;


import Integrate.Run;
/**
 * 要优化的细节：
 * 插入的数值需要限制
 * 研究如何才能返回上层（选择功能时可退可进） ok
 * 研究如何实现 插入时间，更新时间  ok
 * 拓展增删改查内容
 * 加入其他表元素
 * 实现表内元素导出文件
 * 尝试多线程
 */

import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws SQLException {
        init();
    }

    public static void init() {
        while (true) {
            System.out.println("---------WellCome Student Management System---------");
            System.out.println("1.曾");
            System.out.println("2.删");
            System.out.println("3.改");
            System.out.println("4.查");
            System.out.println("5.清空");
            System.out.println("0.退出");
            int i = Run.runApplication();
            if (i > 0 && i <= 5) {

                switch (i) {
                    case 1:
                        Run.insert();
                        break;

                    case 2:
                        Run.deleteByPkId();
                        break;
                    case 3:
                        Run.UpdateById();
                        break;
                    case 4:
                        try {
                            Run.select();
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                        break;

                    case 5:
                        Run.deleteAll();
                        break;

                    default:
                        System.exit(0);
                        break;
                }
            } else {
                System.exit(0);
            }
        }
    }
}
