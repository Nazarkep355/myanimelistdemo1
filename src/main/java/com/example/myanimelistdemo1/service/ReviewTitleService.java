package com.example.myanimelistdemo1.service;

import com.example.myanimelistdemo1.entity.Title;
import com.example.myanimelistdemo1.entity.User;
import com.example.myanimelistdemo1.repos.TitleDAO;
import com.example.myanimelistdemo1.repos.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewTitleService {
    @Autowired
    private TitleDAO titleDAO;
    @Autowired
    private UserDAO userDAO;

    public void leaveReview(double rating ,Title title, User user){
        List<Double> reviews = titleDAO.reviewsByTitle(title.getId());
        reviews.add(rating);
        reviews.add(title.getRating());
        double newRating = (reviews.stream()
                .mapToDouble(Double::doubleValue)
                .sum())/reviews.size();
        title.setRating(newRating);
        user.getWatchList().add(title);
        user.getRatingList().put(title,rating);
        titleDAO.save(title);
        userDAO.save(user);
        }
        public void mockReview(double rating, long userId,long titleId){
            Title title = titleDAO.findById(titleId).get();
            User user = userDAO.findById(userId).get();
            leaveReview(rating,title,user);
        }
}
