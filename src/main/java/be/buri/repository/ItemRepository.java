package be.buri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import be.buri.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
