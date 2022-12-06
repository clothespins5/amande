package com.amande.infrastructure.query.paint;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaintQueryMapper {

  List<PaintQueryRecord> selectAll();

}
