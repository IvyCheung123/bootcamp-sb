package com.bootcamp.sb.sb_restapi.service;

import org.springframework.stereotype.Service;
import com.bootcamp.sb.sb_restapi.model.UserPostDTO;

public interface DTOService {
  UserPostDTO getUserPostDTO(Long userId, Long postId);
}
