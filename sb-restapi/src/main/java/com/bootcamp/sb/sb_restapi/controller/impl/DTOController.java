package com.bootcamp.sb.sb_restapi.controller.impl;

import org.hibernate.annotations.DialectOverride.OverridesAnnotation;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.sb.sb_restapi.controller.DTOOperation;
import com.bootcamp.sb.sb_restapi.model.UserPostDTO;
import com.bootcamp.sb.sb_restapi.model.mapping.Mapper;
import com.bootcamp.sb.sb_restapi.service.DTOService;
import com.bootcamp.sb.sb_restapi.service.PostService;
import com.bootcamp.sb.sb_restapi.service.UserService;

@RestController
public class DTOController implements DTOOperation {
  @Autowired
  private DTOService dtoService;

  @Override
  public UserPostDTO getUserPostDTO(String userId, String postId) {
    return dtoService.getUserPostDTO(Long.parseLong(userId), Long.parseLong(postId));
  }
}
