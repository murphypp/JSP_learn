package com.ucar.training.dao.impl;

//public class MessageDaoImpl implements IMessageDao {
public class MessageDaoImpl {
    //private static List<Message> messages = new ArrayList<>();

    /*
    private Connection getConnection() throws SQLException {
        return DBUtil.getConnection();
    }

    @Override
    public void addMessage(Message m) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert message values (?,?,?,?);");
            preparedStatement.setString(1,m.getId());
            preparedStatement.setString(2,m.getAuthor());
            preparedStatement.setString(3,m.getTime());
            preparedStatement.setString(4,m.getContent());
            preparedStatement.executeUpdate();
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //messages.addUser(m);
    }

    @Override
    public void delMessage(String ID) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from message where id=?");
            preparedStatement.setString(1,ID);
            preparedStatement.executeUpdate();
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //messages.remove(m);
    }

    @Override
    public List<Message> getAllMessage(){
        List<Message> messages = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from message");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Message m = new Message();
                m.setId(resultSet.getString(1));
                m.setAuthor(resultSet.getString(2));
                m.setTime(resultSet.getString(3));
                m.setContent(resultSet.getString(4));
                messages.add(m);
            }
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return messages;
    }

    @Override
    public List<Message> getUserMessages(String username) {
        List<Message> UserMessages = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from message where author=?");
            preparedStatement.setString(1,username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Message m = new Message();
                m.setId(resultSet.getString(1));
                m.setAuthor(resultSet.getString(2));
                m.setTime(resultSet.getString(3));
                m.setContent(resultSet.getString(4));
                UserMessages.add(m);
            }
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return UserMessages;
    }

    @Override
    public void delUserMessages(String username) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from message where author=?");
            preparedStatement.setString(1,username);
            preparedStatement.executeUpdate();
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     */

}
