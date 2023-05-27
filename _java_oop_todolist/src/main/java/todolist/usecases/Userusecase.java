package todolist.usecases;

import com.mysql.cj.x.protobuf.MysqlxCrud.DataModel;
import com.zaxxer.hikari.HikariDataSource;

import todolist.entities.UserEntity;
import todolist.models.UserModel;
import todolist.utils.DBConnectionUtil;

public class Userusecase {
    private HikariDataSource dataSource;

    private UserModel userModel;

    public Userusecase () {
        dataSource = DBConnectionUtil.getDataSource();
        userModel = new UserModel(dataSource);
    }

    public void AddUser(String userid, String pass) {
        UserEntity userData = new UserEntity();
        userData.setUserid(userid);
    }

}
