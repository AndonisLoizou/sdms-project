package sdms;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class AuthService {
    private Map<String, User> users = new HashMap<>();
    private Map<String, String> otpStore = new HashMap<>();

    public AuthService() {
        users.put("engineer@techbuild.local",
                new User("U001", "engineer@techbuild.local", "Password123", "Engineer"));

        users.put("manager@techbuild.local",
                new User("U002", "manager@techbuild.local", "Password123", "Manager"));
    }

    public boolean validateCredentials(String email, String password) {
        User user = users.get(email);

        if (user == null) {
            return false;
        }

        if (user.hasActiveSession()) {
            System.out.println("Only one active session is allowed.");
            return false;
        }

        return user.checkPassword(password);
    }

    public String generateOtp(String email) {
        String otp = String.valueOf(100000 + new Random().nextInt(900000));
        otpStore.put(email, otp);
        System.out.println("OTP sent to email: " + otp);
        return otp;
    }

    public boolean verifyOtp(String email, String otp) {
        return otp.equals(otpStore.get(email));
    }

    public User getUser(String email) {
        return users.get(email);
    }
}