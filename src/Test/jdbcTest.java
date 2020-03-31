package Test;

import java.sql.*;

public class jdbcTest {
    public static void main(String[] args) {
        //连接对象
        Connection connection = null;
        //查询对象
        PreparedStatement preparedStatement = null;
        //结果集
        ResultSet resultset = null;

        try {
            //加载数据库驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取连接
            connection = DriverManager.getConnection("jdbc:mysql://192.168.1.112:3306/pigletter?serverTimezone=GMT%2b8","root","maojiawei1");
            //获取statement
            String msql = "SELECT * FROM employees where salary>10000";
            preparedStatement = connection.prepareStatement(msql);
            //查询、输出结果
            resultset = preparedStatement.executeQuery();

            while(resultset.next()){
                System.out.println(resultset.getString("first_name")+"\t"+
                        resultset.getString("last_name")+"\t"+
                        resultset.getString("salary"));
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            if(resultset!=null){
                try {
                    resultset.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(preparedStatement!=null){
                try {
                    resultset.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection!=null){
                try {
                    resultset.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
