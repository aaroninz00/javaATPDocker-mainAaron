package com.microservices.MicroserviceDemo.repository;


import com.microservices.MicroserviceDemo.model.SomeTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.transaction.Transactional;

@Repository
@Transactional
@EnableTransactionManagement
public interface SomeTableRepository extends JpaRepository<SomeTable,Integer> {


}