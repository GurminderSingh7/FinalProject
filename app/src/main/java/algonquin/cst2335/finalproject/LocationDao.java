package algonquin.cst2335.finalproject;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

/**
 * Data Access Object (DAO) for managing CRUD operations for the Location entity.
 *
 * @author Aditya Hirpara
 */
@Dao
public interface LocationDao {

    /**
     * Inserts a new Location into the database.
     *
     * @param location The Location object to be inserted.
     */
    @Insert
    void insert(Location location);

    /**
     * Deletes a Location from the database by its ID.
     *
     * @param id The unique identifier of the Location to be deleted.
     */
    @Query("DELETE FROM location_table WHERE id = :id")
    void delete(int id);

    /**
     * Retrieves all Location entries from the database.
     *
     * @return A list of Location objects representing all entries in the location_table.
     */
    @Query("SELECT * FROM location_table")
    List<Location> getAllLocations();
}
