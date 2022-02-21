package service;

import dao.TaxRateDao;
import model.TaxRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaxRateService {
    private final TaxRateDao taxRateDao;

    @Autowired
    public TaxRateService(TaxRateDao taxRateDao) {
        this.taxRateDao = taxRateDao;
    }

    public TaxRate getTaxRate() { return taxRateDao.getTaxRate(); }
}
