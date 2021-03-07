package com.company.repository;

import com.company.database.interfaces.IDB;
import com.company.entities.Necklace;
import com.company.entities.Stone;
import com.company.repository.interfaces.IUserRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    private final IDB db;

    public UserRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean addStone(Stone stone) {
        Connection connection = null;
        try {
            connection = db.getConnection();
            String sql = "INSERT INTO Stones(name, price, weight)" +
                    "VALUES(?,?,?)";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1,stone.getName());
            ps.setInt(2,stone.getPrice());
            ps.setInt(3,stone.getWeight());

            boolean executed = ps.execute();
            return executed;


        } catch (Exception e1) {
            System.out.println(e1.getMessage());
        }finally {
            try {
                connection.close();
            } catch (Exception e2) {
                System.out.println(e2.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean deleteStone(int id) {
        Connection connection = null;
        try {
            connection = db.getConnection();

            String sql = "DELETE FROM Stones WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            boolean executed = ps.execute();
            return executed;

        } catch (Exception e1) {
            System.out.println(e1.getMessage());
        }finally {
            try {
                connection.close();
            }catch (Exception e2){
                System.out.println(e2.getMessage());
            }
        }
        return false;
    }

    @Override
    public Stone getStoneById(int id) {
        Connection connection = null;

        try {
            connection = db.getConnection();
            String sql = "SELECT id, name, ";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Stone stone = new Stone(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getInt("weight"));
                return stone;
            }

        } catch (Exception e1) {
            System.out.println(e1.getMessage());
        }finally {
            try {
                connection.close();
            } catch (Exception e2) {
                System.out.println(e2.getMessage());
            }
        }
        return null;
    }

    @Override
    public String getNecklaceById(int id) {
        Connection connection = null;
        try {
            connection = db.getConnection();
            String sql = "SELECT id, name, weight, price, stones" +
                    "FROM Necklace" +
                    "WHERE id = ?";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, id);

            List<String> stones = new ArrayList<String>();

            ResultSet resultset = ps.executeQuery();
            if(resultset.next()){
                String output = resultset.getInt("id")+
                        resultset.getString("name")+
                        resultset.getString("stones")+
                        resultset.getInt("weight")+
                        resultset.getInt("price");
                return output;
            }


        } catch (Exception e1) {
            System.out.println(e1.getMessage());
        } finally {
            try {
                connection.close();
            }
            catch (Exception e2){
                System.out.println(e2.getMessage());
            }
        }
        return "something went wrong";
    }

    @Override
    public boolean createNecklace(Necklace necklace,int amountOfStones ) {
        Connection connection = null;
        try {
            connection = db.getConnection();

            List<Stone> stones = new ArrayList<>();

            for(int i = 0;i < amountOfStones; i++){
                String sql = "SELECT id, name, price, weight " +
                        "FROM Stones " +
                        "WHERE id = ?";
                PreparedStatement ps = connection.prepareStatement(sql);

                ps.setInt( 1, i);

                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    Stone stone = new Stone(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("price"),
                            rs.getInt("weight"));
                    stones.add(stone);
                }

                }
            String sql ="INSERT INTO employee(name, stones,weight,price) VALUES (?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, necklace.getName());
            statement.setArray(2, (Array) stones);
            statement.setInt(3,necklace.getWeight());
            statement.setInt(4,necklace.getPrice());

            boolean executed = statement.execute();

            return executed;

        } catch (Exception e1) {
            System.out.println(e1.getMessage());
        }finally {
            try {
                connection.close();
            }catch (Exception e2){
                System.out.println(e2.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean deleteNecklace(int id) {
        Connection connection = null;
        try {
            connection = db.getConnection();
            String sql = "DELETE FROM Necklace WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1,id);

            boolean executed = ps.execute();
            return executed;
        } catch (Exception e1) {
            System.out.println(e1.getMessage());
        }finally {
            try {
                connection.close();
            }catch (Exception e2){
                System.out.println(e2.getMessage());
            }
        }
        return false;
    }
}
