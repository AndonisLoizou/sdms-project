package sdms;

public class User {
    private String userId;
    private String email;
    private String password;
    private String role;
    private boolean activeSession;

    public User(String userId, String email, String password, String role) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.role = role;
        this.activeSession = false;
    }

    public String getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public boolean checkPassword(String inputPassword) {
        return password.equals(inputPassword);
    }

    public boolean hasActiveSession() {
        return activeSession;
    }

    public void setActiveSession(boolean activeSession) {
        this.activeSession = activeSession;
    }
}