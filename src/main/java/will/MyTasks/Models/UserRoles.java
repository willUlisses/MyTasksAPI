package will.MyTasks.Models;

public enum UserRoles {
    USER("ROLE_USER"), ADMIN("ROLE_ADMIN");

    private String role;
    UserRoles(String role) {
        this.role = role;
    }
    public String getRole() {
        return role;
    }
}
