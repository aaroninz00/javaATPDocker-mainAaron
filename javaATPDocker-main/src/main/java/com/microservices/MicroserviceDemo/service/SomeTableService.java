package com.microservices.MicroserviceDemo.service;

import com.microservices.MicroserviceDemo.model.SomeTable;
import com.microservices.MicroserviceDemo.repository.SomeTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SomeTableService {

    @Autowired
    private SomeTableRepository someTableRepository;
    
    public List<SomeTable> findAll(){
        List<SomeTable> todoItems = someTableRepository.findAll();
        return todoItems;
    }
    public ResponseEntity<SomeTable> getItemById(int id){
        Optional<SomeTable> todoData = someTableRepository.findById(id);
        if (todoData.isPresent()){
            return new ResponseEntity<>(todoData.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    public SomeTable addSomeTable(SomeTable someTable){
        return someTableRepository.save(someTable);
    }

    public boolean deleteSomeTable(int id){
        try{
            someTableRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public SomeTable updateSomeTable(int id, SomeTable td){
        Optional<SomeTable> someTableData = someTableRepository.findById(id);
        if(someTableData.isPresent()){
            SomeTable someTable = someTableData.get();
            someTable.setID(id);
            someTable.setCreation_ts(td.getCreation_ts());
            someTable.setDescription(td.getDescription());
            someTable.setDone(td.isDone());
            return someTableRepository.save(someTable);
        }else{
            return null;
        }
    }

}