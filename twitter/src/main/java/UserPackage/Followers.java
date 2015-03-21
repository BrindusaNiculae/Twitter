/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserPackage;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Brindusa
 */
public class Followers {

    private final List<User> followers;

    Followers() {
        followers = new ArrayList<User>();
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void addFollower(User user) {
        followers.add(user);
    }

    public void removeFollower(User user) {
        followers.remove(user);
    }

    private boolean alreadyInList(List<String> people, String name) {
        for (String aux : people) {
            if (aux.contains(name)) {
                return true;
            }
        }
        return false;
    }

    private void checkIfNotRepeat(List<String> people, User user, String name) {
        for (User personYouMightKnow : user.getFollowers().getFollowers()) {
            if (!personYouMightKnow.getName().equals(name)
                    && !alreadyInList(people, personYouMightKnow.getName())) {
                people.add("You might know: " + personYouMightKnow.getName() + ".");
            }
        }
    }

    public void editPeopleYouMightKnowList(List<String> people, String name) {
        for (User user : followers) {
            checkIfNotRepeat(people, user, name);
        }

    }
}
