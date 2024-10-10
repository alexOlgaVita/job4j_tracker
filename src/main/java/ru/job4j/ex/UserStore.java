package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User result = null;
        for (User user : users) {
            if (login.equals(user.getUsername())) {
                result = user;
                break;
            }
        }
        return result;
    }

    public static boolean validate(User user) throws UserInvalidException {
        boolean valid = user.isValid();
        if (!valid || user.getUsername().length() < 3) {
            throw new UserInvalidException("Пользователь с логином " + user.getUsername() + " не валидный");
        }
        return valid;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
            User user = findUser(users, "Pe");
            if (user == null) {
                throw new UserNotFoundException("Пользователь с логином " + users[0].getUsername() + " не найден");
            }
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException ea) {
            ea.printStackTrace();
        } catch (UserNotFoundException en) {
            en.printStackTrace();
        }
    }
}
