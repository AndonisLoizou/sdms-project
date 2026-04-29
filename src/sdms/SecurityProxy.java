package sdms;

public class SecurityProxy implements DocumentService {
    private RealDocumentService realDocumentService = new RealDocumentService();

    @Override
    public void uploadDocument(String filename, String content, User user) {
        if (!validateFile(filename, content)) {
            System.out.println("Upload rejected: malicious or invalid file detected.");
            AuditLog.record(user.getEmail(), "Rejected unsafe upload: " + filename);
            return;
        }

        realDocumentService.uploadDocument(filename, content, user);
    }

    @Override
    public void downloadDocument(String filename, User user) {
        realDocumentService.downloadDocument(filename, user);
    }

    private boolean validateFile(String filename, String content) {
        if (filename.endsWith(".exe") || filename.endsWith(".bat")) {
            return false;
        }

        String lowerContent = content.toLowerCase();

        return !(lowerContent.contains("<script>")
                || lowerContent.contains("macro")
                || lowerContent.contains("malware"));
    }
}