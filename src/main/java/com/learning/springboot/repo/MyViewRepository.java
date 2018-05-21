package com.learning.springboot.repo;

import com.learning.springboot.model.MyView;
import org.springframework.data.repository.CrudRepository;

public interface MyViewRepository extends CrudRepository<MyView, Integer> {

}
