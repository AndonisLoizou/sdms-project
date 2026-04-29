# Secure Document Management System

This project is a prototype Secure Document Management System for TechBuild Engineering.

The system supports:
- User login with email-based MFA
- One active session per user
- Secure document upload and download
- Security proxy validation and sanitisation
- Malicious file rejection
- Document encryption at rest
- Document reservation
- Audit logging and activity reporting

## Scenario

The project is based on Scenario 3: Secure Document Management System. The system must store, manage and share sensitive engineering documents while maintaining confidentiality, integrity and availability.

## How to Run

```bash
javac -d out src/sdms/*.java
java -cp out sdms.SdmsServer

Open:
http://localhost:8080

Demo Login Details
Email: engineer@techbuild.local
Password: Password123
