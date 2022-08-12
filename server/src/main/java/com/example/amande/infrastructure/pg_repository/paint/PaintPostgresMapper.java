package com.example.amande.infrastructure.pg_repository.paint;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaintPostgresMapper {
  PaintPostgresRecord selectByID(Integer id);

  int insert(String productNumber, String colorName, String colorCode);

  int delete(Integer id);
}
