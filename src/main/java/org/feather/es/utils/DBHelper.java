package org.feather.es.utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @projectName: elasticsearch-job
 * @package: org.feather.es.utils
 * @className: DBHeper
 * @author: feather(杜雪松)
 * @description: TODO
 * @since: 2022/9/6 21:18
 * @version: 1.0
 */
public class DBHelper {
    public static final String url = "jdbc:mysql://localhost:3306/lagou_position?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai";
    public static final String name = "com.mysql.cj.jdbc.Driver";
    public static final String user = "root";
    public static final String password = "root";
    private  static Connection  connection = null;

    public  static Connection getConn(){
        try {
            Class.forName(name);
            connection = DriverManager.getConnection(url,user,password);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  connection;
    }
}

