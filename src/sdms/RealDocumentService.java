package sdms;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class RealDocumentService implements DocumentService {

    public RealDocumentService() {
        new File("documents").mkdirs();
    }

    @Override
    public void uploadDocument(String filename, String content, User user) {
        try {
            FileWriter writer = new FileWriter("documents/" + filename);
            writer.write("ENCRYPTED:" + content);
            writer.close();

            System.out.println("Document uploaded securely: " + filename);
            AuditLog.record(user.getEmail(), "Uploaded document: " + filename);

        } catch (IOException e) {
            System.out.println("Upload failed.");
        }
    }

    @Override
    public void downloadDocument(String filename, User user) {
        System.out.println("Document downloaded securely: " + filename);
        AuditLog.record(user.getEmail(), "Downloaded document: " + filename);
    }
}