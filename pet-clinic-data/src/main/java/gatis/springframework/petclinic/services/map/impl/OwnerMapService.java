package gatis.springframework.petclinic.services.map.impl;

import gatis.springframework.petclinic.model.Owner;
import gatis.springframework.petclinic.model.Pet;
import gatis.springframework.petclinic.services.OwnerService;
import gatis.springframework.petclinic.services.PetService;
import gatis.springframework.petclinic.services.PetTypeService;
import gatis.springframework.petclinic.services.map.AbstractMapService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner owner) {
        if (owner != null) {
            if (owner.getPets() != null) {
                owner.getPets().forEach(pet -> saveOwnerPet(pet, petTypeService, petService));
            }
            return super.save(owner);
        } else return null;
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

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }

    private static void saveOwnerPet(Pet pet, PetTypeService petTypeService, PetService petService) {
        if (pet.getPetType() != null) {
            if (pet.getPetType().getId() == null) {
                pet.setPetType(petTypeService.save(pet.getPetType()));
            }
        } else throw new NullPointerException("Pet Type is required");
        if (pet.getId() == null) {
            Pet savedPet = petService.save(pet);
            pet.setId(savedPet.getId());
        }
    }
}
