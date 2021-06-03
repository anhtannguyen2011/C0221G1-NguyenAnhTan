package services.model.service.Impl;

import services.model.bean.RentType;
import services.model.bean.Service;
import services.model.bean.ServiceType;
import services.model.repository.RentTypeRepository;
import services.model.repository.ServiceRepository;
import services.model.repository.ServiceTypeRepository;
import services.model.service.IServiceService;

public class ServiceServiceImpl implements IServiceService {
    ServiceRepository serviceRepository = new ServiceRepository();
    RentTypeRepository rentTypeRepository = new RentTypeRepository();
    ServiceTypeRepository serviceTypeRepository = new ServiceTypeRepository();

    @Override
    public void insertService(Service service) {
        serviceRepository.insertService(service);
    }

    @Override
    public ServiceType findByIdType(int id) {
        return serviceTypeRepository.findByIdType(id);
    }

    @Override
    public RentType findByRentType(int id) {
        return rentTypeRepository.findByRentType(id);
    }


}
