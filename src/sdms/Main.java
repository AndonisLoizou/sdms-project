package sdms;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        AuthService authService = new AuthService();
        DocumentService documentService = new SecurityProxy();

        System.out.println("=== Secure Document Management System ===");

        System.out.print("Email: ");
        String email = input.nextLine();

        System.out.print("Password: ");
        String password = input.nextLine();

        if (!authService.validateCredentials(email, password)) {
            System.out.println("Login failed.");
            return;
        }

        authService.generateOtp(email);

        System.out.print("Enter OTP: ");
        String otp = input.nextLine();

        if (!authService.verifyOtp(email, otp)) {
            System.out.println("Invalid OTP.");
            return;
        }

        User user = authService.getUser(email);
        user.setActiveSession(true);

        AuditLog.record(user.getEmail(), "Successful login");

        System.out.println("Login successful. Welcome " + user.getRole());

        System.out.println("\n1. Upload document");
        System.out.println("2. Download document");
        System.out.print("Choose option: ");

        String option = input.nextLine();

        if (option.equals("1")) {
            System.out.print("Filename: ");
            String filename = input.nextLine();

            System.out.print("Document content: ");
            String content = input.nextLine();

            documentService.uploadDocument(filename, content, user);

        } else if (option.equals("2")) {
            System.out.print("Filename: ");
            String filename = input.nextLine();

            documentService.downloadDocument(filename, user);
        }

        user.setActiveSession(false);
        AuditLog.record(user.getEmail(), "Logged out");

        input.close();
    }
}