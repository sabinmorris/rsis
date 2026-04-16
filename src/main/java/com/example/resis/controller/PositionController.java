package com.example.resis.controller;

import com.example.resis.dto.InsertPositionDto;
import com.example.resis.model.Position;
import com.example.resis.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/position")
public class PositionController {

    @Autowired
    private PositionService positionService;

    @PostMapping
    public Position insertPosition(@RequestBody  InsertPositionDto req){

        return positionService.insertPosition(req);
    }

    @GetMapping
    public List<Position> selectAllPosition(){
        return positionService.selectAllPosition();
    }

    @GetMapping("/{id}")
    public Optional<Position> selectById(@PathVariable Long id){
        return positionService.selectById(id);
    }

    @PutMapping("/{id}")
    public Position updatePosition(@RequestBody InsertPositionDto req,@PathVariable Long id){
        return positionService.updatePosition(req,id);
    }
}
