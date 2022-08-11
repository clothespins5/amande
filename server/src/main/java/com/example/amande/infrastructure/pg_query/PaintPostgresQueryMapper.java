package com.example.amande.infrastructure.pg_query;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaintPostgresQueryMapper {

  List<PaintPostgresQueryRecord> selectAll();

}
