package com.demo.cinemamicroservice.cinemaservice.services;

import com.demo.cinemamicroservice.cinemaservice.models.BaseModel;
import org.springframework.stereotype.Service;

@Service
public class BaseService<Model extends BaseModel, Repository> {
}
