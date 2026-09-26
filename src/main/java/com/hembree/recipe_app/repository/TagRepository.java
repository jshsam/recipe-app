package com.hembree.recipe_app.repository;

import com.hembree.recipe_app.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}