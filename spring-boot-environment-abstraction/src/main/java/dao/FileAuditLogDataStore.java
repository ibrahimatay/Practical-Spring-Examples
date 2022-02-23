package dao;

import annotation.DevProfile;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
//@Profile("dev")
@DevProfile
public class FileAuditLogDataStore implements AuditLogDataStore{
    @Override
    public void write() {
        System.out.println("FileAuditLogDataStore");
    }
}
