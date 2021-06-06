package services.model.service.Impl;

import services.model.bean.RentType;
import services.model.bean.Service;
import services.model.bean.ServiceType;
import services.model.repository.RentTypeRepository;
import services.model.repository.ServiceRepository;
import services.model.repository.ServiceTypeRepository;
import services.model.service.IServiceService;

import java.util.List;

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

    @Override
    public List<Service> selectAllService() {
        return serviceRepository.selectAllService();
    }

    @Override
    public Service selectService(int id) {
        return serviceRepository.selectService(id);
    }

    @Override
    public List<ServiceType> selectAllTypeService() {
        return serviceTypeRepository.selectAllServiceTyype();
    }

    @Override
    public boolean updateService(Service service) {
        return serviceRepository.updateService(service);
    }

    @Override
    public List<RentType> selectAllRentType() {
        return rentTypeRepository.selectAllRentType();
    }

    @Override
    public boolean deleteService(int id) {
        return serviceRepository.deleteService(id);
    }


}
