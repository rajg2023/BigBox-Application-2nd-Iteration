package bigbox.db;

import java.util.ArrayList;
import bigbox.business.Store;

public interface StoreReader {

	Store getStore(String inDiv, String inStore);

	ArrayList<Store> getStores();

	ArrayList<Store> getAllStoresWithInDivison(String inDiv);

}
