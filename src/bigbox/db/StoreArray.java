package bigbox.db;

import java.util.ArrayList;
import bigbox.business.Store;


public class StoreArray implements StoreDAO {
	
	/** The stores. */
	private static ArrayList<Store> stores = null;

	/**
	 * Instantiates a new store array.
	 */
	public StoreArray() {
		stores = getStores();
	}

	/* (non-Javadoc)
	 * @see bigbox.db.StoreReader#getStores()
	 */
	public ArrayList<Store> getStores() {
		if (stores == null)
			setupStoresArray();
		return stores;
	}

	/**
	 * Setup stores array.
	 *
	 * @return the array list
	 */
	private ArrayList<Store> setupStoresArray() {
		stores = new ArrayList<>();
		stores.add(
				new Store(1, "001", "00011", 25000, "Mason BigBox", "5711 Fields Ertel Rd.", "Mason", "OH", "45249"));
		stores.add(
				new Store(2, "001", "00255", 27500, "Downtown BigBox", "9330 Main St.", "Cincinnati", "OH", "45202"));
		stores.add(new Store(3, "001", "00172", 32555.55, "Goshen BigBox", "6777 Goshen Rd.", "Goshen", "OH", "45122"));
		stores.add(new Store(4, "001", "00075", 21425.37, "Bridgetown BigBox", "3888 Race Rd.", "Cincinnati", "OH",
				"45211"));
		stores.add(new Store(5, "111", "00001", 14432.77, "Louisville BigBox", "1111 Washington St.", "Louisville",
				"KY", "40206"));
		stores.add(new Store(6, "111", "00044", 17555.11, "Lawrenceburg BigBox", "8000 Liberty St.", "Louisville", "KY",
				"40204"));
		return stores;
	}

	/* (non-Javadoc)
	 * @see bigbox.db.StoreReader#getAllStoresWithInDivison(java.lang.String)
	 */
	@Override
	public ArrayList<Store> getAllStoresWithInDivison(String inDiv) {
		ArrayList<Store> storesForDiv = new ArrayList<>();
		for (Store s : stores) {
			if (s.getDivisionNumber().equals(inDiv)) {
				storesForDiv.add(s);
			}

		}
		return stores;
	}

	/* (non-Javadoc)
	 * @see bigbox.db.StoreReader#getStore(java.lang.String, java.lang.String)
	 */
	@Override
	public Store getStore(String inDiv, String inStore) {
		for (Store s : stores) {
			if (s.getDivisionNumber().equals(inDiv) && s.getStoreNumber().equals(inStore))
				return s;
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see bigbox.db.StoreWriter#addStore(bigbox.business.Store)
	 */
	@Override
	public boolean addStore(Store s) {
		stores.add(s);

		return this.saveStores();
	}

	/* (non-Javadoc)
	 * @see bigbox.db.StoreWriter#updateStore(bigbox.business.Store)
	 */
	@Override
	public boolean updateStore(Store newStore) {
		// get the old customer and remove it
		Store oldStore = this.getStore(newStore.getDivisionNumber(), newStore.getStoreNumber());
		int i = stores.indexOf(oldStore);
		stores.remove(i);

		// add the updated customer
		stores.add(i, newStore);

		return this.saveStores();

	}

	/* (non-Javadoc)
	 * @see bigbox.db.StoreWriter#deleteStore(bigbox.business.Store)
	 */
	@Override
	public boolean deleteStore(Store s) {
		stores.remove(s);
		return this.saveStores();
	}

	/**
	 * Save stores.
	 *
	 * @return true, if successful
	 */
	private boolean saveStores() {
		return false;
	}

}
