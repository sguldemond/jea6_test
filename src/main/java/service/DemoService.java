package service;

import dao.ProfileDao;
import dao.ProfileDaoImpl;
import domain.Profile;

import java.util.List;

/**
 * Created by stasiuz on 16/02/2018.
 */
public class DemoService {

    private ProfileDao profileDao;

    public DemoService() {
        profileDao = new ProfileDaoImpl();
    }

    public Profile addProfile(Profile p) {
        return profileDao.create(p);
    }

    public List<Profile> getProfiles() {
        return profileDao.getAll();
    }

    public Profile find(String username) {
        return profileDao.find(username);
    }
}
