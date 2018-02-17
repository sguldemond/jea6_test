package dao;

import domain.Profile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stasiuz on 16/02/2018.
 */
public class ProfileDaoImpl implements ProfileDao {

    private List<Profile> profiles;

    public ProfileDaoImpl() {
        profiles = new ArrayList<Profile>();
    }

    public Profile create(Profile p) {
        profiles.add(p);
        return p;
    }

    public List<Profile> getAll() {
        return profiles;
    }

    public Profile find(String username) {
        for(Profile p : profiles) {
            if(p.getUsername().equals(username)) {
                return p;
            }
        }

        return null;
    }
}
