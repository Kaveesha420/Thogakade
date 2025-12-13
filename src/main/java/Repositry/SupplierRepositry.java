package Repositry;

import Model.dto.SupplierDto;
import java.util.List;

public interface SupplierRepositry {
    void addSuplier(SupplierDto supplier);
    void updateSuplier(SupplierDto supplier);
    void deleteSuplier(String supId);
    List<SupplierDto> getAllSupllier();
}