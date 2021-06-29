package com.xingxin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author liuxh
 * @since 2021-06-25
 */
@TableName("cinema")
public class Cinema implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer id;

    private String movie;

    private String description;

    private Float rating;

    public Cinema() {
    }

    public Cinema(Integer id, String movie, String description, Float rating) {
        this.id = id;
        this.movie = movie;
        this.description = description;
        this.rating = rating;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Cinema{" +
        "id=" + id +
        ", movie=" + movie +
        ", description=" + description +
        ", rating=" + rating +
        "}";
    }
}
