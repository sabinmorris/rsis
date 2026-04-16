package com.example.resis.service;

import com.example.resis.dto.InsertPositionDto;
import com.example.resis.model.Position;
import com.example.resis.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PositionService {

    @Autowired
    private PositionRepository positionRepository;

    public Position insertPosition(InsertPositionDto req) {
        Position position = new Position();
        position.setPositionName(req.getPositionName());
        position.setCreatedAt(LocalDateTime.now());
        position.setCreatedBy(1L);
        return positionRepository.save(position);
    }

    public List<Position> selectAllPosition(){
        return positionRepository.findAll();
    }

    public Optional<Position> selectById(Long id){
        return positionRepository.findById(id);
    }

    public Position updatePosition(InsertPositionDto req,Long id) {

        Optional<Position> position = positionRepository.findById(id);

        if(position.isPresent()) {

            Position position1 = position.get();
            position1.setPositionName(req.getPositionName());
            position1.setUpdatedAt(LocalDateTime.now());
            position1.setUpdatedBy(1L);
            return positionRepository.save(position1);
        }else{
            return null;
        }
    }


}
