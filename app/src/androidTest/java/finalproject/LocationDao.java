package finalproject;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface LocationDao {
    @Insert
    void insert(Location location);

    @Query("DELETE FROM location_table WHERE id = :id")
    void delete(int id);

    @Query("SELECT * FROM location_table")
    List<Location> getAllLocations();
}


