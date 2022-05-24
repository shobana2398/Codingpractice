package banking.dao;

public interface UserCreationDao {
	
	public boolean createUser(int userid,String password);
	
	public boolean updatePassword(int userid,String oldPassword,String newPassword);

	
}
