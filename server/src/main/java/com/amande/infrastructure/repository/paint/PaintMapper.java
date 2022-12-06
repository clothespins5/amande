package com.amande.infrastructure.repository.paint;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaintMapper {
  PaintRecord selectByID(Integer id);

  int insert(String productNumber, String colorName, String colorCode);

  int delete(Integer id);
}
