package bigbox.db;

public class StoreDAOFactory {

	// this method maps the ProductDAO interface to the appropriate data storage
	// mechanism
	public static StoreArray getStoreDAO() 
	{
		StoreArray sDAO = new StoreArray();
		return sDAO;
	}

}
