package gatis.springframework.petclinic.services.map.impl;

import gatis.springframework.petclinic.model.Owner;
import gatis.springframework.petclinic.services.CrudService;
import gatis.springframework.petclinic.services.map.AbstractMapService;

import java.util.Set;

public class OwnerMapService extends AbstractMapService<Owner, Long> implements CrudService<Owner, Long>{

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner owner) {
        return super.save(owner.getId(), owner);
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner owner) {
        super.delete(owner);
    }
}
