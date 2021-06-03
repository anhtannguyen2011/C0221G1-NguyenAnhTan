package services.model.service;

import services.model.bean.RentType;
import services.model.bean.Service;
import services.model.bean.ServiceType;

public interface IServiceService {
    void insertService(Service service);

    public ServiceType findByIdType(int id);

    public RentType findByRentType(int id);
}
