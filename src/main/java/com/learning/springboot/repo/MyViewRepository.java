package com.learning.springboot.repo;

import com.learning.springboot.service.MyViewDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyViewRepository extends CrudRepository<MyViewDTO, Integer> {

}
