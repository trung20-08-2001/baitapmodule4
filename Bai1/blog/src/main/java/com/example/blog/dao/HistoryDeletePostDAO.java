package com.example.blog.dao;

import com.example.blog.model.HistoryDeletePost;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HistoryDeletePostDAO {

    final String DELETED_POST="" +
            " select * from historyDeletePost " +
            " join post on historyDeletePost.idPost = post.idPost " +
            " order by deleteTime desc ";

    final String RESTORE="" +
            " delete from historyDeletePost where idPost=? ";
    public List<HistoryDeletePost> getDeletePost(){
        List<HistoryDeletePost> deletedPostList=new ArrayList<>();
        try(Connection connection=Connect.getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement(DELETED_POST)){
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                int idPost=resultSet.getInt("idPost");
                LocalDateTime creationTime=resultSet.getTimestamp("creationTime").toLocalDateTime();
                String title=resultSet.getString("title");
                String image=resultSet.getString("image");
                String content=resultSet.getString("content");
                LocalDateTime deleteTime=resultSet.getTimestamp("deleteTime").toLocalDateTime();
                deletedPostList.add(new HistoryDeletePost(idPost,creationTime,title,image,content,deleteTime));
                System.out.println(new HistoryDeletePost(idPost,creationTime,title,image,content,deleteTime));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return deletedPostList;
    }

    public void restore(int idPost){
        try(Connection connection=Connect.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(RESTORE)){
            preparedStatement.setInt(1,idPost);
            preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
