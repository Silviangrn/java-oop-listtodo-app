package todolist.usecases;

import com.zaxxer.hikari.HikariDataSource;

import todolist.entities.UserEntity;
import todolist.models.LoginModel;
import todolist.utils.DBConnectionUtil;

public class LoginUsecase {
    private HikariDataSource dataSource;

    private LoginModel loginModel;

    public LoginUsecase () {
        dataSource = DBConnectionUtil.getDataSource();
        loginModel = new LoginModel(dataSource);
    }

    public String LoginValidate(String userid, String password) {
        //validasi inputan tidak boleh kosong 
        if (userid.equals("") || password.equals("")) {
            return "userid and password cannot be empty!";
        }

        UserEntity user = new UserEntity();
        user.setUserid(userid);
        user.setPassword(password);

        //Validasi user exist pada DB
        if (!loginModel.CheckUserExists(user.getUserid())){
            return "Userid is not exists, please try again.";
        }

        //Validasi userid & password valid 
        if (!loginModel.UserPasswordValid(user)) {
            return "userid and password is not valid, please try again";
        }

        return "";
    }
}
