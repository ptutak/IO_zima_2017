package io2017.pierogimroku.task.storage;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import io2017.pierogimroku.task.api.TaskLook;
import io2017.pierogimroku.task.storage.entity.Task;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/*
 * Created by Pierogi Mroku, IO WIMiIP AGH 2017
 */

public class QueryManager {
    private final String databaseUrl;
    private final ConnectionSource connectionSource;
    private final Dao<Task, String> taskDao;

    public QueryManager(String dbName) throws SQLException {
        databaseUrl = "jdbc:sqlite:"+dbName;
        this.connectionSource = new JdbcConnectionSource(databaseUrl);
        taskDao = DaoManager.createDao(connectionSource, Task.class);
        TableUtils.createTableIfNotExists(connectionSource, Task.class);
    }

    public List<Task> searchTask(TaskLook taskLook) throws SQLException, IOException {
        Where<Task,String> query=null;
        if (taskLook.getId()!=null){
            query=taskDao.queryBuilder().where().eq(Task.ID,taskLook.getId());
        }
        if (taskLook.getName()!=null){
            query.and().eq(Task.NAME,taskLook.getName());
        }
        if (taskLook.getDescription()!=null){
            query.and().eq(Task.DESCRIPTION,taskLook.getDescription());
        }
        if (taskLook.getAssignedId()!=null){
            query.and().eq(Task.ASSIGNEDID,taskLook.getAssignedId());
        }
        if (taskLook.getOwnerId()!=null){
            query.and().eq(Task.OWNERID,taskLook.getOwnerId());
        }
        if (taskLook.getPriority()!=null){
            query.and().eq(Task.PRIORITY,taskLook.getPriority());
        }
        if (taskLook.getStartDate()!=null){
            query.and().eq(Task.STARTDATE,taskLook.getStartDate());
        }
        if (taskLook.getStatus()!=null){
            query.and().eq(Task.STATUS,taskLook.getStatus());
        }
        if (taskLook.getTimeEstimate()!=null){
            query.and().eq(Task.TIMEESTIMATE,taskLook.getTimeEstimate());
        }
        return taskDao.query(query.prepare());

    }


    public List<Task> searchTaskByAssignedEmployee(Integer emplyeeId) throws SQLException, IOException {
        List<Task> tmpList =
                taskDao.query(
                        taskDao.queryBuilder().where()
                                .eq(Task.ASSIGNEDID, emplyeeId)
                                .prepare());
        return tmpList;
    }

    public List<Task> searchTaskByOwnerEmployee(Integer emplyeeId) throws SQLException, IOException {
        List<Task> tmpList =
                taskDao.query(
                        taskDao.queryBuilder().where()
                                .eq(Task.OWNERID, emplyeeId)
                                .prepare());
        return tmpList;
    }

    public List<Task> getAll() throws SQLException, IOException {
        List<Task> tmpList = taskDao.queryForAll();
        return tmpList;
    }

    public List<Task> search(String tmp) throws SQLException, IOException {
        String tmpWord;
        int value;
        List<Task> tmpList = taskDao.queryForAll();
        List<Task> tmpList2 = new LinkedList<>();
        for(Task el : tmpList){
            tmpWord = el.getId().toString();
            value = tmpWord.indexOf(tmp);
            if(value >= 0){
                tmpList2.add(el);
                continue;
            }
            tmpWord = el.getName();
            value = tmpWord.indexOf(tmp);
            if(value >= 0){
                tmpList2.add(el);
                continue;
            }
            tmpWord = el.getDescription();
            value = tmpWord.indexOf(tmp);
            if(value >= 0){
                tmpList2.add(el);
                continue;
            }
            tmpWord = el.getOwnerId().toString();
            value = tmpWord.indexOf(tmp);
            if(value >= 0){
                tmpList2.add(el);
                continue;
            }
            tmpWord = el.getAssignedId().toString();
            value = tmpWord.indexOf(tmp);
            if(value >= 0){
                tmpList2.add(el);
                continue;
            }
            tmpWord = el.getTimeEstimate().toString();
            value = tmpWord.indexOf(tmp);
            if(value >= 0){
                tmpList2.add(el);
                continue;
            }
            tmpWord = el.getStartDate().toString();
            value = tmpWord.indexOf(tmp);
            if(value >= 0){
                tmpList2.add(el);
                continue;
            }
            tmpWord = el.getStatus().toString();
            value = tmpWord.indexOf(tmp);
            if(value >= 0){
                tmpList2.add(el);
                continue;
            }
        }
        return tmpList;
    }

    public Integer addTask(Task task) throws SQLException, IOException {
        taskDao.create(task);
        return task.getId();
    }

    public void removeTask(Task task) throws SQLException, IOException {
        taskDao.delete(task);
    }

    public void editTask(Task task) throws SQLException, IOException {
        taskDao.update(task);
    }

    public void assignToTask(Task task) throws SQLException, IOException{
        //TODO
        throw new RuntimeException("Not supported yet");
    }

    @Override
    public void finalize(){
        try {
            connectionSource.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
