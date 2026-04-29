package sdms;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class AuditLog {

    public static void record(String userEmail, String action) {
        try {
            FileWriter writer = new FileWriter("audit-log.txt", true);

            writer.write(LocalDateTime.now()
                    + " | "
                    + userEmail
                    + " | "
                    + action
                    + "\n");

            writer.close();

        } catch (IOException e) {
            System.out.println("Audit log failed.");
        }
    }
}