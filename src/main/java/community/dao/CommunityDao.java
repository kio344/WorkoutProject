package community.dao;

public class CommunityDao {

	private CommunityDao instance;
	
	private CommunityDao() {}
	
	public CommunityDao getInstance() {
		
		if(instance == null) {
			instance = new CommunityDao();
		}

		return instance;
	}
}

