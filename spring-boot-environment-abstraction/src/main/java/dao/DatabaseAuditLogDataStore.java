package dao;

import annotation.ProdProfile;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
//@Profile("prod")
@ProdProfile
public class DatabaseAuditLogDataStore implements AuditLogDataStore{
    @Override
    public void write() {
        System.out.println("DatabaseAuditLogDataStore");
    }
}
