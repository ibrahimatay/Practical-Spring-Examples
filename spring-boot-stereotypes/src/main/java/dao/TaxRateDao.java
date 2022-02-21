package dao;

import model.TaxRate;
import org.springframework.stereotype.Repository;

@Repository
public class TaxRateDao {
    public TaxRate getTaxRate() {
        return new TaxRate();
    }
}
