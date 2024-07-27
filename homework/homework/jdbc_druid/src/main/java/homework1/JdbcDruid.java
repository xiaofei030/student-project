package homework1;


import java.sql.*;

/**
 * @Project: PACKAGE_NAME
 * @Author: pgthinker
 * @GitHub: https://github.com/ningning0111
 * @Date: 2024/6/9 19:12
 * @Description:
 */
public class JdbcDruid {

    private static Connection connection;
    static {
        try {
            connection = DruidConnection.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        long currTime = System.currentTimeMillis();
        User newUser = new User(10L,"10096","123123","STUDENT",new java.util.Date(currTime), new java.util.Date(currTime));
        insertTest(newUser);
        User storeUser = selectTest(newUser.getPhone());
        updateTest(storeUser);
        deleteTest(storeUser.getId());

    }

    private static void insertTest(User user){
        String sql = "INSERT INTO sys_user VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,user.getId());
            preparedStatement.setString(2,user.getPhone());
            preparedStatement.setString(3,user.getPassword());
            preparedStatement.setString(4,user.getRole());
            preparedStatement.setDate(5, new Date(user.getUpdateTime().getTime()));
            preparedStatement.setDate(6,new Date(user.getCreateTime().getTime()));
            int cnt = preparedStatement.executeUpdate();
            System.out.println("成功插入 " + cnt + " 条数据。");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void deleteTest(Long id){
        String sql = "DELETE FROM sys_user WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            int cnt = preparedStatement.executeUpdate();
            System.out.println("成功删除 " + cnt + " 条数据。");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void updateTest(User user){
        String sql = "UPDATE sys_user SET phone=?, password=?, role=?, update_time=?, create_time=? WHERE id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getPhone());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getRole());
            preparedStatement.setDate(4, new Date(user.getUpdateTime().getTime()));
            preparedStatement.setDate(5, new Date(user.getCreateTime().getTime()));
            preparedStatement.setLong(6, user.getId());
            int cnt = preparedStatement.executeUpdate();
            System.out.println("成功更新 " + cnt + " 条数据。");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static User selectTest(String phone){
        String sql = "SELECT * FROM sys_user where phone = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, phone);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                long id = resultSet.getLong("id");
                String userPhone = resultSet.getString("phone");
                String userPassword = resultSet.getString("password");
                String userRole = resultSet.getString("role");

                Date updateTime = resultSet.getDate(5);
                Date createTime = resultSet.getDate(6);

                User user = new User(id, userPhone, userPassword, userRole, updateTime, createTime);
                return user;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


}
