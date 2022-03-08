package dao;

public interface AuditDAO {
    public void writeAuditEntry(String entry) throws PersistenceException;
}
