package project2;

public class ErrorConstants {
    // Private constructor to prevent instantiation
    private ErrorConstants() {
    }

    // Singleton instance
    private static ErrorConstants instance = new ErrorConstants();

    // Get the singleton instance
    public static ErrorConstants getInstance() {
        return instance;
    }

    // Define your error constants here
    public final String ERROR_INVALID_EMAIL = "Invalid email format.";
    public final String ERROR_SHORT_PASSWORD = "Password must be at least 6 characters long.";
    public final String ERROR_USER_NOT_FOUND = "User not found.";
    public final String ERROR_WRONG_PASSWORD = "Incorrect password.";
    public final String LOGIN_SUCCESS ="Success login!";
    public final String REGISTER_SUCCESS ="Register success!";
    // Add more error constants as needed
}
