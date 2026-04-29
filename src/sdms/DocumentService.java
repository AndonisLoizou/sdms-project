package sdms;

public interface DocumentService {
    void uploadDocument(String filename, String content, User user);
    void downloadDocument(String filename, User user);
}