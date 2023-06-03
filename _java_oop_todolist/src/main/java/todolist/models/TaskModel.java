package todolist.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.mysql.cj.protocol.Resultset;

import todolist.entities.TaskEntity;

public class TaskModel {
    private DataSource dataSource;

    public TaskModel(DataSource dataSource) {this.dataSource = dataSource;}

    public TaskEntity[] findAllTask(String userid) {
        String sql = "SELECT * FROM task WHERE userid = ?";
        try (
            Connection connection = dataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)
        ){
            stmt.setString(1, userid);
            Resultset resultset = stmt.executeQuery();
            List<TaskEntity> list = new ArrayList<>();
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
