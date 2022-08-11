package com.example.amande.infrastructure.pg_repository.paint;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaintPostgresMapper {
  void insert();
}
