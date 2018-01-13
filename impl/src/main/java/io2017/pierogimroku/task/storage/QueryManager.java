package io2017.pierogimroku.task.storage;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
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
    private final Dao<Task, Integer> taskDao;

    public QueryManager(String dbName) throws SQLException {
        databaseUrl = "jdbc:sqlite:"+dbName;
        this.connectionSource = new JdbcConnectionSource(databaseUrl);
        taskDao = DaoManager.createDao(connectionSource, Task.class);
        TableUtils.createTableIfNotExists(connectionSource, Task.class);
    }

    public List<Task> searchTask(TaskLook taskLook) throws SQLException, IOException {
        Where<Task,Integer> query=taskDao.queryBuilder().where();
        boolean eqDone=false;

        if (taskLook.getId()!=null){
            query.eq(Task.ID,taskLook.getId());
        } else {
            if (taskLook.getName() != null) {
                query.eq(Task.NAME, taskLook.getName());
                eqDone = true;
            }
            if (taskLook.getDescription() != null) {
                if (eqDone) {
                    query.and().eq(Task.DESCRIPTION, taskLook.getDescription());
                } else {
                    query.eq(Task.DESCRIPTION, taskLook.getDescription());
                    eqDone = true;
                }
            }
            if (taskLook.getAssignedId() != null) {
                if (eqDone) {
                    query.and().eq(Task.ASSIGNEDID, taskLook.getAssignedId());
                } else {
                    query.eq(Task.ASSIGNEDID, taskLook.getAssignedId());
                    eqDone = true;
                }
            }
            if (taskLook.getOwnerId() != null) {
                if (eqDone) {
                    query.and().eq(Task.OWNERID, taskLook.getOwnerId());
                } else {
                    query.eq(Task.OWNERID, taskLook.getOwnerId());
                    eqDone = true;
                }
            }
            if (taskLook.getPriority() != null) {
                if (eqDone) {
                    query.and().eq(Task.PRIORITY, taskLook.getPriority());
                } else {
                    query.eq(Task.PRIORITY, taskLook.getPriority());
                    eqDone = true;
                }
            }
            if (taskLook.getStartDate() != null) {
                if (eqDone) {
                    query.and().eq(Task.STARTDATE, taskLook.getStartDate());
                } else {
                    query.eq(Task.STARTDATE, taskLook.getStartDate());
                    eqDone = true;
                }
            }
            if (taskLook.getStatus() != null) {
                if (eqDone) {
                    query.and().eq(Task.STATUS, taskLook.getStatus());
                } else {
                    query.eq(Task.STATUS, taskLook.getStatus());
                    eqDone = true;
                }
            }
            if (taskLook.getTimeEstimate() != null) {
                if (eqDone) {
                    query.and().eq(Task.TIMEESTIMATE, taskLook.getTimeEstimate());
                } else {
                    query.eq(Task.TIMEESTIMATE, taskLook.getTimeEstimate());
                    eqDone = true;
                }
            }
            if (!eqDone){
                query.isNotNull(Task.ID);
            }
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

    public List<Task> search(String phrase) throws SQLException, IOException {
        List<Task> tmpList = taskDao.queryForAll();
        QueryBuilder<Task,Integer> query = taskDao.queryBuilder();
        List<Task> tmpList2 = new LinkedList<>();
        for(Task el : tmpList){
           if(isTaskContainingAPhrase(el,phrase)){
               tmpList2.add(el);
           }
        }
        return tmpList2;
    }

    private boolean isTaskContainingAPhrase(Task el, String phrase){
        boolean contains = false;

        if(el.getId()!=null){
            contains = contains || el.getId().toString().contains(phrase);
        }
        if(el.getName()!=null){
            contains = contains || el.getName().contains(phrase);
        }
        if(el.getDescription()!=null){
            contains = contains || el.getDescription().contains(phrase);
        }
        if(el.getOwnerId()!=null){
            contains = contains || el.getOwnerId().toString().contains(phrase);
        }
        if(el.getAssignedId()!=null){
            contains = contains || el.getAssignedId().toString().contains(phrase);
        }
        if(el.getTimeEstimate()!=null){
            contains = contains || el.getTimeEstimate().toString().contains(phrase);
        }
        if(el.getPriority()!=null){
            contains = contains || el.getPriority().toString().contains(phrase);
        }
        if(el.getStartDate()!=null){
            contains = contains || el.getStartDate().toString().contains(phrase);
        }
        if(el.getStatus()!=null){
            contains = contains || el.getStatus().toString().contains(phrase);
        }

        return contains;
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
        Task current = taskDao.queryForId(task.getId());
        current.setAssignedId(task.getAssignedId());
        taskDao.update(current);
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
