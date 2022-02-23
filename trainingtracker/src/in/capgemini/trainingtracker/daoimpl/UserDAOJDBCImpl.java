package in.capgemini.trainingtracker.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import in.capgemini.trainingtracker.dao.UserDAO;
import in.capgemini.trainingtracker.exception.UserNotFoundException;
import in.capgemini.trainingtracker.modal.User;
import in.capgemini.trainingtracker.util.DBUtil;

public class UserDAOJDBCImpl extends DBUtil implements UserDAO{

	@Override
	public void save(User user) {
		String sql = "insert into users (name,password,email,loginid) values (?,?,?,?)";
		PreparedStatement pstmt = preparedStatement(sql);
		try {
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getLoginid());
			pstmt.execute();
		} catch (Exception e) {
			System.out.println("Problem is : "+ e.getMessage());
		}
		finally {
			closePreparedStatement();
			closeConnection();
		}
	}

	@Override
	public void update(int id, String toBeUpdated,String updatedValue) {
		String sql = null;
		if(toBeUpdated.equals("email")) {
			sql = "update users set email=? where id=?";
			
		}
		else if(toBeUpdated.equals("password")) {
			sql = "update users set password=? where id=?";
		}
		else if(toBeUpdated.equals("loginid")) {
			sql = "update users set loginid=? where id=?";
		}
		PreparedStatement pstmt = preparedStatement(sql);
		try {
			pstmt.setString(1, updatedValue);
			pstmt.setInt(2, id);
			pstmt.execute();
		} catch (Exception e) {
			System.out.println("Problem is : " + e.getMessage());
		}
		finally {
			closePreparedStatement();
			closeConnection();
		}
		
	}

	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) throws UserNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User show(int id) throws UserNotFoundException {
		String sql = "select * from users";
		PreparedStatement pstmt = preparedStatement(sql);	
		User user = new User();
		ResultSet rs;
		boolean found = false;
		try {

			rs = pstmt.executeQuery();
			while(rs.next()) {
				if(rs.getInt("id") == id) {
					found = true;
					user.setId(rs.getInt("id"));
					user.setName(rs.getString("name"));
					user.setEmail(rs.getString("email"));
					user.setLoginid(rs.getString("loginid"));
					user.setPassword(rs.getString("password"));
				}
			}
			
		} 
		catch (SQLException e) {
		System.out.println("Problem is : " + e.getMessage());
			}
		finally {
		closePreparedStatement();
		closeConnection();
			}
		if(found == true) {
			return user;	
		}
		else {
			throw new UserNotFoundException("user is not found with id : "+id);
		}
	}

}
