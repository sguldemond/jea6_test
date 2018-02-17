package dao;

import domain.Profile;

import java.util.List;

/**
 * Created by stasiuz on 16/02/2018.
 */
public interface ProfileDao {

    Profile create(Profile p);

    List<Profile> getAll();

    Profile find(String username);
}
