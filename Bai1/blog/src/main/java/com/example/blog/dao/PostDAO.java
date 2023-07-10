package com.example.blog.dao;

import com.example.blog.model.HistoryDeletePost;
import com.example.blog.model.Post;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PostDAO {
    final String GET_ALL_POST = "" +
            " select * FROM post where statusPost=true order by creationTime desc ";

    final String ADD_POST = "" +
            " insert into post(creationTime,title,image,content,statusPost) values (?,?,?,?,true)";

    final String UPDATE_POST = "" +
            " update post set title=? , image=? , content=? where idPost=? ";
    final String DELETE_POST = "" +
            " update post set statusPost=false where idPost=? ";

    final String ADD_HISTORY_DELETE_POST = "" +
            " INSERT INTO historyDeletePost values (?,?)";

    final String FIND_POST = "" +
            " select * from post where idPost=? ";


    final String RESTORE ="" +
            " update post set statusPost=true where idPost=? ";
    public List<Post> getAllPost() {
        List<Post> postList = new ArrayList<>();
        try (Connection connection = Connect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_POST)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idPost = resultSet.getInt("idPost");
                LocalDateTime creationTime = resultSet.getTimestamp("creationTime").toLocalDateTime();
                String title = resultSet.getString("title");
                String image = resultSet.getString("image");
                String content = resultSet.getString("content");
                postList.add(new Post(idPost, creationTime, title, image, content));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return postList;
    }

    public boolean addPost(Post post) {
        try (Connection connection = Connect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_POST)) {
            preparedStatement.setTimestamp(1, Timestamp.valueOf(LocalDateTime.now()));
            preparedStatement.setString(2, post.getTitle());
            preparedStatement.setString(3, post.getImage());
            preparedStatement.setString(4, post.getContent());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updatePost(Post post) {
        try (Connection connection = Connect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_POST)) {
            preparedStatement.setString(1, post.getTitle());
            preparedStatement.setString(2, post.getImage());
            preparedStatement.setString(3, post.getContent());
            preparedStatement.setInt(4, post.getIdPost());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deletePost(int idPost) {
        try (Connection connection = Connect.getConnection();
             PreparedStatement deletePost = connection.prepareStatement(DELETE_POST);
             PreparedStatement insertHistoryDelete = connection.prepareStatement(ADD_HISTORY_DELETE_POST)) {
            deletePost.setInt(1, idPost);
            insertHistoryDelete.setTimestamp(1, Timestamp.valueOf(LocalDateTime.now()));
            insertHistoryDelete.setInt(2, idPost);
            insertHistoryDelete.execute();
            deletePost.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Post findPostById(int idPost) {
        try (Connection connection = Connect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_POST)) {
            preparedStatement.setInt(1, idPost);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                LocalDateTime creationTime = resultSet.getTimestamp("creationTime").toLocalDateTime();
                String title = resultSet.getString("title");
                String image = resultSet.getString("image");
                String content = resultSet.getString("content");
                return new Post(idPost, creationTime, title, image, content);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void restore(int idPost) {
        try (Connection connection = Connect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(RESTORE)) {
            preparedStatement.setInt(1,idPost);
            preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
